package AdminSystem;

import java.util.ArrayList;

import Main;

public class loginSystem {
    ArrayList<Admin> listOfAdmin = new ArrayList<Admin>();

    public loginSystem() {
        initDb();
    }

    private void initDb() {
        // init from data base
    }

    public void registerAdmin(String ID, String password) {
        Admin a = new Admin(ID, password);
        listOfAdmin.add(a);
    }

    private int searchAdminIndex(String ID) {
        for (int i = 0; i < listOfAdmin.size(); ++i) {
            if (listOfAdmin.get(i).getID().equals(ID))
                return i;
        }
        return -1;
    }

    public boolean login() {
        while (true) {
            System.out.println("Enter your ID: (input 'exit' to exit login system) ");
            String ID = Main.sc.nextLine();
            if (ID == "exit")
                return false;
            int index = searchAdminIndex(ID);
            if (index == -1) {
                System.out.println("No such user.");
                continue;
            }
            System.out.println("Enter your password:");
            String password = Main.sc.nextLine();
            Admin admin = listOfAdmin.get(index);
            if (admin.validate(password)) {
                return true;
            }
            System.out.println("Password is WRONG.");
        }
    }

    public static void main(String[] args) {
        loginSystem lg = new loginSystem();
        lg.registerAdmin("Admin", "Admin");
        lg.login();
    }
}
