package com.hakkinenT.cinema_postgresql.dto;

import com.hakkinenT.cinema_postgresql.entities.Order;
import com.hakkinenT.cinema_postgresql.entities.Payment;
import com.hakkinenT.cinema_postgresql.entities.Ticket;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private Integer id;
    private Instant moment;
    private Double total;
    private String userEmail;
    private PaymentDTO payment;
    private List<TicketMinDTO> tickets = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(Integer id, Instant moment, Double total, String userEmail, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.total = total;
        this.userEmail = userEmail;
        this.payment = payment;
    }

    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.total = entity.getTotal();
        this.userEmail = entity.getUser().getEmail();
        this.payment = new PaymentDTO(entity.getPayment());
    }

    public OrderDTO(Order entity, List<Ticket> tickets) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.total = entity.getTotal();
        this.userEmail = entity.getUser().getEmail();
        this.payment = new PaymentDTO(entity.getPayment());

        for(Ticket t : tickets){
            this.tickets.add(new TicketMinDTO(t));
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public List<TicketMinDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketMinDTO> tickets) {
        this.tickets = tickets;
    }
}
