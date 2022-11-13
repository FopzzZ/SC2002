package Boundary;

import java.util.ArrayList;
import Controller.*;
import Entity.Movie.*;

/**
* SearchMovieUI is an entity containing the user interface for searching movies
*/
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
                    "2. List Top 5 ranking\n" +
                    "3. List Top 5 ticket sales\n" +
                    "4. Search by movie title\n" +
                    "5. Filter by movie type\n" +
                    "6. Filter by movie status\n" +
                    "7. Filter by movie rating\n" +
                    "8. Back to main menu\n");
            System.out.print("Select action: ");
            ArrayList<Movie> selectedMovies = new ArrayList<Movie>();
            switch (InputController.getIntFromUser(1, 8)) {
                case 1:
                    showAllMovies();
                    break;
                case 2:
                    listTop5Ranking();
                    break;
                case 3:
                    listTop5ByTicketSales();
                    break;
                case 4:
                    searchByTitle();
                    break;
                case 5:
                    selectedMovies = filterByType();
                    if (!selectedMovies.isEmpty()) {
                        int dashLength = selectedMovies.get(0).getType().toString().length();
                        System.out.println();
                        for (int i = 0; i < dashLength + 11; i++) {
                            System.out.print("-");
                        }
                        System.out.println("\n| " + selectedMovies.get(0).getType() + " Movies |");
                        for (int i = 0; i < dashLength + 11; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        showAllMoviesTitle(selectedMovies);
                    } else {
                        System.out.println("\nThere are no movies with this type.");
                    }
                    break;
                case 6:
                    selectedMovies = filterByStatus();
                    if (!selectedMovies.isEmpty()) {
                        int dashLength = selectedMovies.get(0).getStatus().toString().length();
                        System.out.println();
                        for (int i = 0; i < dashLength + 11; i++) {
                            System.out.print("-");
                        }
                        System.out.println("\n| " + selectedMovies.get(0).getStatus() + " Movies |");
                        for (int i = 0; i < dashLength + 11; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        showAllMoviesTitle(selectedMovies);
                    } else {
                        System.out.println("\nThere are no movies with this status.");
                    }
                    break;
                case 7:
                    selectedMovies = filterByRating();
                    if (!selectedMovies.isEmpty()) {
                        int dashLength = selectedMovies.get(0).getStatus().toString().length();
                        System.out.println();
                        for (int i = 0; i < dashLength + 11; i++) {
                            System.out.print("-");
                        }
                        System.out.println("\n| " + selectedMovies.get(0).getStatus() + " Movies |");
                        for (int i = 0; i < dashLength + 11; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        showAllMoviesTitle(selectedMovies);
                    } else {
                        System.out.println("\nThere are no movies with this rating.");
                    }
                    break;
                case 8:
                    return;
            }
        }
    }

    /** 
     * A method that takes in an arraylist of movies and prints it out
     */
    private void showAllMoviesTitle(ArrayList<Movie> movies) {
        for (int i = 0; i < movies.size(); ++i) {
            System.out.printf("Movie %d: %s\n", i + 1, movies.get(i).getTitle());
        }
        System.out.printf("Total %d movies\n", movies.size());
    }

    /** 
     * A method to show all movies
     */
    public void showAllMovies() {
        movieController.listMovies();
    }

    /** 
     * A method to list the top 5 movies by rating
     */
    private void listTop5Ranking() {
        MovieController movieController = new MovieController();
        movieController.listTop5ByRating();
    }

    /** 
     * A method to list the top 5 movies by ticket sales
     */
    private void listTop5ByTicketSales() {
        MovieController movieController = new MovieController();
        movieController.listTop5ByTicketSales();
    }

    /** 
     * A method to search for a movie title
     */
    public void searchByTitle() {
        System.out.print("Enter movie title to search: ");
        title = InputController.getStringFromUser();
        movieController.showDetail(title);
    }

    /** 
     * A method to display the menu for filtering movies by type
     */
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

    /** 
     * A method to display the menu for filtering movies by status
     */
    public ArrayList<Movie> filterByStatus() {
        System.out.println(
                "1. Coming Soon\n" +
                        "2. Preview\n" +
                        "3. Now Showing\n" +
                        "4. Back\n");
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
                break;
        }
        return new ArrayList<Movie>();
    }

    /** 
     * A method to display the menu for filtering movies by rating
     */
    public ArrayList<Movie> filterByRating() {
        System.out.println("1. G\n2. PG\n3. PG13\n4. NC16\n5. M18\n6. R21\n");
        System.out.print("Select rating to filter by: ");
        int choice = InputController.getIntFromUser(1, 6);
        switch (choice) {
            case 1:
                return movieController.filterByRating(MovieRating.G);
            case 2:
                return movieController.filterByRating(MovieRating.PG);
            case 3:
                return movieController.filterByRating(MovieRating.PG13);
            case 4:
                return movieController.filterByRating(MovieRating.NC16);
            case 5:
                return movieController.filterByRating(MovieRating.M18);
            case 6:
                return movieController.filterByRating(MovieRating.R21);
        }
        return new ArrayList<Movie>();
    }
}
