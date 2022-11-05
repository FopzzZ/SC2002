package Boundary;

import Boundary.AdminMenu.ModifyMovieMenuUI;
import Controller.*;

public class AdminMenuUI {
    MovieController movieController;

    public static void main(String[] args) { // for testing
        AdminMenuUI adminMenuUI = new AdminMenuUI();
        adminMenuUI.main();
    }

    public void main() {
        movieController = new MovieController();
        boolean loggedIn = true; // think of some way to implement
        while (loggedIn) {
            System.out.println("|Admin Menu|\n" +
                    "1. Search/List movies\n" +
                    "2. View movie details\n" +
                    "3. Modify movie listings\n" +
                    "4. Modify movie showtimes\n" +
                    "5. Configure system settings\n" +
                    "6. Log out");
            System.out.print("Select action: ");
            switch (InputController.getIntFromUser(1, 6)) {
                case 1:
                    searchListMovies();
                    break;
                case 2:

                    break;
                case 3:
                    modifyMovieListings();

                    break;
                case 4:
                    modifyMovieShowtimes();
                    break;
                case 5:
                    break;
                case 6:
                    loggedIn = false;
                    System.out.println("Logged out successfully!");
                    break;
                default:
                    break;
            }
        }
    }

    private void searchListMovies() {
        SearchMovieUI searchMovieUI = new SearchMovieUI();
        searchMovieUI.main();
    }

    private void modifyMovieListings() {
        ModifyMovieMenuUI modifyMovieMenuUI = new ModifyMovieMenuUI();
        modifyMovieMenuUI.main();
    }

    private void modifyMovieShowtimes() {
        System.out.println("Select movie to modify showtimes:");
        // TODO print list of movies and then select one
        System.out.println("1. Create movie showtime");
        System.out.println("2. Update movie showtime");
        System.out.println("3. Remove movie showtime");
        System.out.println("Select action: ");
        switch (InputController.getIntFromUser(1, 3)) {
            case 1:
                createMovieShowtime();
                break;
            case 2:
                updateMovieShowtime();
                break;
            case 3:
                removeMovieShowtime();
                break;
        }
    }

    private void removeMovieShowtime() {
    }

    private void updateMovieShowtime() {
    }

    private void createMovieShowtime() {
    }
}
