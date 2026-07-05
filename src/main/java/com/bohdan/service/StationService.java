package com.bohdan.service;

import com.bohdan.entity.dto.StationDto;
import com.bohdan.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public List<StationDto> findLAllStations(){
        return stationRepository.findAll()
                .stream()
                .map(station -> new StationDto(station.getId()
                        , station.getName())
                ).toList();
    }

    public String findStationNameById(int id){

        return stationRepository.findById(id).orElseThrow(IllegalArgumentException::new).getName();

    }
}
