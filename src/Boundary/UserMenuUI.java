package Boundary;

import Controller.InputController;
import Controller.UserController;

public class UserMenuUI {
    UserController userController;

    public void main() {
        System.out.println("Select an option:");
        System.out.println("1. List movies");
        System.out.println("2. Search movies");
        System.out.println("3. Check seat availability");
        System.out.println("4. Book ticket");
        System.out.println("5. View booking history");
        System.out.println("6. List Top 5 ranking of movies");
        System.out.println("7. Quit");
        int choice = InputController.getIntFromUser(1, 7);
        switch (choice) {
            case 1:
                listMovies();
                break;
            case 2:
                searchMovies();
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
                break;
        }
    }

    private void listMovies() {
        // get list of movies from some controller then list them
    }

    private void searchMovies() {

    }

    private void checkSeatAvailability() {

    }

    private void bookTicket() {
        // do sth with bookingController
    }

    private void viewBookingHistory() {

    }

}
