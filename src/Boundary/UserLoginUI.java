package Boundary;

import Controller.InputController;
import Controller.UserController;

public class UserLoginUI {
    public void main() {
        System.out.println("Please enter your email:");
        String userEmail = InputController.getEmailFromUser();
        UserController userController = new UserController(userEmail);
        userController.main();
    }
}
