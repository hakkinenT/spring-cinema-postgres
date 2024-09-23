package com.hakkinenT.cinema_postgresql.repositories;

import com.hakkinenT.cinema_postgresql.projections.TicketProjection;
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
public class TicketRepositoryTests {
    @Autowired
    private TicketRepository ticketRepository;

    private Integer existingOrderId;
    private LocalDateTime exhibitionDate;

    @BeforeEach
    void setUp() throws Exception{
        existingOrderId = 1;
        exhibitionDate = LocalDateTime.of(2024, 4,6, 9, 0, 0);
    }


    @Test
    public void searchTicketsByOrderIdShouldReturnTicketListFromOrderWhenOrderIdExist(){
        List<TicketProjection> tickets = ticketRepository.searchTicketsByOrderId(existingOrderId);
        Assertions.assertFalse(tickets.isEmpty());
        Assertions.assertEquals("001", tickets.getFirst().getCodeSeat());
        Assertions.assertEquals(1, tickets.getFirst().getRoomNumber());
        Assertions.assertEquals(exhibitionDate, tickets.getFirst().getExhibitionDate());
    }
}
