package com.hakkinenT.cinema_postgresql.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer id;

    private String title;
    private String duration;
    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String synopsis;
    private String ageRating;

    @ManyToMany
    @JoinTable(name = "tb_movie_gender",
    joinColumns = {
            @JoinColumn(name = "movie_id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "gender_id")
    })
    private Set<Gender> genders = new HashSet<>();

    @OneToMany(mappedBy = "id.movie")
    private List<Acts> performances = new ArrayList<>();

    public Movie() {
    }

    public Movie(Integer id, String title, String duration, String imageUrl, String synopsis, String ageRating) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.imageUrl = imageUrl;
        this.synopsis = synopsis;
        this.ageRating = ageRating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Gender> getGenders() {
        return genders;
    }

    public List<Acts> getPerformances() {
        return performances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
