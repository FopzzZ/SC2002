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
            ArrayList<Admin> adminList = (ArrayList<Admin>) ois.readObject();
            ois.close();
            return adminList;
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error when reading from admin DB");
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
            System.out.println("Error when writing to admin DB");
        }
    }

    public void create(String username, String password) {
        Admin newAdmin = new Admin(username, password);
        adminList.add(newAdmin);
        writeToDB(adminList);
    }

    public void clearDatabase() {
        while (adminList.size() > 0) {
            adminList.remove(0);
        }
        writeToDB(adminList);
        System.out.println("Clearing admin database");
    }

    public ArrayList<Admin> getAdminList() {
        return this.adminList;
    }
}
