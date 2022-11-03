package Boundary;

import Controller.InputController;

public class AdminLoginUI {
    private String username; // decide on userID or email
    private String password;

    public boolean main() {
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
            return true;
        }
        return false;
    }

    public boolean verify() {
        System.out.println("Please enter your email: ");
        username = InputController.getStringFromUser(); // get username
        System.out.println("Password: ");
        password = InputController.getStringFromUser(); // get password

        if (username == null) { // get rid of empty username (invalid input)
            return false;
        } else {
            // to be implemented, must check if username exist and if yes, then see if
            // password match
        }
    }
}
