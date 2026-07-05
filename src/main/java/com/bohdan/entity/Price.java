package com.bohdan.entity;

public enum Price {
    LOW(30),
    MEDIUM(45),
    HIGH(60);

    private final int price;

    Price(int price) {
        this.price = price;
    }

    public int getValue(){

        return this.price;
    }
}
