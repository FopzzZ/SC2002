package src.AdminSystem;


public class Admin {
    private String ID, password;

    public Admin(String ID, String password) {
        this.ID = ID;
        this.password = password;
    }

    public boolean validate(String password) {
        return password.equals(this.password);
    }

    public String getID(){
        return this.ID;
    }
    //note: can use hash here
    public String getPassword() {
        return this.password;
    }
}
