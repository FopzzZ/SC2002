package Boundary.UserMenu;

import Boundary.SearchMovieUI;
import Boundary.ViewMovieDetailsUI;
import Controller.InputController;
import Controller.UserController;

/**
* UserMenuUI is an entity containing the user interface for a user
*/
public class UserMenuUI {
    String userEmail;

    /** 
     * A method to that takes in a string and sets it as the user email
     */
    public UserMenuUI(String userEmail) {
        this.userEmail = userEmail;
    }

    public void main() {
        while (true) {
            System.out.println("\n" +
                    "--------------\n" +
                    "| User Menu |\n" +
                    "--------------\n" +
                    "1. Search/List movies\n" +
                    "2. View movie details\n" +
                    "3. Check seat availability\n" +
                    "4. Book ticket\n" +
                    "5. View booking history\n" +
                    "6. Rate a movie\n" +
                    "7. Log out\n");
            System.out.print("Select action: ");
            int choice = InputController.getIntFromUser(1, 9);
            switch (choice) {
                case 1:
                    searchListMovies();
                    break;
                case 2:
                    viewMovieDetails();
                    break;
                case 3:
                    checkSeatAvailability();
                    break;
                case 4:
                    bookTicket();
                    break;
                case 5:
                    viewBookingHistory();
                    break;
                case 6:
                    rateMovie();
                    break;
                case 7:
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
     * A method to display the menu for checking seat availability
     */
    private void checkSeatAvailability() {
        CheckSeatAvailabilityUI checkSeatAvailabilityUI = new CheckSeatAvailabilityUI();
        checkSeatAvailabilityUI.main();
    }

    /** 
     * A method to display the menu for booking tickets
     */
    private void bookTicket() {
        BookTicketUI bookTicketUI = new BookTicketUI(userEmail);
        bookTicketUI.main();
    }

    /** 
     * A method to display the menu for viewing booking history
     */
    private void viewBookingHistory() {
        UserController userController = new UserController();
        userController.getUser(userEmail).printBookingHistory();
    }

    /** 
     * A method to display the menu for rating movies
     */
    private void rateMovie() {
        RateMovieUI rateMovieUI = new RateMovieUI();
        rateMovieUI.main();
    }

}
