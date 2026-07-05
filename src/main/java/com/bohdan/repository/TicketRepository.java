package com.bohdan.repository;

import com.bohdan.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    List<Ticket> findTicketByUserId(int userId);

    Ticket findTicketBySeatId(int id);
}
