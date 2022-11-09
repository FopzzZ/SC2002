package Controller;

import java.util.ArrayList;
import java.io.*;

import Entity.Booking;
import Entity.User.User;

public class UserController {
    private final static String DataBaseFilePath = "DataBase/Users.txt";
    private static ArrayList<User> userList;

    public UserController() {
        userList = new ArrayList<User>();
        File dbFile = new File(DataBaseFilePath);
        if (dbFile.exists()) {
            userList = readFromDB();
        }
    }

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

    public boolean addUser(String email, String mobileNumber, String name, String dateOfBirth) {
        if (!EmailCheckController.isValid(email)) {
            System.out.println("Invalid email address");
            return false;
        }
        if (!DoBCheckController.isValid(dateOfBirth)) {
            System.out.println("Invalid date of birth (dd/mm/yyyy)");
            return false;
        }
        User newUser = new User(email, mobileNumber, name, dateOfBirth);
        userList.add(newUser);
        writeToDB(userList);
        System.out.println("User added successfully");
        return true;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

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

    public void clearDatabase() {
        while (userList.size() > 0) {
            userList.remove(0);
        }
        writeToDB(userList);
        System.out.println("Clearing user database");
    }

    public void addBookingToHistory(Booking booking, String userEmail) {
        for (User user : userList) {
            if (user.getEmail().equals(userEmail)) {
                user.addBooking(booking);
            }
        }
        writeToDB(userList);
    }

}
