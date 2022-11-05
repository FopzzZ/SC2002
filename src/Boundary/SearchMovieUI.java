package Boundary;

import Controller.*;
import Entity.Movie.*;

public class SearchMovieUI {
    private MovieController movieController;
    private String title;
    private String type;

    public void main() {
        movieController = new MovieController();
        while (true) {
            System.out.println("\n" +
                    "----------------------\n" +
                    "| Search/List Movies |\n" +
                    "----------------------\n" +
                    "1. Search by movie title\n" +
                    "2. Search by movie type\n" +
                    "3. List all movie titles\n" +
                    "4. Back to main menu\n");
            switch (InputController.getIntFromUser(1, 4)) {
                case 1:
                    searchByTitle();
                    break;
                case 2:
                    searchByType();
                    break;
                case 3:
                    showAllMovies();
                    break;
                case 4:
                    return;
            }
        }
    }

    public void searchByTitle() {
        System.out.println("Enter movie title to search:");
        title = InputController.getStringFromUser();
        movieController.showDetail(title);
    }

    public void searchByType() {
        type = InputController.getStringFromUser();
    }

    public void showAllMovies() {
        movieController.listMovies();
    }
}
