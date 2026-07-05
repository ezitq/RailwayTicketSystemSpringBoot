package com.bohdan.controller;

import com.bohdan.entity.dto.StationDto;
import com.bohdan.service.StationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StationDto>> findStations(){

        return ResponseEntity.ok(stationService.findLAllStations());
    }

    @GetMapping("/find/{id}")
    public String findStationNameById(@PathVariable String id){

        return stationService.findStationNameById(Integer.parseInt(id));
    }
}
