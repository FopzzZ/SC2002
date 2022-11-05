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
            if (admin.getUsername().equals(this.username)) {
                this.password = admin.getPassword();
                break;
            }
        }
    }

    public boolean verify(String password) {
        if (this.password != null && password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }

}
