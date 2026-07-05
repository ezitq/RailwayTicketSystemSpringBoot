package com.bohdan.service;

import com.bohdan.entity.Seat;
import com.bohdan.entity.SeatType;
import com.bohdan.entity.TicketStatus;
import com.bohdan.entity.Train;
import com.bohdan.entity.dto.SeatResponseDto;
import com.bohdan.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> findAllAvailableSeats(int trainId){
        return seatRepository.findAllByStatusAndTrainId(null,trainId);
    }

    public List<Seat> findAllBookedSeats(int trainId){
        return seatRepository.findAllByStatusAndTrainId(TicketStatus.BOOKED, trainId);
    }

    public List<Seat> findAllPaidSeats(int trainId){
        return seatRepository.findAllByStatusAndTrainId(TicketStatus.PAID, trainId);
    }

    public int findAmountOfSeatsByTrainId(int trainId){
       return seatRepository.findNumberOfAvailableSeatsByTrainId(trainId);
    }

    public List<SeatResponseDto> findAllRegularByTrainId(int trainId){
        return seatRepository.findAllRegularByTrainId(trainId).stream()
                .map(this::convertToResponseDto).toList();
    }

    public List<SeatResponseDto> findAllKupeByTrainId(int trainId){
        return seatRepository.findAllKupeByTrainId(trainId).stream()
                .map(this::convertToResponseDto).toList();
    }

    public List<SeatResponseDto> findAllLuxByTrainId(int trainId){
        return seatRepository.findAllLuxByTrainId(trainId).stream()
                .map(this::convertToResponseDto).toList();
    }

    private SeatResponseDto convertToResponseDto(Seat seat){

        return new SeatResponseDto(seat.getId()
                ,seat.getNumberOfSeat()
                ,seat.getTrain().getId()
                ,seat.getType().name(),
                seat.getStatus() == null ? null : seat.getStatus().name());

    }

    public Integer countSeatsByTrainIdAndSeatType(int trainId, String seatType){

        return seatRepository.countSeatByTrainIdAndType(trainId, SeatType.valueOf(seatType));

    }
}
