package Boundary.UserMenu;

import Controller.InputController;
import Controller.UserLoginController;

public class UserLoginUI {
    public void main() {
        System.out.println("\n" +
                "------------------\n" +
                "| Customer Login |\n" +
                "------------------");
        System.out.print("Please enter your email: ");
        String userEmail = InputController.getEmailFromUser();
        UserLoginController userLoginController = new UserLoginController(userEmail);
        if (userLoginController.doesUserExist() == false) {
            System.out.print("Please enter your mobile number: ");
            String mobileNumber = InputController.getMobileNumberFromUser();
            System.out.print("Please enter your name: ");
            String name = InputController.getStringFromUser();
            System.out.print("Please enter your date of birth in DD/MM/YYYY(eg. 01/01/1970): ");
            String dateOfBirth = InputController.getDateOfBirthFromUser();
            userLoginController.addUser(userEmail, mobileNumber, name, dateOfBirth);
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
