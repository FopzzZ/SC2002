package Boundary;

import Controller.InputController;

public class MainMenuUI {
    public void main() {
        System.out.println("1. Admin");
        System.out.println("2. User");
        int choice = InputController.getIntFromUser();
        switch (choice) {
            case 1:
                break;
            case 2:
                break;

        }
    }
}
