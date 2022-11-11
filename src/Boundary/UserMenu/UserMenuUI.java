package Boundary.UserMenu;

import Boundary.SearchMovieUI;
import Boundary.ViewMovieDetailsUI;
import Controller.InputController;
// import Controller.MovieController;
import Controller.UserController;

public class UserMenuUI {
    String userEmail;

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
                    // "6. List Top 5 ranking\n" +
                    // "7. List Top 5 ticket sales\n" +
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
                /*
                 * case 6:
                 * listTop5Ranking();
                 * break;
                 * case 7:
                 * listTop5ByTicketSales();
                 * break;
                 */
                case 6:
                    rateMovie();
                    break;
                case 7:
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

    private void checkSeatAvailability() {
        CheckSeatAvailabilityUI checkSeatAvailabilityUI = new CheckSeatAvailabilityUI();
        checkSeatAvailabilityUI.main();
    }

    private void bookTicket() {
        BookTicketUI bookTicketUI = new BookTicketUI(userEmail);
        bookTicketUI.main();
    }

    private void viewBookingHistory() {
        UserController userController = new UserController();
        userController.getUser(userEmail).printBookingHistory();
    }

    // private void listTop5Ranking() {
    //     MovieController movieController = new MovieController();
    //     movieController.listTop5ByRating();
    // }

    // private void listTop5ByTicketSales() {
    //     MovieController movieController = new MovieController();
    //     movieController.listTop5ByTicketSales();
    // }

    private void rateMovie() {
        RateMovieUI rateMovieUI = new RateMovieUI();
        rateMovieUI.main();
    }

    // testing
    public static void main(String[] args) {
        UserMenuUI userMenuUI = new UserMenuUI("bob@gmail.com");
        userMenuUI.main();
    }

}
