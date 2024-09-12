package com.hakkinenT.cinema_postgresql.entities;

import com.hakkinenT.cinema_postgresql.entities.pk.ActsPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_act")
public class Acts {
    @EmbeddedId
    private ActsPK id = new ActsPK();

    public Acts(){}

    public Acts(Movie movie, Actor actor, String actorRole){
        id.setMovie(movie);
        id.setActor(actor);
        id.setActorRole(actorRole);
    }

    public Movie getMovie(){
        return id.getMovie();
    }

    public void setMovie(Movie movie){
        id.setMovie(movie);
    }

    public Actor getActor(){
        return id.getActor();
    }

    public void setActor(Actor actor){
        id.setActor(actor);
    }

    public String getActorRole(){
        return id.getActorRole();
    }

    public void setActorRole(String actorRole){
        id.setActorRole(actorRole);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acts acts = (Acts) o;
        return Objects.equals(id, acts.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
