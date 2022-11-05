package Controller;

import java.util.ArrayList;
import java.io.*;
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

    public void addUser(String email, String mobileNumber, String name) {
        User newUser = new User(email, mobileNumber, name);
        userList.add(newUser);
        writeToDB(userList);
    }

    public ArrayList<User> getUserList() {
        return this.userList;
    }

    // for adding users
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.addUser("bob@gmail.com", "99128412", "Bob");
        userController.addUser("john@gmail.com", "96729103", "John");
    }

}
