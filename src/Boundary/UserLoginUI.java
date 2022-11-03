package Boundary;

import Controller.InputController;

public class UserLoginUI {
    public void main() {
        System.out.println("Please enter your email:");
        String userEmail = InputController.getEmailFromUser();
        UserMenuUI userMenuUI = new UserMenuUI(userEmail);
        userMenuUI.main();
    }
}
