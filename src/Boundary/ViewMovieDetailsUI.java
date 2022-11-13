package Boundary;

import Controller.InputController;
import Controller.MovieController;

/**
* ViewMovieDetailsUI is an entity containing the user interface for viewing movie details
*/
public class ViewMovieDetailsUI {
    MovieController movieController = new MovieController();

    public void main() {
        movieController.listMovies();
        System.out.println("Select movie to view details: (Enter ID)");
        int ID = InputController.getIntFromUser();
        movieController.showDetailByID(ID);
    }
}
