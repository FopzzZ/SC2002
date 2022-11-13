package Controller;

import java.util.ArrayList;
import java.io.*;

import Entity.User.*;

/**
 * Controller to access admin database
 */
public class AdminController {
    private final static String DataBaseFilePath = "database/Admins.txt";
    private ArrayList<Admin> adminList;

    /**
     * Class constructor
     */
    public AdminController() {
        adminList = new ArrayList<Admin>();
        File dbFile = new File(DataBaseFilePath);
        if (dbFile.exists()) {
            adminList = readFromDB();
        }
    }

    /**
     * Read stored admin list from database
     * 
     * @return ArrayList<Admin> stored admin list
     */
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

    /**
     * Write current admin list to database
     * 
     * @param adminList current list of admins
     */
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

    /**
     * Create a new admin
     * 
     * @param username username of new admin
     * @param password password of new admin
     */
    public void create(String username, String password) {
        Admin newAdmin = new Admin(username, password);
        adminList.add(newAdmin);
        writeToDB(adminList);
    }

    /**
     * Clears database
     */
    public void clearDatabase() {
        while (adminList.size() > 0) {
            adminList.remove(0);
        }
        writeToDB(adminList);
        System.out.println("Clearing admin database");
    }

    /**
     * Retrieves admin list
     * 
     * @return ArrayList<Admin> list of current admins
     */
    public ArrayList<Admin> getAdminList() {
        return this.adminList;
    }
}
