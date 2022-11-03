package Boundary;

import Controller.InputController;
import Controller.UserController;

public class UserMenuUI {
    public void main() {
        UserController userController = new UserController();
        System.out.println("Select an option:");
        System.out.println("1. Search/List movies");
        System.out.println("2. View movie details");
        System.out.println("3. Check seat availability");
        System.out.println("4. Book ticket");
        System.out.println("5. View booking history");
        System.out.println("6. List Top 5 ranking of movies");
        int choice = InputController.getIntFromUser();
        switch (choice) {
            case 1:
                userController.searchMovies();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                userController.bookTicket();
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
}
