package com.kce.dao;
import com.kce.bean.*;
import com.kce.util.*;
import java.util.*;
import java.sql.*;
public class MovieDAOImpl implements MovieDAO {
    private final Connection connection;

    public MovieDAOImpl() {
        connection = DBUtil.getConnection();
    }

    @Override
    public void createMovie(Movie movie) {
        String query = "INSERT INTO movies (id, title, genre, release_year, availability) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) 
        {
        	statement.setInt(1, movie.getId());
        	statement.setString(2, movie.getTitle());
            statement.setString(3, movie.getGenre());
            statement.setInt(4, movie.getReleaseYear());
            statement.setBoolean(5, movie.isAvailable());
            
            

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
            	System.out.println("Movie is Created Successfully. Congrats!");
            	System.out.println("----------------------------------");
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int movieId = generatedKeys.getInt(1);
                    movie.setId(movieId);
                    
                }
            }
        } catch (Exception e) {
        	System.out.println("Error in Creating the movie. Please check the given data and Retry");
           
        }
    }

    @Override
    public Movie readMovie(int movieId) {
        String query = "SELECT * FROM movies WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, movieId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	int id =resultSet.getInt("id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                int releaseYear = resultSet.getInt("release_year");
                boolean availability = resultSet.getBoolean("availability");

                Movie movie = new Movie(id , title, genre, releaseYear, availability);
                movie.setId(movieId);

                return movie;
            }
        } catch (SQLException e) {
        	System.out.println("Error in viewing the movie data. Please check the provided data and Retry");
            
        }
        return null;
    }

    @Override
    public void updateMovie(Movie movie) {
    	 String UPDATE_MOVIE_QUERY = "UPDATE movies SET id = ?, title = ?, genre = ?, release_year = ?, availability = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_MOVIE_QUERY)) {

            statement.setInt(1, movie.getId()); // New ID value
            statement.setString(2, movie.getTitle());
            statement.setString(3, movie.getGenre());
            statement.setInt(4, movie.getReleaseYear());
            statement.setBoolean(5, movie.isAvailable());
            statement.setInt(6, movie.getId()); // Current ID value

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential database errors
        }
    }

    @Override
    public void deleteMovie(int movieId) {
        String query = "DELETE FROM movies WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, movieId);

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Movie deleted successfully.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error in deleting the movie.Please Check the given data.");
        }
    }
    @Override
    public void updateAvailability(int movieId, boolean availability) {
    	final String UPDATE_AVAILABILITY_QUERY = "UPDATE movies SET availability = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_AVAILABILITY_QUERY))
              {

            statement.setBoolean(1, availability);
            statement.setInt(2, movieId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    
}