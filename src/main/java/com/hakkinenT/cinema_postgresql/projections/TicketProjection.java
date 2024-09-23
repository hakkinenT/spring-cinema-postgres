package com.hakkinenT.cinema_postgresql.projections;

import java.time.LocalDateTime;

public interface TicketProjection {
    LocalDateTime getExhibitionDate();
    Integer getRoomNumber();
    Integer getTicketType();
    String getCodeSeat();
    String getMovieTitle();
    Double getTicketValue();
}
