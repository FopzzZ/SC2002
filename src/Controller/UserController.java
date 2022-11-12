package Controller;

import java.util.ArrayList;
import java.io.*;

import Entity.Booking;
import Entity.User.User;

/**
 * Controller to manage user database
 */
public class UserController {
    private final static String DataBaseFilePath = "DataBase/Users.txt";
    private static ArrayList<User> userList;

    /**
     * Class constructor
     */
    public UserController() {
        userList = new ArrayList<User>();
        File dbFile = new File(DataBaseFilePath);
        if (dbFile.exists()) {
            userList = readFromDB();
        }
    }

    /**
     * Read user list from database
     * 
     * @return ArrayList<User> user list stored in database
     */
    @SuppressWarnings("unchecked")
    public ArrayList<User> readFromDB() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DataBaseFilePath));
            ArrayList<User> userList = (ArrayList<User>) ois.readObject();
            ois.close();
            return userList;
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error when reading from user DB");
            System.out.println(e);
        }
        return new ArrayList<User>();
    }

    /**
     * Write current user list to database
     * 
     * @param userList current user list
     */
    public void writeToDB(ArrayList<User> userList) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DataBaseFilePath));
            out.writeObject(userList);
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.print(e.toString());
            System.out.println("Error when writing to user DB");
        }
    }

    /**
     * Adds a new user
     * 
     * @param email        email of user
     * @param mobileNumber mobile number of user
     * @param name         name of user
     * @param dateOfBirth  dob of user
     * @return boolean whether user is added successfully
     */
    public boolean addUser(String email, String mobileNumber, String name, String dateOfBirth) {
        if (!EmailCheckController.isValid(email)) {
            return false;
        }
        if (!DoBCheckController.isValid(dateOfBirth)) {
            return false;
        }
        User newUser = new User(email, mobileNumber, name, dateOfBirth);
        userList.add(newUser);
        writeToDB(userList);
        return true;
    }

    /**
     * Get current user list
     * 
     * @return ArrayList<User> current user list
     */
    public ArrayList<User> getUserList() {
        return userList;
    }

    /**
     * Get user
     * 
     * @param email email of user
     * @return User user with specified email
     */
    public User getUser(String email) {
        for (User user : userList) {
            // System.out.println(user.getEmail());
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        System.out.println("No user found for some reason. Error somewhere");
        return new User();
    }

    /**
     * Clear database
     */
    public void clearDatabase() {
        while (userList.size() > 0) {
            userList.remove(0);
        }
        writeToDB(userList);
        System.out.println("Clearing user database");
    }

    /**
     * Add a booking to user's booking history
     * 
     * @param booking   booking to be added
     * @param userEmail email of user
     */
    public void addBookingToHistory(Booking booking, String userEmail) {
        for (User user : userList) {
            if (user.getEmail().equals(userEmail)) {
                user.addBooking(booking);
            }
        }
        writeToDB(userList);
    }

}
