package Controller;

import java.util.ArrayList;

import Entity.User.Admin;

/**
 * Controller to verify password when admin attempts to login
 */
public class AdminLoginController {
    String username, password = null;

    /**
     * Class constructor
     * 
     * @param username username of admin trying to login
     */
    public AdminLoginController(String username) {
        this.username = username;
        initialise();
    }

    /**
     * Gets password that matches username from database and stores it into the
     * class
     */
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

    /**
     * @param password password provided by admin trying to login
     * @return boolean whether password matches username
     */
    public boolean verify(String password) {
        if (this.password != null && password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }

}
