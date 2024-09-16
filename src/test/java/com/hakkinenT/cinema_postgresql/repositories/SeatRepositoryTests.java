package com.hakkinenT.cinema_postgresql.repositories;

import com.hakkinenT.cinema_postgresql.entities.Movie;
import com.hakkinenT.cinema_postgresql.projections.SeatProjection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SeatRepositoryTests {
    @Autowired
    private SeatRepository seatRepository;

    private Integer existingRoomNumber;
    private LocalDateTime exhibitionDate;

    @BeforeEach
    void setUp() throws Exception{
        existingRoomNumber = 1;
        exhibitionDate = LocalDateTime.of(2024, 4,6, 9, 0, 0);
    }


    @Test
    public void getSessionSeatsShouldReturnARoomMapOfSessionWillBeShownWhenIdExist(){
        List<SeatProjection> seats = seatRepository.getSessionSeats(exhibitionDate, existingRoomNumber);
        Assertions.assertFalse(seats.isEmpty());
        Assertions.assertEquals("001",seats.getFirst().getCodeSeat());
        Assertions.assertTrue(seats.getFirst().getIsSold());
    }
}
