package com.bohdan.controller;

import com.bohdan.entity.Train;
import com.bohdan.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    private final RouteService routeService;

    public TrainController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/route/{routeId}")
    public ResponseEntity<Train> getTrainByRouteId(@PathVariable int routeId){

        return ResponseEntity.ok(routeService.getTrainByRouteId(routeId));
    }
}
