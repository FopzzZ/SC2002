package Boundary;

import Controller.InputController;

public class MainMenuUI {
    public void main() {
        System.out.println("Welcome to MOBLIMA");
        System.out.println("Please select login type");
        System.out.println("1. Admin");
        System.out.println("2. User");
        int choice = InputController.getIntFromUser();
        switch (choice) {
            case 1:
                AdminLoginUI adminLoginUI = new AdminLoginUI();
                adminLoginUI.main();
                break;
            case 2:
                UserMenuUI userMenuUI = new UserMenuUI();
                userMenuUI.main();
                break;

        }
    }
}
