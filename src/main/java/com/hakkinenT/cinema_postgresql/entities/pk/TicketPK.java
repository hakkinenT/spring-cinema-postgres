package com.hakkinenT.cinema_postgresql.entities.pk;

import com.hakkinenT.cinema_postgresql.entities.Session;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class TicketPK {
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "exhibition_date"),
            @JoinColumn(name = "room_number")
    })
    private Session session;

    private String codeSeatTicket;

    public TicketPK() {
    }

    public TicketPK(Session session, String codeSeatTicket) {
        this.session = session;
        this.codeSeatTicket = codeSeatTicket;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getCodeSeatTicket() {
        return codeSeatTicket;
    }

    public void setCodeSeatTicket(String codeSeatTicket) {
        this.codeSeatTicket = codeSeatTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketPK ticketPK = (TicketPK) o;
        return Objects.equals(session, ticketPK.session) && Objects.equals(codeSeatTicket, ticketPK.codeSeatTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(session, codeSeatTicket);
    }
}
