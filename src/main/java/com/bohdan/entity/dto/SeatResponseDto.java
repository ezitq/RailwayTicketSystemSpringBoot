package com.bohdan.entity.dto;

public class SeatResponseDto {

    private final int id;
    private final int seatNumber;
    private final int trainId;
    private final String seatType;
    private final String seatStatus;

    public SeatResponseDto(int id, int seatNumber, int trainId, String seatType, String seatStatus) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.trainId = trainId;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }

    public int getId() {
        return id;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getTrainId() {
        return trainId;
    }

    public String getSeatType() {
        return seatType;
    }
}
