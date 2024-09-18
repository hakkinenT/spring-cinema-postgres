package com.hakkinenT.cinema_postgresql.dto;

import com.hakkinenT.cinema_postgresql.entities.Session;
import com.hakkinenT.cinema_postgresql.entities.Ticket;
import com.hakkinenT.cinema_postgresql.enums.TicketType;

public class TicketMinDTO {
    private SessionMinDTO session;
    private String codeSeat;
    private String ticketType;

    public TicketMinDTO() {
    }

    public TicketMinDTO(SessionMinDTO session, String codeSeat, String ticketType) {
        this.session = session;
        this.codeSeat = codeSeat;
        this.ticketType = ticketType;
    }

    public TicketMinDTO(Ticket entity) {
        session = new SessionMinDTO(entity.getSession());
        codeSeat = entity.getCodeSeatTicket();
        ticketType = entity.getTicketType().toString();
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
}
