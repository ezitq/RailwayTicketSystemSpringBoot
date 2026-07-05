package com.bohdan.controller;

import com.bohdan.entity.dto.SeatResponseDto;
import com.bohdan.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/all/{seatType}/trainId/{trainId}")
    public ResponseEntity<List<SeatResponseDto>> findSeatsByTrainId
            (@PathVariable int trainId,
             @PathVariable String seatType){

        List<SeatResponseDto> seats = new ArrayList<>();
        switch (seatType){
            case "REGULAR" -> seats = seatService.findAllRegularByTrainId(trainId);
            case "KUPE" -> seats = seatService.findAllKupeByTrainId(trainId);
            case "LUX" -> seats = seatService.findAllLuxByTrainId(trainId);

        }

        return ResponseEntity.ok(seats);

    }

    @GetMapping("/count/{seatType}/trainId/{trainId}")
    public ResponseEntity<Integer> countSeatsByStatus(@PathVariable int trainId
            ,@PathVariable String seatType){

        return ResponseEntity.ok(seatService.countSeatsByTrainIdAndSeatType(trainId, seatType));
    }
}
