package Boundary;

import java.util.ArrayList;

import Controller.*;
import Entity.Movie.Movie;
import Entity.Movie.MovieStatus;
import Entity.Movie.MovieType;

public class AdminMenuUI {
    public void main() {
        boolean loggedIn = true; // think of some way to implement
        while (loggedIn) {
            System.out.println("|Admin Menu|" +
                    "1. Search/List movies\n" +
                    "2. View movie details\n" +
                    "3. Modify movie listing\n" +
                    "4. Modify movie showtimes\n" +
                    "3. Configure system settings\n" +
                    "6. Log out\n");
            System.out.print("Select action: ");
            switch (InputController.getIntFromUser(1, 6)) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    modifyMovieListing();
                    break;
                case 4:
                    modifyMovieShowtime();
                    break;
                case 5:
                    break;
                case 6:
                    loggedIn = false;
                    System.out.println("Logged out successfully!");
                    break;
                default:
                    break;
            }
        }
    }

    private void modifyMovieListing() {
        System.out.println("1. Create movie listing");
        System.out.println("2. Update movie listing");
        System.out.println("3. Remove movie listing");
        System.out.println("Select action: ");
        switch (InputController.getIntFromUser(1, 3)) {
            case 1:
                createMovieListing();
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    private void createMovieListing() {
        int movieID;
        String movieTitle, movieSynopsis, movieDirector, castInput, reviewerRating;
        ArrayList<String> castNames = new ArrayList<String>();
        MovieStatus showingStatus = MovieStatus.Coming;
        MovieType movieType = MovieType.Common;
        System.out.println("Enter movie id: ");
        movieID = InputController.getIntFromUser();
        System.out.println("Enter movie title: ");
        movieTitle = InputController.getStringFromUser();
        System.out.println("Select showing status:\n" +
                "1. Coming Soon\n" +
                "2. Preview\n" +
                "3. Now Showing\n" +
                "4. End of Showing\n");
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
        while (castInput != "END") {
            castInput = InputController.getStringFromUser();
            castNames.add(castInput);
        }
        // implement reviewer rating or nah?
        Movie newMovie = new Movie(movieID, movieTitle, movieSynopsis,
                movieDirector, movieType, showingStatus, null, castNames, null);
        // add this newMovie to catalog;
    }

    private void modifyMovieShowtime() {
    }
}
