package com.bohdan.entity.dto;

import com.bohdan.entity.Route;
import com.bohdan.entity.Seat;
import com.bohdan.entity.TicketStatus;
import com.bohdan.entity.User;

public class TicketDto {

    private Integer id;
    private TicketStatus status;
    private Integer userId;
    private Integer seatId;
    private Integer routeId;

    public TicketDto(Integer id, TicketStatus status, Integer userId, Integer seatId, Integer routeId) {
        this.id = id;
        this.status = status;
        this.userId = userId;
        this.seatId = seatId;
        this.routeId = routeId;
    }

    public TicketDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }
}
