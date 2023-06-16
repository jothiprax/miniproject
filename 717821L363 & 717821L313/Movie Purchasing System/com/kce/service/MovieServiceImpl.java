package com.kce.service;
import com.kce.bean.*;
import com.kce.dao.*;
public class MovieServiceImpl implements MovieService{
    private final MovieDAO movieDAO;

    public MovieServiceImpl() {
        movieDAO = new MovieDAOImpl();
    }

    @Override
    public void createMovie(Movie movie) {
        movieDAO.createMovie(movie);
    }

    @Override
    public Movie readMovie(int movieId) {
        return movieDAO.readMovie(movieId);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieDAO.updateMovie(movie);
    }

    @Override
    public void deleteMovie(int movieId) {
        movieDAO.deleteMovie(movieId);
    }
    @Override
    public  void updateAvailability(int movieId, boolean availability) {
    	movieDAO.updateAvailability(movieId, availability);
}
}
