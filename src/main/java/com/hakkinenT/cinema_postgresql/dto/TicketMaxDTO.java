package com.hakkinenT.cinema_postgresql.dto;

import com.hakkinenT.cinema_postgresql.enums.TicketType;
import com.hakkinenT.cinema_postgresql.projections.TicketProjection;

public class TicketMaxDTO {
    private SessionMinDTO session;
    private String codeSeat;
    private String ticketType;
    private Double ticketValue;
    private String movieTitle;

    public TicketMaxDTO() {
    }

    public TicketMaxDTO(SessionMinDTO session, String codeSeat, String ticketType, Double ticketValue, String movieTitle) {
        this.session = session;
        this.codeSeat = codeSeat;
        this.ticketType = ticketType;
        this.ticketValue = ticketValue;
        this.movieTitle = movieTitle;
    }

    public TicketMaxDTO(TicketProjection projection) {
        session = new SessionMinDTO(projection.getExhibitionDate(), projection.getRoomNumber());
        codeSeat = projection.getCodeSeatTicket();
        ticketType = TicketType.values()[projection.getTicketType()].toString();
        ticketValue = projection.getTicketValue();
        movieTitle = projection.getMovieTitle();
    }

    public SessionMinDTO getSession() {
        return session;
    }

    public void setSession(SessionMinDTO session) {
        this.session = session;
    }

    public String getCodeSeat() {
        return codeSeat;
    }

    public void setCodeSeat(String codeSeat) {
        this.codeSeat = codeSeat;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Double getTicketValue() {
        return ticketValue;
    }

    public void setTicketValue(Double ticketValue) {
        this.ticketValue = ticketValue;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
}
