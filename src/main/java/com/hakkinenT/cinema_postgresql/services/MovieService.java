package com.hakkinenT.cinema_postgresql.services;

import com.hakkinenT.cinema_postgresql.dto.MovieDTO;
import com.hakkinenT.cinema_postgresql.entities.Movie;
import com.hakkinenT.cinema_postgresql.exceptions.customs.ResourceNotFoundException;
import com.hakkinenT.cinema_postgresql.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Value(value = "${message.not-found}")
    private String notFoundMessage;

    @Transactional(readOnly = true)
    public MovieDTO findMovieById(Integer movieId){
        List<Movie> movies = movieRepository.searchMovieById(movieId);

        if(movies.isEmpty()){
            throw new ResourceNotFoundException(notFoundMessage);
        }

        Movie movie = movies.getFirst();
        return new MovieDTO(movie, movie.getSessions());

    }

}
