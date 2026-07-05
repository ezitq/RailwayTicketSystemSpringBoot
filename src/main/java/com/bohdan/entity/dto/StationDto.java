package com.bohdan.entity.dto;

public class StationDto {

    private int id;
    private String stationName;

    public StationDto(int id, String stationName) {
        this.id = id;
        this.stationName = stationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
