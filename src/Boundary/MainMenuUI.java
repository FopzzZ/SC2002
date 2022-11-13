package Boundary;

import Boundary.AdminMenu.AdminLoginUI;
import Boundary.UserMenu.UserLoginUI;
import Controller.InputController;

/**
* MainMenuUI is an entity containing the main menu interface
*/
public class MainMenuUI {
    public void main() {
        while (true) {
            System.out.println("\nWelcome to MOBLIMA");
            System.out.println("Please select login type");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Terminate Program");
            System.out.print("\nSelect Action: ");
            int choice = InputController.getIntFromUser(1, 3);
            switch (choice) {
                case 1:
                    AdminLoginUI adminLoginUI = new AdminLoginUI();
                    adminLoginUI.main();
                    break;
                case 2:
                    UserLoginUI userLoginUI = new UserLoginUI();
                    userLoginUI.main();
                    break;
                case 3:
                    System.out.println("Program Terminated!");
                    return;
            }
        }
    }
}
