package Boundary.AdminMenu;

import java.util.ArrayList;

import Boundary.SearchMovieUI;
import Controller.*;
import Entity.Movie.MovieStatus;
import Entity.Movie.MovieType;

public class AdminMenuUI {
    MovieController movieController;

    public static void main(String[] args) { // for testing
        // add movies run once
        ArrayList<String> cast = new ArrayList<String>();
        cast.add("Cast1");
        cast.add("Cast2");
        MovieController movieController = new MovieController();
        movieController.createNewMovie("John Cena", MovieStatus.Showing, "now u see me",
                "4", MovieType.Common,
                "dk", cast);
        movieController.createNewMovie("Nemo", MovieStatus.Showing, "now u see me",
                "4", MovieType.Common,
                "dk", cast);
        movieController.createNewMovie("Bob bones", MovieStatus.Showing, "now u see me",
                "4", MovieType.Common,
                "dk", cast);
        AdminMenuUI adminMenuUI = new AdminMenuUI();
        adminMenuUI.main();
    }

    public void main() {
        movieController = new MovieController();
        while (true) {
            System.out.println("\n" +
                    "--------------\n" +
                    "| Admin Menu |\n" +
                    "--------------\n" +
                    "1. Search/List movies\n" +
                    "2. View movie details\n" +
                    "3. Modify movie listings\n" +
                    "4. Modify movie showtimes\n" +
                    "5. Configure system settings\n" +
                    "6. Log out\n");
            System.out.print("Select action: ");
            switch (InputController.getIntFromUser(1, 6)) {
                case 1:
                    searchListMovies();
                    break;
                case 2:
                    viewMovieDetails();
                    break;
                case 3:
                    modifyMovieListings();
                    break;
                case 4:
                    modifyShowtimes();
                    break;
                case 5:
                    configureSystemSettings();
                    break;
                case 6:
                    System.out.println("Logged out successfully!");
                    return;
            }
        }
    }

    private void searchListMovies() {
        SearchMovieUI searchMovieUI = new SearchMovieUI();
        searchMovieUI.main();
    }

    private void viewMovieDetails() {
        ViewMovieDetailsUI viewMovieDetailsUI = new ViewMovieDetailsUI();
        viewMovieDetailsUI.main();

    }

    private void modifyMovieListings() {
        ModifyMovieMenuUI modifyMovieMenuUI = new ModifyMovieMenuUI();
        modifyMovieMenuUI.main();
    }

    private void modifyShowtimes() {
        ModifyShowtimeMenuUI modifyShowtimeMenuUI = new ModifyShowtimeMenuUI();
        modifyShowtimeMenuUI.main();
    }

    private void configureSystemSettings() {
        AdminConfigSettingUI adminConfigSettingUI = new AdminConfigSettingUI();
        adminConfigSettingUI.main();
    }

}
