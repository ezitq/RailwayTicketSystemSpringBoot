package com.bohdan.service;

import com.bohdan.config.TariffProperties;
import com.bohdan.entity.*;
import com.bohdan.entity.dto.RouteResponseDto;
import com.bohdan.repository.RouteRepository;
import com.bohdan.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final StationRepository stationRepository;
    private final SeatService seatService;
    private final TariffProperties tariffProperties;

    @Autowired
    public RouteService(RouteRepository routeRepository, StationRepository stationRepository, SeatService seatService, TariffProperties tariffProperties) {
        this.routeRepository = routeRepository;
        this.stationRepository = stationRepository;
        this.seatService = seatService;
        this.tariffProperties = tariffProperties;
    }

    public List<RouteResponseDto> findRouteByStations(int departureStationId, int arrivalStationId) {

        // 1. Оптимізація запиту до БД: Завантажуємо обидві станції за один прохід
        List<Station> stations = stationRepository.findAllById(List.of(departureStationId, arrivalStationId));

        Map<Integer, String> stationMap = stations.stream()
                .collect(Collectors.toMap(Station::getId, Station::getName));

        String stationFrom = stationMap.get(departureStationId);
        String stationTo = stationMap.get(arrivalStationId);

        if (stationFrom == null || stationTo == null) {
            throw new IllegalArgumentException("Вказані станції не знайдено в базі даних");
        }

        // 2. Отримуємо сирі маршрути з БД
        List<Route> routes = routeRepository.findRoutesBetweenStations(stationFrom, stationTo);

        // 3. Мапимо складну ієрархічну модель у плоский DTO для фронтенду
        return routes.stream()
                .map(route -> convertToResponseDto(route, departureStationId, arrivalStationId, stationFrom, stationTo))
                .filter(Objects::nonNull) // Відсікаємо біті дані, якщо сегменти не знайшлися
                .toList();
    }

    private RouteResponseDto convertToResponseDto(Route route, int depId, int arrId, String depName, String arrName) {
        // Знаходимо сегмент посадки користувача
        RouteSegment depSegment = route.getSegments().stream()
                .filter(s -> s.getStation().getId() == depId)
                .findFirst()
                .orElse(null);

        // Знаходимо сегмент висадки користувача
        RouteSegment arrSegment = route.getSegments().stream()
                .filter(s -> s.getStation().getId() == arrId)
                .findFirst()
                .orElse(null);

        if (depSegment == null || arrSegment == null) {
            return null;
        }

        // Визначаємо час. Якщо departureTime пустий (це перша станція поїзда), беремо arrivalTime
        LocalTime depTime = depSegment.getDepartureTime() != null ? depSegment.getDepartureTime() : depSegment.getArrivalTime();
        LocalTime arrTime = arrSegment.getArrivalTime() != null ? arrSegment.getArrivalTime() : arrSegment.getDepartureTime();

        ComfortType comfortType = route.getTrain().getType();
        BigDecimal multiplier = tariffProperties.multipliers().get(comfortType);

        // Обчислюємо тривалість подорожі на бекенді
        String durationStr = calculateDuration(depTime, arrTime);

        // Ціна (якщо в сегменті null, підставляємо базову ціну за замовчуванням)
        BigDecimal basePrice = depSegment.getBasePrice() != null ? depSegment.getBasePrice() : tariffProperties.baseRate();

        // TODO: Коли додам кілометраж тут поміняти логіку формування ціни

        BigDecimal finalPrice = basePrice.add(multiplier.multiply(BigDecimal.valueOf(arrTime.getHour() - depTime.getHour())));

        return new RouteResponseDto(
                route.getId(),
                route.getName(),
                depName,
                depTime,
                arrName,
                arrTime,
                durationStr,
                "",
                seatService.findAmountOfSeatsByTrainId(route.getTrain().getId()),
                finalPrice,
                route.getDayOfTheWeek()
        );
    }

    private String calculateDuration(LocalTime start, LocalTime end) {
        if (start == null || end == null) return "0 год 00 хв";

        Duration duration = Duration.between(start, end);
        if (duration.isNegative()) {
            // Якщо поїзд приїжджає на наступну добу
            duration = duration.plusDays(1);
        }

        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        return String.format("%d год %02d хв", hours, minutes);
    }

    public Train getTrainByRouteId(int routeId) {

        return routeRepository.findById(routeId)
                .orElseThrow(() -> new IllegalArgumentException("No such route"))
                .getTrain();
    }
}
