package Entity;

import java.io.Serializable;

import Controller.UserController;
import Entity.User.User;

/**
* Booking is an entity
*/
public class Booking implements Serializable {
    private Ticket ticket;
    private String name;
    private String mobileNumber;
    private String email;
    private String transactionID;

    /**
    * A constructor for the Booking class
    * 
    * @param ticket Determines the ticket of the booking
    * @param userEmail Determines the email of the user of the booking
    * @param transactionID Determines the transaction ID of the booking
    */
    public Booking(Ticket ticket, String userEmail, String transactionID) {
        this.ticket = ticket;
        this.transactionID = transactionID;
        UserController userController = new UserController();
        User user = userController.getUser(userEmail);
        this.name = user.getName();
        this.mobileNumber = user.getMobileNumber();
        this.email = userEmail;
    }
    /**
    * A constructor for the Booking class
    * 
    * @param ticket Determines the ticket of the booking
    * @param name Determines the name of the user of the booking
    * @param mobileNumber Determines the mobile number of the booking
    * @param email Determines the mobile number of the user of the booking
    * @param transactionID Determines the transaction ID of the booking
    */
    public Booking(Ticket ticket, String name, String mobileNumber, String email, String transactionID) {
        this.ticket = ticket;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.transactionID = transactionID;
    }

    
    /** 
     * A method that returns the ticket of the booking as a ticket
     * 
     * @return Ticket This returns the ticket of the booking
     */
    public Ticket getTicket() {
        return this.ticket;
    }

    
    /** 
     * A method that returns the name of the user making the booking as a string
     * 
     * @return String This returns the name of the user making the booking
     */
    public String getName() {
        return this.name;

    }

    
    /** 
     * A method that returns the mobile number of the user making the booking as a string
     * 
     * @return String This returns the mobile number of the user making the booking
     */
    public String getMobileNumber() {
        return this.mobileNumber;
    }

    
    /** 
     * A method that returns the email of the user making the booking as a string
     * 
     * @return String This returns the email of the user making the booking
     */
    public String getEmail() {
        return this.email;
    }

    
    /** 
     * A method that returns the transaction ID of the booking as a string
     * 
     * @return String This returns the transaction ID of the booking
     */
    public String getTransactionID() {
        return this.transactionID;
    }

    
    /** 
     * A method that takes in a ticket and sets it as the ticket of the booking
     * 
     * @param ticket Determines the ticket of the booking
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    
    /** 
     * A method that takes in a string and sets it as the name of the user of the booking
     * 
     * @param name Determines the name of the user of the booking
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * A method that takes in a string and sets it as the mobile number of the user of the booking
     * 
     * @param mobileNumber Determines the mobile number of the user of the booking
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;

    }

    
    /** 
     * A method that takes in a string and sets it as the email of the booking
     * 
     * @param email Determines the email of the booking
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * A method that takes in a string and sets it as the transaction ID of the booking
     * 
     * @param transactionID Determines the transaction ID of the booking
     */
    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    /** 
     * A method that returns the details of the booking as a string
     * 
     * @return String This returns the details of the booking
     */
    public String toString() {
        String ret = new String();
        ret = "\n"
                + "Name: " + this.getName() + "\n"
                + "Mobile number: " + this.getMobileNumber() + "\n"
                + "Email: " + this.getEmail() + "\n"
                + "Transaction ID: " + this.getTransactionID() + "\n";
        return ret;
    }
}
