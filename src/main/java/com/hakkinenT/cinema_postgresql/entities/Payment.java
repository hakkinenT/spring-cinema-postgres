package com.hakkinenT.cinema_postgresql.entities;

import com.hakkinenT.cinema_postgresql.enums.PaymentType;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer id;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant moment;

    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;

    @OneToOne
    @MapsId
    //@JoinColumn(name = "order_id")
    private Order order;

    public Payment() {
    }

    public Payment(Integer id, Instant moment, PaymentType paymentType, Order order) {
        this.id = id;
        this.moment = moment;
        this.paymentType = paymentType;
        this.order = order;
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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
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
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
