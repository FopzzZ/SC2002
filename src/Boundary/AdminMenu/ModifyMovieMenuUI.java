package Boundary.AdminMenu;

import java.util.ArrayList;

import Controller.InputController;
import Controller.MovieController;
import Entity.Movie.MovieStatus;
import Entity.Movie.MovieType;

public class ModifyMovieMenuUI {
    MovieController movieController;

    public void main() {
        movieController = new MovieController();
        System.out.println("1. Create movie listing");
        System.out.println("2. Update movie listing");
        System.out.println("3. Remove movie listing");
        System.out.println("4. Back to main menu");
        System.out.println("Select action: ");
        switch (InputController.getIntFromUser(1, 4)) {
            case 1:
                createMovieListing();
                break;
            case 2:
                updateMovieListing();
                break;
            case 3:
                removeMovieListing();
                break;
            case 4:
                return;
        }
    }

    private void createMovieListing() {
        String movieTitle, movieSynopsis, movieDirector, castInput;
        ArrayList<String> castNames = new ArrayList<String>();
        MovieStatus showingStatus = MovieStatus.Coming;
        MovieType movieType = MovieType.Common;
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
        movieController.createNewMovie(movieTitle, showingStatus, movieSynopsis, "4", movieType,
                movieDirector, castNames);
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
}
