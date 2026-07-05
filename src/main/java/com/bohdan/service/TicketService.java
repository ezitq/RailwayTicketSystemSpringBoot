package com.bohdan.service;

import com.bohdan.entity.*;
import com.bohdan.entity.dto.TicketDto;
import com.bohdan.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final RouteRepository routeRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, UserRepository userRepository,
                         RouteRepository routeRepository, SeatRepository seatRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.routeRepository = routeRepository;
        this.seatRepository = seatRepository;
    }

    public void bookTicket(TicketDto ticketDto) {

        User user = userRepository.findById(ticketDto.getUserId()).orElse(null);
        Route route = routeRepository.findById(ticketDto.getRouteId()).orElse(null);
        Seat seat = seatRepository.findById(ticketDto.getSeatId()).orElse(null);

        if(ticketDto.getStatus() == TicketStatus.BOOKED
                || ticketDto.getStatus() == TicketStatus.PAID){
            return;
        }

        if(seat != null && ticketRepository.findTicketBySeatId(seat.getId()) != null){
            throw new RuntimeException("Такий квиток вже заброньовано");
        }

        Ticket ticket = new Ticket();

        ticket.setRoute(route);
        ticket.setUser(user);
        ticket.setSeat(seat);

        ticket.setStatus(TicketStatus.BOOKED);

        if(seat != null){
            seat.setStatus(TicketStatus.BOOKED);
        }

        ticketRepository.save(ticket);
    }

    public void buyTicket(TicketDto ticketDto) {

        Ticket ticket = ticketRepository.findById(ticketDto.getId())
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        if (ticket.getStatus() != TicketStatus.BOOKED) {
            throw new RuntimeException("Можна оплатити тільки заброньований квиток");
        }

        ticket.setStatus(TicketStatus.PAID);

        seatRepository.findById(ticket.getId()).ifPresent(seat -> seat.setStatus(TicketStatus.PAID));

        ticketRepository.save(ticket);

    }
}
