package com.hakkinenT.cinema_postgresql.controllers;

import com.hakkinenT.cinema_postgresql.dto.RoomSeatDTO;
import com.hakkinenT.cinema_postgresql.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/sessions")
public class SessionController {
    @Autowired
    private SeatService seatService;

    @GetMapping(value = "{exhibitionDate}/room/{roomNumber}")
    public ResponseEntity<List<RoomSeatDTO>> getSessionMap(@PathVariable LocalDateTime exhibitionDate, @PathVariable int roomNumber){
        List<RoomSeatDTO> roomSeats = seatService.getRoomMap(exhibitionDate, roomNumber);
        return ResponseEntity.ok(roomSeats);
    }
}
