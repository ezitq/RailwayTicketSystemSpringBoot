package com.bohdan.entity;

import com.bohdan.entity.dto.RouteSegmentDto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "route_segments")
public class RouteSegment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route; // До якого загального маршруту належить

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station; // Станція А

    @Column(name = "seq_order")
    private int sequenceOrder; // Порядковий номер (1, 2, 3...)

    @Column(name = "arrival_time")
    private LocalTime arrivalTime; // Час у дорозі на цьому відрізку

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "base_price")
    private BigDecimal basePrice; // Базова вартість цього шматочка дороги

    public RouteSegment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public int getSequenceOrder() {
        return sequenceOrder;
    }

    public void setSequenceOrder(int sequenceOrder) {
        this.sequenceOrder = sequenceOrder;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public RouteSegmentDto toDto(){
        return new RouteSegmentDto(
                id,
                route.getId(),
                station.getId(),
                sequenceOrder,
                arrivalTime,
                departureTime,
                basePrice
        );
    }
}
