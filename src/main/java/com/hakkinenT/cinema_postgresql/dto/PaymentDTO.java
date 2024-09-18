package com.hakkinenT.cinema_postgresql.dto;

import com.hakkinenT.cinema_postgresql.entities.Payment;
import com.hakkinenT.cinema_postgresql.enums.PaymentType;

public class PaymentDTO {
    private Integer id;
    private String paymentType;

    public PaymentDTO() {
    }

    public PaymentDTO(Integer id, String paymentType) {
        this.id = id;
        this.paymentType = paymentType;
    }

    public PaymentDTO(Payment entity) {
        this.id = entity.getId();
        this.paymentType = entity.getPaymentType().toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
