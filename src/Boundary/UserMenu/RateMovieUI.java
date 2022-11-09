package Boundary.UserMenu;

import Controller.InputController;
import Controller.MovieController;

public class RateMovieUI {

    public void main() {
        MovieController movieController = new MovieController();
        movieController.listMovies();
        int selection = -1;
        do {
            System.out.println("Select movie to review");
            selection = InputController.getIntFromUser();
            selection = movieController.searchWithID(selection);
            if (selection == -1)
                System.out.println("Invalid input! Please try again.");
        } while (selection == -1);
        System.out.println("Please enter your rating for the movie (0 to 10)");
        int rating = InputController.getIntFromUser(0, 10);
        System.out.println("Please enter your review");
        String reviewContent = InputController.getStringFromUser();
        movieController.addUserReview(selection, rating, reviewContent);

    }

    // testing
    public static void main(String[] args) {
        RateMovieUI rateMovieUI = new RateMovieUI();
        rateMovieUI.main();
    }
}
