package Entity.User;

import java.io.Serializable;
/**
* Admin is an entity with administrative rights
*/
public class Admin implements Serializable {
    private String username;
    private String password;

    /**
    * A constructor for the Admin class
    * 
    * @param username Determines username of the admin
    * @param password Determines password of the admin
    */
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    /** 
     * A method that returns the username of the admin as a string
     * 
     * @return String This returns the username of the admin
     */
    public String getUsername() {
        return this.username;
    }

    
    /** 
     * A method that returns the password of the admin as a string
     * 
     * @return String This returns the password of the admin
     */
    public String getPassword() {
        return this.password;
    }

    
    /** 
     * A method that takes in a string and sets it as the username of the admin
     * 
     * @param username Determines the username of the admin
     */
    public void setUsername(String username) {
        this.username = username;
    }

    
    /** 
     * A method that takes in a string and sets it as the password of the admin
     * 
     * @param password Determines the password of the admin
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /** 
     * A method that returns the admin details as a string
     * 
     * @return String This returns the admin details
     */
    public String toString() {
        return "Username: " + getUsername() + "\nPassword: " + getPassword();
    }
}