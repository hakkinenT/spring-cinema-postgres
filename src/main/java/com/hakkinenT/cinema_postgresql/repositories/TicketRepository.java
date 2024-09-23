package com.hakkinenT.cinema_postgresql.repositories;

import com.hakkinenT.cinema_postgresql.entities.Ticket;
import com.hakkinenT.cinema_postgresql.entities.pk.TicketPK;
import com.hakkinenT.cinema_postgresql.projections.TicketProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, TicketPK> {
    @Query(nativeQuery = true, value = """
            SELECT ss.exhibition_date, ss.room_number, tk.ticket_type, tk.code_seat, mv.title AS movieTitle, tk.ticket_value
            FROM tb_ticket AS tk
            INNER JOIN tb_session AS ss
            ON ss.exhibition_date=tk.exhibition_date AND ss.room_number=tk.room_number
            INNER JOIN tb_movie AS mv
            ON mv.id=ss.movie_id
            WHERE tk.order_id=:orderId;
            """)
    List<TicketProjection> searchTicketsByOrderId(int orderId);
}
