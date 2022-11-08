package Boundary.UserMenu;

import Controller.InputController;
import Controller.MovieController;

public class RateMovieUI {

    public void main() {
        MovieController movieController = new MovieController();
        movieController.listMovies();
        System.out.println("Select movie to review");
        int selection = InputController.getIntFromUser();
        System.out.println("Please enter your rating for the movie");
        int rating = InputController.getIntFromUser();
        System.out.println("Please enter your review");
        String reviewContent = InputController.getStringFromUser();
        movieController.addUserReview(selection - 1, rating, reviewContent);

    }

    // testing
    public static void main(String[] args) {
        RateMovieUI rateMovieUI = new RateMovieUI();
        rateMovieUI.main();
    }
}
