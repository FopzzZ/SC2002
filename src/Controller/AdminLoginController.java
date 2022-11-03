package Controller;

public class AdminLoginController {
    String username;

    public AdminLoginController(String username) {
        this.username = username;
    }

    public boolean verify(String username) {
        return false;
    }

    public boolean checkValidUsername() {
        return false;
    }
}
