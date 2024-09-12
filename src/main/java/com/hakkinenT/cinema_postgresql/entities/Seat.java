package com.hakkinenT.cinema_postgresql.entities;

import com.hakkinenT.cinema_postgresql.entities.pk.SeatPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_seat")
public class Seat {
    @EmbeddedId
    private SeatPK id = new SeatPK();

    public Seat() {
    }

    public Seat(ScreeningRoom screeningRoom, String codeSeat) {
        id.setScreeningRoom(screeningRoom);
        id.setCodeSeat(codeSeat);
    }

    public ScreeningRoom getScreeningRoom(){
        return id.getScreeningRoom();
    }

    public void setScreeningRoom(ScreeningRoom screeningRoom){
        id.setScreeningRoom(screeningRoom);
    }

    public String getCodeSeat(){
        return id.getCodeSeat();
    }

    public void setCodeSeat(String codeSeat){
        id.setCodeSeat(codeSeat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(id, seat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
