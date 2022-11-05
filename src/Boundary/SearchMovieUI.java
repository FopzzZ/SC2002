package Boundary;

import Controller.*;
import Entity.Movie.*;

public class SearchMovieUI {
    private MovieController movieController;
    private String title;

    public void main() {
        movieController = new MovieController();
        while (true) {
            System.out.println("\n" +
                    "----------------------\n" +
                    "| Search/List Movies |\n" +
                    "----------------------\n" +
                    "1. List all movie titles\n" +
                    "2. Search by movie title\n" +
                    "3. Filter by movie type\n" +
                    "4. Filter by movie status\n" +
                    "5. Back to main menu\n");
            System.out.print("Select action: ");
            switch (InputController.getIntFromUser(1, 5)) {
                case 1:
                    showAllMovies();

                    break;
                case 2:
                    searchByTitle();

                    break;
                case 3:
                    filterByType();
                    break;
                case 4:
                    filterByStatus();
                    break;
                case 5:
                    return;
            }
        }
    }

    public void showAllMovies() {
        movieController.listMovies();
    }

    public void searchByTitle() {
        System.out.println("Enter movie title to search:");
        title = InputController.getStringFromUser();
        movieController.showDetail(title);
    }

    public void filterByType() {
        System.out.println(
                "1. Blockbuster\n" +
                        "2. 3-D\n" +
                        "3. Common\n" +
                        "4. Back\n");
        System.out.print("Select type of movie to filter by: ");
        int choice = InputController.getIntFromUser(1, 4);
        switch (choice) {
            case 1:
                movieController.filterByType(MovieType.Blockbuster);
                break;
            case 2:
                movieController.filterByType(MovieType.ThreeD);
                break;
            case 3:
                movieController.filterByType(MovieType.Common);
                break;
            case 4:
                break;
        }
    }

    public void filterByStatus() {
        System.out.println(
                "1. Coming Soon\n" +
                        "2. Preview\n" +
                        "3. Now Showing\n" +
                        "4. End of Showing\n" +
                        "5. Back\n");
        System.out.print("Select status to filter by: ");
        int choice = InputController.getIntFromUser(1, 5);
        switch (choice) {
            case 1:
                movieController.filterByStatus(MovieStatus.Coming);
                break;
            case 2:
                movieController.filterByStatus(MovieStatus.Preview);
                break;
            case 3:
                movieController.filterByStatus(MovieStatus.Showing);
                break;
            case 4:
                movieController.filterByStatus(MovieStatus.Ended);
                break;
            case 5:
                break;
        }
    }
}
