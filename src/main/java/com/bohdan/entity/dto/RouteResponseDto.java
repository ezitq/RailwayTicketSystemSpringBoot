package com.bohdan.entity.dto;

import com.bohdan.entity.DayOfTheWeek;

import java.math.BigDecimal;
import java.time.LocalTime;

public class RouteResponseDto {
    private final int routeId;
    private final String trainName; // Назва маршруту/поїзда (напр. "Львів-Одеса")
    private final String departureStation;
    private final LocalTime departureTime;
    private final String arrivalStation;
    private final LocalTime arrivalTime;
    private final String duration; // Будемо вираховувати на бекенді
    private final String classType; // Можна захардкодити або брати з поїзда
    private final int availableSeats;
    private final BigDecimal price;
    private final DayOfTheWeek weekDay;

    // Конструктор, геттери
    public RouteResponseDto(int routeId, String trainName, String departureStation, LocalTime departureTime, String arrivalStation, LocalTime arrivalTime, String duration, String classType, int availableSeats, BigDecimal price, DayOfTheWeek weekDay) {
        this.routeId = routeId;
        this.trainName = trainName;
        this.departureStation = departureStation;
        this.departureTime = departureTime;
        this.arrivalStation = arrivalStation;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.classType = classType;
        this.availableSeats = availableSeats;
        this.price = price;
        this.weekDay = weekDay;
    }

    public DayOfTheWeek getWeekDay() {
        return weekDay;
    }

    public int getRouteId() {
        return routeId;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public String getDuration() {
        return duration;
    }

    public String getClassType() {
        return classType;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public BigDecimal getPrice() {
        return price;
    }
}