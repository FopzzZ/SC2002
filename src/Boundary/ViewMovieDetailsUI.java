package Boundary;

import Controller.InputController;
import Controller.MovieController;

public class ViewMovieDetailsUI {
    MovieController movieController = new MovieController();

    public void main() {
        movieController.listMovies();
        System.out.println("Select movie to view details: (Enter ID)");
        int ID = InputController.getIntFromUser(1, movieController.getlistMovies().size());
        movieController.showDetailByID(ID);
    }
}
