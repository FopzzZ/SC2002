package Controller;

public class AdminLoginController {
    String username, password;

    public AdminLoginController(String username) {
        this.username = username;
        initialise();
    }

    private void initialise() {
        // TODO read in from data file and save password to this.password
    }

    public boolean verify(String password) {
        if (password == this.password) {
            return true;
        } else {
            return false;
        }
    }

}
