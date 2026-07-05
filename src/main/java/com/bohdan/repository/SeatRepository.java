package com.bohdan.repository;

import com.bohdan.entity.Seat;
import com.bohdan.entity.SeatType;
import com.bohdan.entity.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Integer> {

    List<Seat> findAllByStatusAndTrainId(TicketStatus status, int trainId);

    @Query(""" 
            SELECT COUNT(*)
            FROM Seat s
            WHERE s.status is null AND s.train.id = :trainId""")
    Integer findNumberOfAvailableSeatsByTrainId(int trainId);

    Integer countSeatByTrainIdAndType(int trainId, SeatType type);

    @Query("SELECT s FROM Seat s WHERE s.train.id =:trainId AND s.type = 'REGULAR'")
    List<Seat> findAllRegularByTrainId(int trainId);

    @Query("SELECT s FROM Seat s WHERE s.train.id =:trainId AND s.type = 'KUPE'")
    List<Seat> findAllKupeByTrainId(int trainId);

    @Query("SELECT s FROM Seat s WHERE s.train.id =:trainId AND s.type = 'LUX'")
    List<Seat> findAllLuxByTrainId(int trainId);
}
