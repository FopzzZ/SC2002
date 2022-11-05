package Boundary.AdminMenu;

import Controller.AdminLoginController;
import Controller.InputController;

public class AdminLoginUI {
    private String username, password; // decide on username or email

    public void main() {
        boolean validLogin, exit = false;
        while (true && exit == false) {
            System.out.println("Please enter your username: ");
            username = InputController.getStringFromUser(); // get username
            System.out.println("Please enter your password: ");
            password = InputController.getStringFromUser();
            AdminLoginController adminLoginController = new AdminLoginController(username);
            validLogin = adminLoginController.verify(password);
            if (!validLogin) {
                System.out.println("Invalid username or password.");
                System.out.println("1. Try again");
                System.out.println("2. Exit");
                int choice = InputController.getIntFromUser(1, 2);
                if (choice == 1) {
                    continue;
                } else if (choice == 2) {
                    exit = true;
                    continue;
                }
            } else {
                System.out.println("You have logged in sucessfully.\n\n");
                AdminMenuUI adminMenuUI = new AdminMenuUI();
                adminMenuUI.main();
            }
        }
    }
}