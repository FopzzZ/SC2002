package Controller;

import java.util.ArrayList;

import Entity.User.User;

/**
 * Controller to manage user login
 */
public class UserLoginController {
    private String email;
    private boolean userExists = false;
    private UserController userController;

    /**
     * Class constructor
     * 
     * @param email email of user
     */
    public UserLoginController(String email) {
        this.email = email;
        initialise();
    }

    /**
     * Check if user exists
     */
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

    /**
     * Check if user exists
     * 
     * @return boolean whether user exists
     */
    public boolean doesUserExist() {
        return userExists;
    }

    /**
     * Add user
     * 
     * @param email        email of user
     * @param mobileNumber mobile number of user
     * @param name         name of user
     * @param dateOfBirth  dob of user
     */
    public void addUser(String email, String mobileNumber, String name, String dateOfBirth) {
        userController.addUser(email, mobileNumber, name, dateOfBirth);
        userExists = true;
    }
}
