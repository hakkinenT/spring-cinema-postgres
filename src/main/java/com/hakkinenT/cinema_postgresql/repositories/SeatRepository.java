package com.hakkinenT.cinema_postgresql.repositories;

import com.hakkinenT.cinema_postgresql.entities.Seat;
import com.hakkinenT.cinema_postgresql.entities.pk.SeatPK;
import com.hakkinenT.cinema_postgresql.projections.SeatProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, SeatPK> {
    @Query(nativeQuery = true, value = """
            SELECT st.code_seat,
            	(CASE WHEN st.code_seat NOT IN (
            			SELECT tk.code_seat_ticket
            	 		FROM tb_ticket AS tk
            	 		WHERE tk.exhibition_date=:exhibitionDate AND tk.room_number=:roomNumber
            		) THEN false ELSE true END) as "isSold"
            FROM tb_seat AS st
            WHERE st.room_number=:roomNumber;
            """)
    List<SeatProjection> getSessionSeats(LocalDateTime exhibitionDate, Integer roomNumber);
}
