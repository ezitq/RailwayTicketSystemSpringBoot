package com.bohdan.entity.dto;

import com.bohdan.entity.Route;
import com.bohdan.entity.Station;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalTime;

public class RouteSegmentDto {

    private final Long id;
    private final int routeId; // До якого загального маршруту належить
    private final int stationId; // Станція А
    private final int sequenceOrder; // Порядковий номер (1, 2, 3...)
    private final LocalTime arrivalTime; // Час у дорозі на цьому відрізку
    private final LocalTime departureTime;
    private final BigDecimal basePrice; // Базова в

    public RouteSegmentDto(Long id, int routeId, int stationId, int sequenceOrder, LocalTime arrivalTime, LocalTime departureTime, BigDecimal basePrice) {
        this.id = id;
        this.routeId = routeId;
        this.stationId = stationId;
        this.sequenceOrder = sequenceOrder;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.basePrice = basePrice;
    }

    public Long getId() {
        return id;
    }

    public int getRouteId() {
        return routeId;
    }

    public int getStationId() {
        return stationId;
    }

    public int getSequenceOrder() {
        return sequenceOrder;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }
}
