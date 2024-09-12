package com.hakkinenT.cinema_postgresql.entities.pk;

import com.hakkinenT.cinema_postgresql.entities.Actor;
import com.hakkinenT.cinema_postgresql.entities.Movie;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class ActsPK {
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    private String actorRole;

    public ActsPK() {
    }

    public ActsPK(Movie movie, Actor actor, String actorRole) {
        this.movie = movie;
        this.actor = actor;
        this.actorRole = actorRole;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getActorRole() {
        return actorRole;
    }

    public void setActorRole(String actorRole) {
        this.actorRole = actorRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActsPK actsPK = (ActsPK) o;
        return Objects.equals(movie, actsPK.movie) && Objects.equals(actor, actsPK.actor) && Objects.equals(actorRole, actsPK.actorRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, actor, actorRole);
    }
}
