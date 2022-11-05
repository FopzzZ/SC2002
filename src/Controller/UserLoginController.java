package Controller;

import java.util.ArrayList;

import Entity.User.User;

public class UserLoginController {
    private String email;
    private boolean userExists = false;
    private UserController userController;

    public UserLoginController(String email) {
        this.email = email;
        initialise();
    }

    private void initialise() {
        userController = new UserController();
        ArrayList<User> userList = userController.getUserList();
        for (User user : userList) {
            if (user.getEmail().equals(this.email)) {
                userExists = true;
                break;
            }
        }
    }

    public boolean doesUserExist() {
        return userExists;
    }

    public void addUser(String email, String mobileNumber, String name) {
        userController.addUser(email, mobileNumber, name);
        userExists = true;
    }
}
