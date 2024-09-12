package com.hakkinenT.cinema_postgresql.entities;

import com.hakkinenT.cinema_postgresql.entities.pk.TicketPK;
import com.hakkinenT.cinema_postgresql.enums.TicketType;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_ticket")
public class Ticket {
    @EmbeddedId
    private TicketPK id = new TicketPK();

    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Ticket() {
    }

    public Ticket(Session session, String codeSeatTicket, TicketType ticketType, Order order) {
        id.setSession(session);
        id.setCodeSeatTicket(codeSeatTicket);
        this.ticketType = ticketType;
        this.order = order;
    }

    public Session getSession(){
        return id.getSession();
    }

    public void setSession(Session session){
        id.setSession(session);
    }

    public String getCodeSeatTicket(){
        return id.getCodeSeatTicket();
    }

    public void setCodeSeatTicket(String codeSeatTicket){
        id.setCodeSeatTicket(codeSeatTicket);
    }
    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && ticketType == ticket.ticketType && Objects.equals(order, ticket.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketType, order);
    }
}
