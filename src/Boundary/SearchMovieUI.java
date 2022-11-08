package Boundary;

import java.util.ArrayList;

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
            ArrayList<Movie> selectedMovies = new ArrayList<Movie>();
            switch (InputController.getIntFromUser(1, 5)) {
                case 1:
                    showAllMovies();

                    break;
                case 2:
                    searchByTitle();

                    break;
                case 3:
                    selectedMovies = filterByType();
                    showAllMoviesTitle(selectedMovies);
                    break;
                case 4:
                    selectedMovies = filterByStatus();
                    showAllMoviesTitle(selectedMovies);
                    break;
                case 5:
                    return;
            }
        }
    }

    private void showAllMoviesTitle(ArrayList<Movie> movies) {
        for(int i = 0; i < movies.size(); ++i) {
            System.out.printf("Movie %d: %s\n", i + 1, movies.get(i).getTitle());
        }
        System.out.printf("Total %d movies.\n", movies.size());
    }

    public void showAllMovies() {
        movieController.listMovies();
    }

    public void searchByTitle() {
        System.out.println("Enter movie title to search:");
        title = InputController.getStringFromUser();
        movieController.showDetail(title);
    }

    public ArrayList<Movie> filterByType() {
        System.out.println(
                "1. Blockbuster\n" +
                        "2. 3-D\n" +
                        "3. Common\n" +
                        "4. Back\n");
        System.out.print("Select type of movie to filter by: ");
        int choice = InputController.getIntFromUser(1, 4);
        switch (choice) {
            case 1:
                return movieController.filterByType(MovieType.Blockbuster);
            case 2:
                return movieController.filterByType(MovieType.ThreeD);
            case 3:
                return movieController.filterByType(MovieType.Common);
            case 4:
                break;
        }
        return new ArrayList<Movie>();
    }

    public ArrayList<Movie> filterByStatus() {
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
                return movieController.filterByStatus(MovieStatus.Coming);
            case 2:
                return movieController.filterByStatus(MovieStatus.Preview);
            case 3:
                return movieController.filterByStatus(MovieStatus.Showing);
            case 4:
                return movieController.filterByStatus(MovieStatus.Ended);
            case 5:
                break;
        }
        return new ArrayList<Movie>();
    }
}
