package com.hakkinenT.cinema_postgresql.entities.pk;

import com.hakkinenT.cinema_postgresql.entities.ScreeningRoom;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class SessionPK {
    private LocalDateTime exhibitionDate;

    @ManyToOne
    @JoinColumn(name = "room_number")
    private ScreeningRoom screeningRoom;

    public SessionPK() {
    }

    public SessionPK(LocalDateTime exhibitionDate, ScreeningRoom screeningRoom) {
        this.exhibitionDate = exhibitionDate;
        this.screeningRoom = screeningRoom;
    }

    public LocalDateTime getExhibitionDate() {
        return exhibitionDate;
    }

    public void setExhibitionDate(LocalDateTime exhibitionDate) {
        this.exhibitionDate = exhibitionDate;
    }

    public ScreeningRoom getScreeningRoom() {
        return screeningRoom;
    }

    public void setScreeningRoom(ScreeningRoom screeningRoom) {
        this.screeningRoom = screeningRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionPK sessionPK = (SessionPK) o;
        return Objects.equals(exhibitionDate, sessionPK.exhibitionDate) && Objects.equals(screeningRoom, sessionPK.screeningRoom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exhibitionDate, screeningRoom);
    }
}
