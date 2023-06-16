package com.kce.service;
import com.kce.bean.Movie;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MovieService movieService = new MovieServiceImpl();

    public static void main(String[] args) {
    	System.out.println("\nWELCOME TO THE GRAND MOVIE STORE!");
        System.out.println("\n********** MOVIE PURCHASE SYSTEM ************");


        boolean exit = false;
        while (!exit) {
            try {
                displayMenu();
                int choice = getUserChoice();
                processChoice(choice);
                
                if (choice == 0) {
                    exit = true;
                    System.out.println("Application is being exited");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input detected! Please try again");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n1. Add a Movie to your Collection");
        System.out.println("2. View a Movie from your Collection");
        System.out.println("3. Update a Movie to your Collection");
        System.out.println("4. Delete a Movie from your Collection");
        System.out.println("5. Buy a Movie");
        System.out.println("0. Exit the application");
        System.out.println("***************************");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                addMovie();
                break;
            case 2:
                viewMovie();
                break;
            case 3:
                updateMovie();
                break;
            case 4:
                deleteMovie();
                break;
            case 5:
                buyMovie();
                break;
            
            case 0:
                // Do nothing, will exit the loop
                break;
            default:
                System.out.println("Your choice is invalid. Please try again");
        }
    }



	private static void addMovie() {
    	
    	System.out.print("\nEnter the movie id: ");
    	int id =scanner.nextInt();
        System.out.print("\nEnter the movie title: ");
        String title = scanner.next();
        System.out.print("Enter the movie genre: ");
        String genre = scanner.next();
        System.out.print("Enter the release year: ");
        int releaseYear = scanner.nextInt();
        System.out.print("Enter the availability (true/false): ");
        boolean availability = scanner.nextBoolean();

        Movie movie = new Movie(id, title, genre, releaseYear, availability);
        movieService.createMovie(movie);
        System.out.println();
    }
    
   

    private static void viewMovie() {
        System.out.print("\nEnter the movie ID: ");
        int movieId = scanner.nextInt();

        Movie movie = movieService.readMovie(movieId);
        if (movie != null) {
            System.out.println("\nMovie Details of your given ID:");
            System.out.println(movie);
        } else {
            System.out.println("No movie found with the given ID.");
        }

        System.out.println();
    }

    private static void updateMovie() {
        System.out.print("\nEnter the movie ID: ");
        int movieId = scanner.nextInt();

        Movie existingMovie = movieService.readMovie(movieId);
        if (existingMovie != null) {
        	System.out.print("\nEnter the movie id: ");
        	int id =scanner.nextInt();
            System.out.print("Enter the updated movie title: ");
            String title = scanner.next();
            System.out.print("Enter the updated movie genre: ");
            String genre = scanner.next();
            System.out.print("Enter the updated release year: ");
            int releaseYear = scanner.nextInt();
            System.out.print("Enter the updated availability (true/false): ");
            boolean availability = scanner.nextBoolean();

            Movie updatedMovie = new Movie(id, title, genre, releaseYear, availability);
            updatedMovie.setId(movieId);

            movieService.updateMovie(updatedMovie);
        } else {
            System.out.println("No movie found with the given ID.");
        }

        System.out.println();
    }

    private static void deleteMovie() {
    	
   
        System.out.print("\nEnter the movie ID to be deleted: ");
        int movieId = scanner.nextInt();
        Movie existingMovie = movieService.readMovie(movieId);
        if(existingMovie != null) {
        Movie movie = movieService.readMovie(movieId);
        System.out.println(movie);
        System.out.print("Are you sure to delete this movie data? Enter >true< to delete: ");
        boolean br=scanner.nextBoolean();
        
        if(br=true) {
        movieService.deleteMovie(movieId);
        System.out.println();
    }
        }
        else {
        	System.out.println("No movies found in the given ID");
        }
    }
        
   
    private static void buyMovie() {
        System.out.print("\nEnter the movie ID: ");
        int movieId = scanner.nextInt();

        Movie movie = movieService.readMovie(movieId);
        if (movie != null) {
            if (movie.isAvailable()) {
                System.out.println("\nMovie is available for purchase!");
                System.out.print("Are you sure you want to buy this movie? Enter 'true' to confirm: ");
                boolean confirm = scanner.nextBoolean();

                if (confirm) {
                    movieService.updateAvailability(movieId, false); // Update availability in the database
                    System.out.println("Movie has been successfully purchased.");
                } else {
                    System.out.println("Movie purchase has been canceled.");
                }
            } else {
                System.out.println("\nMovie is not available for purchase.");
            }
        } else {
            System.out.println("No movie found with the given ID.");
        }

        System.out.println();
    }
    
}
