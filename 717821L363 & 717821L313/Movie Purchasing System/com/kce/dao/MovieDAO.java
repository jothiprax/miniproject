package com.kce.dao;
import com.kce.bean.*;
public interface MovieDAO {
    void createMovie(Movie movie);
    Movie readMovie(int movieId);
    void updateMovie(Movie movie);
    void deleteMovie(int movieId);
    void updateAvailability(int movieId, boolean availability);
}
