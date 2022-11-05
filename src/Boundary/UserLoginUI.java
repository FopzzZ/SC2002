package Boundary;

import Controller.InputController;
import Controller.UserLoginController;

public class UserLoginUI {
    public void main() {
        System.out.println("Please enter your email:");
        String userEmail = InputController.getEmailFromUser();
        UserLoginController userLoginController = new UserLoginController(userEmail);
        if (userLoginController.doesUserExist() == false) {
            System.out.println("Please enter your mobile number:");
            String mobileNumber = InputController.getMobileNumberFromUser();
            System.out.println("Please enter your name:");
            String name = InputController.getStringFromUser();
            userLoginController.addUser(userEmail, mobileNumber, name);
        }
        UserMenuUI userMenuUI = new UserMenuUI(userEmail);
        userMenuUI.main();
    }

    // for testing
    public static void main(String[] args) {
        UserLoginUI userLoginUI = new UserLoginUI();
        userLoginUI.main();
    }
}
