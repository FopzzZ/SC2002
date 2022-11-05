package Boundary;

import Controller.InputController;
import Controller.MovieController;

public class ViewMovieDetailsUI {
    MovieController movieController = new MovieController();

    public void main() {
        movieController.listMovies();
        System.out.println("Select movie to view details");
        int choice = InputController.getIntFromUser();
        movieController.showDetail(choice - 1);
    }
}
