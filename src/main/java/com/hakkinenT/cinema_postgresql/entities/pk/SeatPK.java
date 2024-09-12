package com.hakkinenT.cinema_postgresql.entities.pk;

import com.hakkinenT.cinema_postgresql.entities.ScreeningRoom;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class SeatPK {
    @ManyToOne
    @JoinColumn(name = "room_number")
    private ScreeningRoom screeningRoom;

    private String codeSeat;

    public SeatPK() {
    }

    public SeatPK(ScreeningRoom screeningRoom, String codeSeat) {
        this.screeningRoom = screeningRoom;
        this.codeSeat = codeSeat;
    }

    public ScreeningRoom getScreeningRoom() {
        return screeningRoom;
    }

    public void setScreeningRoom(ScreeningRoom screeningRoom) {
        this.screeningRoom = screeningRoom;
    }

    public String getCodeSeat() {
        return codeSeat;
    }

    public void setCodeSeat(String codeSeat) {
        this.codeSeat = codeSeat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatPK seatPK = (SeatPK) o;
        return Objects.equals(screeningRoom, seatPK.screeningRoom) && Objects.equals(codeSeat, seatPK.codeSeat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screeningRoom, codeSeat);
    }
}
