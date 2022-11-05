package Controller;

import java.util.ArrayList;

import Entity.User.Admin;

public class AdminLoginController {
    String username, password = null;

    public AdminLoginController(String username) {
        this.username = username;

        initialise();
    }

    private void initialise() {
        AdminController adminController = new AdminController();
        ArrayList<Admin> adminList = adminController.getAdminList();
        for (Admin admin : adminList) {
            System.out.println("Username:" + admin.getUsername()); // test
            if (admin.getUsername().matches(this.username)) {
                System.out.println("Admin found"); // test
                this.password = admin.getPassword();
                break;
            }
        }
    }

    public boolean verify(String password) {
        System.out.println(this.password); // test
        if (this.password != null && password.matches(this.password)) {
            return true;
        } else {
            return false;
        }
    }

}
