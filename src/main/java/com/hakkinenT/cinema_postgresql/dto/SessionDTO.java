package com.hakkinenT.cinema_postgresql.dto;

import com.hakkinenT.cinema_postgresql.entities.Session;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SessionDTO {
    private LocalDate exhibitionDate;
    private LocalTime exhibitionHour;
    private Double ticketFullValue;
    private Double ticketHalfValue;
    private Integer roomNumber;
    private Integer roomCapacity;

    public SessionDTO() {
    }

    public SessionDTO(LocalDateTime exhibitionDateHour, Double ticketFullValue, Double ticketHalfValue, Integer roomNumber, Integer roomCapacity) {
        this.exhibitionDate = exhibitionDateHour.toLocalDate();
        this.exhibitionHour = exhibitionDateHour.toLocalTime();
        this.ticketFullValue = ticketFullValue;
        this.ticketHalfValue = ticketHalfValue;
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
    }

    public SessionDTO(Session entity) {
        this.exhibitionDate = entity.getExhibitionDate().toLocalDate();
        this.exhibitionHour = entity.getExhibitionDate().toLocalTime();
        this.ticketFullValue = entity.getTicketFullValue();
        this.ticketHalfValue = entity.getTicketHalfValue();
        this.roomNumber = entity.getScreeningRoom().getRoomNumber();
        this.roomCapacity = entity.getScreeningRoom().getCapacity();
    }

    public LocalDate getExhibitionDate() {
        return exhibitionDate;
    }

    public void setExhibitionDate(LocalDate exhibitionDate) {
        this.exhibitionDate = exhibitionDate;
    }

    public LocalTime getExhibitionHour() {
        return exhibitionHour;
    }

    public void setExhibitionHour(LocalTime exhibitionHour) {
        this.exhibitionHour = exhibitionHour;
    }

    public Double getTicketFullValue() {
        return ticketFullValue;
    }

    public void setTicketFullValue(Double ticketFullValue) {
        this.ticketFullValue = ticketFullValue;
    }

    public Double getTicketHalfValue() {
        return ticketHalfValue;
    }

    public void setTicketHalfValue(Double ticketHalfValue) {
        this.ticketHalfValue = ticketHalfValue;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(Integer roomCapacity) {
        this.roomCapacity = roomCapacity;
    }
}
