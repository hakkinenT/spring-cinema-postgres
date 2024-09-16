package com.hakkinenT.cinema_postgresql.dto;

import com.hakkinenT.cinema_postgresql.projections.SeatProjection;

public class RoomSeatDTO {
    private String codeSeat;
    private boolean isSold;

    public RoomSeatDTO() {
    }

    public RoomSeatDTO(String codeSeat, boolean isSold) {
        this.codeSeat = codeSeat;
        this.isSold = isSold;
    }

    public RoomSeatDTO(SeatProjection projection) {
        codeSeat = projection.getCodeSeat();
        isSold = projection.getIsSold();
    }

    public String getCodeSeat() {
        return codeSeat;
    }

    public void setCodeSeat(String codeSeat) {
        this.codeSeat = codeSeat;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
}
