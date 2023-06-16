package com.kce.bean;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private int releaseYear;
    private boolean available;

    // Constructor
    public Movie() {
    }

    public Movie(int id,String title, String genre, int releaseYear, boolean available) {
        this.id = id;
    	this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.available = available;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Movie ID: " + id +
                "\nTitle: " + title +
                "\nGenre: " + genre +
                "\nRelease Year: " + releaseYear +
                "\nAvailability: " + available;
    }
}
