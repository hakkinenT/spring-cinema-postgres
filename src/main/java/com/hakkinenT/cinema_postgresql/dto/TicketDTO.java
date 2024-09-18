package com.hakkinenT.cinema_postgresql.dto;

import com.hakkinenT.cinema_postgresql.entities.Ticket;

public class TicketDTO {
    private SessionMinDTO session;
    private String codeSeat;
    private String ticketType;
    private Double ticketValue;

    public TicketDTO() {
    }

    public TicketDTO(SessionMinDTO session, String codeSeat, String ticketType, Double ticketValue) {
        this.session = session;
        this.codeSeat = codeSeat;
        this.ticketType = ticketType;
        this.ticketValue = ticketValue;
    }

    public TicketDTO(Ticket entity) {
        session = new SessionMinDTO(entity.getSession());
        codeSeat = entity.getCodeSeatTicket();
        ticketType = entity.getTicketType().toString();
        ticketValue = entity.getTicketValue();
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
}
