package com.kce.service;
import com.kce.bean.Movie;
public interface MovieService  {
    void createMovie(Movie movie);
    Movie readMovie(int movieId);
    void updateMovie(Movie movie);
    void deleteMovie(int movieId);
    void updateAvailability(int movieId, boolean availability);
}
