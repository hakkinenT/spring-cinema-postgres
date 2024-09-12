package com.hakkinenT.cinema_postgresql.entities;

import com.hakkinenT.cinema_postgresql.entities.pk.SessionPK;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_session")
public class Session {
    @EmbeddedId
    private SessionPK id = new SessionPK();

    private Double ticketFullValue;
    private Double ticketHalfValue;
    private boolean sessionClosed;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "id.session")
    private List<Ticket> tickets = new ArrayList<>();

    public Session() {
    }

    public Session(LocalDateTime exhibitionDate, ScreeningRoom screeningRoom, Double ticketFullValue, Double ticketHalfValue, boolean sessionClosed, Movie movie) {
        id.setExhibitionDate(exhibitionDate);
        id.setScreeningRoom(screeningRoom);
        this.ticketFullValue = ticketFullValue;
        this.ticketHalfValue = ticketHalfValue;
        this.sessionClosed = sessionClosed;
        this.movie = movie;
    }

    public LocalDateTime getExhibitionDate(){
        return id.getExhibitionDate();
    }

    public void setExhibitionDate(LocalDateTime exhibitionDate){
        id.setExhibitionDate(exhibitionDate);
    }

    public ScreeningRoom getScreeningRoom(){
        return id.getScreeningRoom();
    }

    public void setScreeningRoom(ScreeningRoom screeningRoom){
        id.setScreeningRoom(screeningRoom);
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

    public boolean isSessionClosed() {
        return sessionClosed;
    }

    public void setSessionClosed(boolean sessionClosed) {
        this.sessionClosed = sessionClosed;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
