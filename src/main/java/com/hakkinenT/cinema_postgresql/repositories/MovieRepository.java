package com.hakkinenT.cinema_postgresql.repositories;

import com.hakkinenT.cinema_postgresql.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("""
            SELECT obj
            FROM Movie obj
            JOIN FETCH obj.sessions AS ss
            JOIN FETCH ss.id.screeningRoom
            WHERE ss.sessionClosed=false AND ss.movie.id= :id
            """)
    List<Movie> searchMovieById(Integer id);
}
