package com.hakkinenT.cinema_postgresql.dto;

import com.hakkinenT.cinema_postgresql.entities.Session;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SessionMinDTO {
    private LocalDate exhibitionDate;
    private LocalTime exhibitionHour;
    private Integer roomNumber;


    public SessionMinDTO() {
    }

    public SessionMinDTO(LocalDateTime exhibitionDateHour, Integer roomNumber ) {
        this.exhibitionDate = exhibitionDateHour.toLocalDate();
        this.exhibitionHour = exhibitionDateHour.toLocalTime();
        this.roomNumber = roomNumber;

    }

    public SessionMinDTO(Session entity) {
        this.exhibitionDate = entity.getExhibitionDate().toLocalDate();
        this.exhibitionHour = entity.getExhibitionDate().toLocalTime();
        this.roomNumber = entity.getScreeningRoom().getRoomNumber();
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

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
