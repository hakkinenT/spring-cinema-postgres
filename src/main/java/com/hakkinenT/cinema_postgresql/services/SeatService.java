package com.hakkinenT.cinema_postgresql.services;

import com.hakkinenT.cinema_postgresql.dto.RoomSeatDTO;
import com.hakkinenT.cinema_postgresql.projections.SeatProjection;
import com.hakkinenT.cinema_postgresql.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    @Transactional(readOnly = true)
    public List<RoomSeatDTO> getRoomMap(LocalDateTime exhibitionDate, int roomNumber){
        List<SeatProjection> seats = seatRepository.getRoomMap(exhibitionDate, roomNumber);
        return createRoomSeatDTOList(seats);
    }

    private static List<RoomSeatDTO> createRoomSeatDTOList(List<SeatProjection> seats) {
        return seats.stream().map(RoomSeatDTO::new).toList();
    }
}
