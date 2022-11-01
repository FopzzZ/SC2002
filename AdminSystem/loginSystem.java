package SC2002.AdminSystem;

import java.util.HashMap;

import SC2002.Main;

public class loginSystem {
    HashMap<String, String> dbPassword = new HashMap<String, String>();
    public loginSystem() {
        initDb();
    }
    private void initDb() {
        dbPassword.put("admin","admin");
    }
    public boolean login() {
        while(true) {
            System.out.println("Enter your ID:");
            String ID = Main.sc.nextLine();
            if(ID.equals("exit"))  {
                return false;
            }
            System.out.println("Enter your password");
            String password = Main.sc.nextLine();
            if(dbPassword.containsKey(ID) && dbPassword.get(ID).equals(password))  {
                return true;
            }
        }
    }
    public static void main (String[] args) {
        loginSystem lg = new loginSystem();
        lg.login();
    }
}
