package com.bohdan.controller;

import com.bohdan.entity.Train;
import com.bohdan.entity.dto.RouteResponseDto;
import com.bohdan.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;

    }

    @GetMapping("/search")
    public ResponseEntity<List<RouteResponseDto>> findRoutes(@RequestParam(name = "departId", required = false) Integer departureStationId,
                                                             @RequestParam(name = "arrivalId", required = false) Integer arrivalStationId,
                                                             @RequestParam(name = "weekDay", required = false) String weekDay) {

        if (weekDay == null || weekDay.isBlank()) {
            return ResponseEntity.badRequest().build(); // 400, не 500
        }

        List<RouteResponseDto> routes = routeService.findRouteByStations(departureStationId,
                arrivalStationId).stream()
                .filter(route -> route
                        .getWeekDay()
                        .toString()
                        .equalsIgnoreCase(weekDay))
                .toList();

        return ResponseEntity.ok(routes);
    }


}