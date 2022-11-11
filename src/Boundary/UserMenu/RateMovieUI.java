package Boundary.UserMenu;

import Controller.InputController;
import Controller.MovieController;

public class RateMovieUI {

    public void main() {
        MovieController movieController = new MovieController();
        movieController.listMovies();
        int selection = -1;
        do {
            System.out.print("\nSelect movie to review: ");
            selection = InputController.getIntFromUser(1, movieController.getlistMovies().size());
            selection = movieController.searchWithID(selection);
        } while (selection == -1);
        System.out.print("Please enter your rating for the movie (0 to 10): ");
        int rating = InputController.getIntFromUser(0, 10);
        System.out.print("Please enter your review: ");
        String reviewContent = InputController.getStringFromUser();
        movieController.addUserReview(selection, rating, reviewContent);

    }

    // testing
    public static void main(String[] args) {
        RateMovieUI rateMovieUI = new RateMovieUI();
        rateMovieUI.main();
    }
}
