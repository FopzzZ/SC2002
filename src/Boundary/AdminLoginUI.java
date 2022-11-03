package Boundary;

import Controller.AdminLoginController;
import Controller.InputController;

public class AdminLoginUI {
    private String username; // decide on userID or email

    public void main() {
        boolean result;
        boolean exit = false;

        do {
            result = verify();
            if (!result) {
                System.out.println("Invalid username or password.");
                System.out.println("1. Enter again");
                System.out.println("2. Exit");
                if (InputController.getIntFromUser() == 2) {
                    exit = true;
                }
            }
        } while (!result && !exit);
        if (result) {
            System.out.println("You have logged in sucessfully.\n\n");
            return;
        }
        return;
    }

    public boolean verify() {
        System.out.println("Please enter your email: ");
        username = InputController.getStringFromUser(); // get username

        AdminLoginController adminLoginController = new AdminLoginController();
        return adminLoginController.verify(username);
    }
}
