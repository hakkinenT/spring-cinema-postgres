package com.hakkinenT.cinema_postgresql.dto;

import com.hakkinenT.cinema_postgresql.entities.Movie;
import com.hakkinenT.cinema_postgresql.entities.Session;

import java.util.ArrayList;
import java.util.List;

public class MovieDTO {
    private Integer movieId;
    private String title;
    private String duration;
    private String imageUrl;
    private String synopsis;
    private String ageRating;

    private List<SessionDTO> sessions = new ArrayList<>();

    public MovieDTO() {
    }

    public MovieDTO(Integer movieId, String title, String duration, String imageUrl, String synopsis, String ageRating) {
        this.movieId = movieId;
        this.title = title;
        this.duration = duration;
        this.imageUrl = imageUrl;
        this.synopsis = synopsis;
        this.ageRating = ageRating;
    }

    public MovieDTO(Movie entity) {
        this.movieId = entity.getId();
        this.title = entity.getTitle();
        this.duration = entity.getDuration();
        this.imageUrl = entity.getImageUrl();
        this.synopsis = entity.getSynopsis();
        this.ageRating = entity.getAgeRating();
        for (Session s : entity.getSessions()){
            this.sessions.add(new SessionDTO(s));
        }
    }

    public MovieDTO(Movie entity, List<Session> sessionList) {
        this.movieId = entity.getId();
        this.title = entity.getTitle();
        this.duration = entity.getDuration();
        this.imageUrl = entity.getImageUrl();
        this.synopsis = entity.getSynopsis();
        this.ageRating = entity.getAgeRating();
        for (Session s : sessionList){
            this.sessions.add(new SessionDTO(s));
        }
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public List<SessionDTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDTO> sessions) {
        this.sessions = sessions;
    }
}
