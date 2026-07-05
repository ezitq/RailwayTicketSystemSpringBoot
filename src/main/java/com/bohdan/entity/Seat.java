package com.bohdan.entity;

import jakarta.persistence.*;

@Entity
@Table(name="seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seat_number",nullable = false)
    private int numberOfSeat;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private TicketStatus status;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @Column(name = "seat_type")
    @Enumerated(value = EnumType.STRING)
    private SeatType type;

    public Seat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }
}
