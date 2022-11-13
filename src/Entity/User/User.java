package Entity.User;

import java.io.Serializable;
import java.util.ArrayList;

import Entity.Booking;

/**
* User is an entity
*/
public class User implements Serializable {
    private String email;
    private String mobileNumber;
    private String name;
    private String dateOfBirth;
    private ArrayList<Booking> bookingHistory;

    /**
    * A constructor for the User class with no initialised values
    */
    public User() {

    }
    /**
    * A constructor for the User class
    * 
    * @param email Determines the email of the user
    * @param mobileNumber Determines the mobile number of the user
    * @param name Determines the name of the user
    * @param dateOfBirth Determines the date of birth of the user
    */
    public User(String email, String mobileNumber, String name, String dateOfBirth) {
        this.mobileNumber = mobileNumber;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.bookingHistory = new ArrayList<Booking>();
    }

    
    /** 
     * A method that returns the booking history of the user as an arraylist
     * 
     * @return ArrayList<Booking> This returns the booking history of the user
     */
    public ArrayList<Booking> getBookingHistory() {
        return this.bookingHistory;
    }
    /** 
     * A method that prints the booking history of the user
     */
    public void printBookingHistory() {
        System.out.println("\n" +
                "-------------------\n" +
                "| Booking History |\n" +
                "-------------------");
        if (bookingHistory.size() == 0) {
            System.out.println("Booking history is empty");
            return;
        }
        int index = 1;
        for (Booking booking : bookingHistory) {
            System.out.print("\nBooking " + index + ":");
            index += 1;
            System.out.print(booking.toString());
            System.out.println("Start time: " + booking.getTicket().getShowtime().getStartTime().toString());
            System.out.println("Start time: " + booking.getTicket().getShowtime().getEndTime().toString());
            System.out.println("Location: " + booking.getTicket().getShowtime().getCineplex().getName() + " Cineplex "
                    + booking.getTicket().getShowtime().getCinema().getName());
            System.out.println("Ticket price: " + String.format("$%.2f", booking.getTicket().getPrice()));
        }
    }

    
    /** 
     * A method that returns the date of birth of the user as a string
     * 
     * @return String This returns of the date of birth of the user
     */
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    
    /** 
     * A method that returns the name of the user as a string
     * 
     * @return String This returns the name of the user
     */
    public String getName() {
        return this.name;

    }

    
    /** 
     * A method that returns the mobile number of the user as a string
     * 
     * @return String This returns the mobile number of the user
     */
    public String getMobileNumber() {
        return this.mobileNumber;
    }

    
    /** 
     * A method that returns the email of the user as a string
     * 
     * @return String This returns the email of the user
     */
    public String getEmail() {
        return this.email;
    }

    
    /** 
     * A method that takes in a string and sets it as the date of birth of the user
     * 
     * @param dateOfBirth Determines the date of birth of the user
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    
    /** 
     * A method that takes in a string and sets it as the name of the user
     * 
     * @param name Determines the name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * A method that takes in a string and sets it as the mobile number of the user
     * 
     * @param mobileNumber Determines the mobile number of the user
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;

    }

    
    /** 
     * A method that takes in a string and sets it as the email of the user
     * 
     * @param email Determines the email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * A method that takes in an arraylist of bookings and sets it as the booking history of the user
     * 
     * @param bookingHistory Determines the booking history of the user
     */
    public void setBookingHistory(ArrayList<Booking> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }

    
    /** 
     * A method that takes in a booking and adds it to the booking history of the user
     * 
     * @param booking Determines the booking to be added to the booking history of the user
     */
    public void addBooking(Booking booking) {
        bookingHistory.add(booking);
    }
}
