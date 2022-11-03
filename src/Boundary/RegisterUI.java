//ignore this file first

package Boundary;

import Controller.*;

public class RegisterUI {
    private String username;
    private String password;
    private String password2;
    private boolean consistentPassword = false;

    public void main() {
        do {
            inputRegister();
            if (consistentPassword) {
                AdminController adminController = new AdminController();
                adminController.create(username, password); // need adminscontroller to be implemented
                System.out.println("You have registered successfully");
            } else {
                System.out.println("Password not consistent. Enter again");
            }
        } while (!consistentPassword);
    }

    public void inputRegister() {
        System.out.println("Username: ");
        username = InputController.getStringFromUser();
        System.out.println("Password: ");
        password = InputController.getStringFromUser();
        System.out.println("Confirm Password: ");
        password2 = InputController.getStringFromUser();
        consistentPassword = password.equals(password2);
    }
}
