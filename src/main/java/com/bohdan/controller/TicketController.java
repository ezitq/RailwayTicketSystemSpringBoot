package com.bohdan.controller;

import com.bohdan.entity.Seat;
import com.bohdan.entity.dto.SeatResponseDto;
import com.bohdan.entity.dto.TicketDto;
import com.bohdan.service.SeatService;
import com.bohdan.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/seat")
public class TicketController {

    private final TicketService ticketService;
    private final SeatService seatService;

    @Autowired
    public TicketController(TicketService ticketService, SeatService seatService) {

        this.ticketService = ticketService;
        this.seatService = seatService;
    }

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@RequestBody TicketDto ticketDto) {
        try {

            ticketService.bookTicket(ticketDto);
            return ResponseEntity.ok("Місце успішно заброньовано!");

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buyTicket(@RequestBody TicketDto ticketDto) {
        try {

            ticketService.buyTicket(ticketDto);
            return ResponseEntity.ok("Місце успішно придбано!");

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
//
//    @GetMapping("/available")
//    public ResponseEntity<List<SeatResponseDto>> findAvailableSeats(@RequestParam int trainId) {
//        List<Seat> availableSeats = seatService.findAllAvailableSeats(trainId);
//        List<SeatResponseDto> seatResponseDtos = availableSeats.stream()
//                .map(seat -> new SeatResponseDto(seat.getId(), seat.getNumberOfSeat(), trainId))
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(seatResponseDtos);
//    }
//
//    @GetMapping("/book")
//    public ResponseEntity<List<SeatResponseDto>> findBookedSeats(@RequestParam int trainId) {
//        List<Seat> bookedSeats = seatService.findAllBookedSeats(trainId);
//        List<SeatResponseDto> seatResponseDtos = bookedSeats.stream()
//                .map(seat -> new SeatResponseDto(seat.getId(), seat.getNumberOfSeat(), trainId))
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(seatResponseDtos);
//    }

//    @GetMapping("/paid")
//    public ResponseEntity<List<SeatResponseDto>> findPaidSeats(@RequestParam int trainId) {
//        List<Seat> paidSeats = seatService.findAllPaidSeats(trainId);
//        List<SeatResponseDto> seatResponseDtos = paidSeats.stream()
//                .map(seat -> new SeatResponseDto(seat.getId(), seat.getNumberOfSeat(), trainId))
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(seatResponseDtos);
//    }
}
