package Boundary.AdminMenu;

import Boundary.SearchMovieUI;
import Boundary.ViewMovieDetailsUI;
import Controller.*;

/**
* AdminMenuUI is an entity containing the user interface for the main menu for an admin to
*/
public class AdminMenuUI {
    MovieController movieController;

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
                    "5. Configure system settings\n" + // configure system settings not done yet.
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

    /** 
     * A method to display the menu for searching movies
     */
    private void searchListMovies() {
        SearchMovieUI searchMovieUI = new SearchMovieUI();
        searchMovieUI.main();
    }

    /** 
     * A method to display the menu for viewing movie details
     */
    private void viewMovieDetails() {
        ViewMovieDetailsUI viewMovieDetailsUI = new ViewMovieDetailsUI();
        viewMovieDetailsUI.main();
    }

    /** 
     * A method to display the menu for modifying movie listings
     */
    private void modifyMovieListings() {
        ModifyMovieMenuUI modifyMovieMenuUI = new ModifyMovieMenuUI();
        modifyMovieMenuUI.main();
    }

    /** 
     * A method to display the menu for modifying showtimes
     */
    private void modifyShowtimes() {
        ModifyShowtimeMenuUI modifyShowtimeMenuUI = new ModifyShowtimeMenuUI();
        modifyShowtimeMenuUI.main();
    }

    /** 
     * A method to display the menu for configuring system settings
     */
    private void configureSystemSettings() {
        AdminConfigSettingUI adminConfigSettingUI = new AdminConfigSettingUI();
        adminConfigSettingUI.main();
    }

}
