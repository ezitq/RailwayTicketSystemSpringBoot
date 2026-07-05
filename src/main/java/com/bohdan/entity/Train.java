package com.bohdan.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trains")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seats_amount")
    private int amountOfSeats;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private ComfortType type;

    public Train() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountOfSeats() {
        return amountOfSeats;
    }

    public void setAmountOfSeats(int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    public ComfortType getType() {
        return type;
    }

    public void setType(ComfortType type) {
        this.type = type;
    }
}
