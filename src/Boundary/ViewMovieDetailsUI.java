package Boundary;

import Controller.InputController;
import Controller.MovieController;

public class ViewMovieDetailsUI {
    MovieController movieController = new MovieController();

    public void main() {
        System.out.println("\n" +
                "-------------------\n" +
                "| Movie Catalogue |\n" +
                "-------------------");
        movieController.listMovies();
        System.out.println("Select movie to view details: (Enter ID)");
        int ID = InputController.getIntFromUser();
        movieController.showDetailByID(ID);
    }
}
