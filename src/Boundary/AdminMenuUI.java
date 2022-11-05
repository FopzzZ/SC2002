package Boundary;

import java.util.ArrayList;

import Controller.*;
import Entity.Movie.Movie;
import Entity.Movie.MovieStatus;
import Entity.Movie.MovieType;

public class AdminMenuUI {
    MovieController movieController;

    public static void main(String[] args) { // for testing
        AdminMenuUI adminMenuUI = new AdminMenuUI();
        adminMenuUI.main();
    }

    public void main() {
        movieController = new MovieController();
        boolean loggedIn = true; // think of some way to implement
        while (loggedIn) {
            System.out.println("|Admin Menu|\n" +
                    "1. List movies\n" +
                    "2. Search movies\n" +
                    "3. View movie details\n" +
                    "4. Modify movie listings\n" +
                    "5. Modify movie showtimes\n" +
                    "6. Configure system settings\n" +
                    "7. Log out");
            System.out.print("Select action: ");
            switch (InputController.getIntFromUser(1, 7)) {
                case 1:
                    listMovies();
                    break;
                case 2:
                    break;
                case 3:

                    break;
                case 4:
                    modifyMovieListings();

                    break;
                case 5:
                    modifyMovieShowtimes();
                    break;
                case 6:
                    break;
                case 7:
                    loggedIn = false;
                    System.out.println("Logged out successfully!");
                    break;
                default:
                    break;
            }
        }
    }

    private void listMovies() {
        movieController.listMovies();
    }

    private void modifyMovieListings() {
        System.out.println("1. Create movie listing");
        System.out.println("2. Update movie listing");
        System.out.println("3. Remove movie listing");
        System.out.println("Select action: ");
        switch (InputController.getIntFromUser(1, 3)) {
            case 1:
                createMovieListing();
                break;
            case 2:
                updateMovieListing();
                break;
            case 3:
                removeMovieListing();
                break;
        }
    }

    private void createMovieListing() {
        int movieID;
        String movieTitle, movieSynopsis, movieDirector, castInput, reviewerRating;
        ArrayList<String> castNames = new ArrayList<String>();
        MovieStatus showingStatus = MovieStatus.Coming;
        MovieType movieType = MovieType.Common;
        movieID = movieController.getLastID() + 1;
        System.out.println("Enter movie title: ");
        movieTitle = InputController.getStringFromUser();
        System.out.println("Select showing status:\n" +
                "1. Coming Soon\n" +
                "2. Preview\n" +
                "3. Now Showing\n" +
                "4. End of Showing");
        switch (InputController.getIntFromUser(1, 4)) {
            case 1:
                showingStatus = MovieStatus.Coming;
                break;
            case 2:
                showingStatus = MovieStatus.Preview;
                break;
            case 3:
                showingStatus = MovieStatus.Showing;
                break;
            case 4:
                showingStatus = MovieStatus.Ended;
                break;

        }
        System.out.println("Enter synopsis: ");
        movieSynopsis = InputController.getStringFromUser();
        System.out.println("Enter director's name: ");
        movieDirector = InputController.getStringFromUser();
        System.out.println("Enter a cast's name: (Enter END when done)");
        castInput = InputController.getStringFromUser();
        while (!castInput.equals("END")) {
            castInput = InputController.getStringFromUser();
            castNames.add(castInput);
        }
        // implement reviewer rating or nah?
        Movie newMovie = new Movie(movieID, movieTitle, movieSynopsis,
                movieDirector, movieType, showingStatus, null, castNames, null);
        movieController.addMovie(newMovie);
    }

    private void updateMovieListing() {
        movieController.listMovies();
        System.out.println("Select movie to update: ");
        int selection = InputController.getIntFromUser();
        movieController.updateMovieByID(selection);
    }

    private void removeMovieListing() { // deletes off database for now
        movieController.listMovies();
        System.out.println("Select movie to remove: ");
        int selection = InputController.getIntFromUser();
        movieController.removeMovieByID(selection);
        System.out.println("Movie has been removed");

    }

    private void modifyMovieShowtimes() {
        System.out.println("Select movie to modify showtimes:");
        // TODO print list of movies and then select one
        System.out.println("1. Create movie showtime");
        System.out.println("2. Update movie showtime");
        System.out.println("3. Remove movie showtime");
        System.out.println("Select action: ");
        switch (InputController.getIntFromUser(1, 3)) {
            case 1:
                createMovieShowtime();
                break;
            case 2:
                updateMovieShowtime();
                break;
            case 3:
                removeMovieShowtime();
                break;
        }
    }

    private void removeMovieShowtime() {
    }

    private void updateMovieShowtime() {
    }

    private void createMovieShowtime() {
    }
}
