package com.hakkinenT.cinema_postgresql.repositories;

import com.hakkinenT.cinema_postgresql.entities.Ticket;
import com.hakkinenT.cinema_postgresql.entities.pk.TicketPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, TicketPK> {
}
