package Controller;

import java.util.ArrayList;
import java.io.*;

import Entity.User.*;

public class AdminController {
    private final static String DataBaseFilePath = "DataBase/Admins.txt";
    private ArrayList<Admin> adminList;

    public AdminController() {
        adminList = new ArrayList<Admin>();
        File dbFile = new File(DataBaseFilePath);
        if (dbFile.exists()) {
            adminList = readFromDB();
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Admin> readFromDB() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DataBaseFilePath));
            ArrayList<Admin> movieListing = (ArrayList<Admin>) ois.readObject();
            ois.close();
            return movieListing;
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error when reading from DB");
        }
        return new ArrayList<Admin>();
    }

    public void writeToDB(ArrayList<Admin> adminList) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DataBaseFilePath));
            out.writeObject(adminList);
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.print(e.toString());
            System.out.println("Error when writing to DB");
        }
    }

    public void create(String username, String password) {
        Admin newAdmin = new Admin(username, password);
        adminList.add(newAdmin);
        writeToDB(adminList);
    }

    public ArrayList<Admin> getAdminList() {
        return this.adminList;
    }
}
