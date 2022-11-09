package Entity.User;

import java.io.Serializable;
import java.util.ArrayList;

import Entity.Booking;

public class User implements Serializable {
    private String email;
    private String mobileNumber;
    private String name;
    private String dateOfBirth;
    private ArrayList<Booking> bookingHistory;

    public User() {

    }

    public User(String email, String mobileNumber, String name, String dateOfBirth) {
        this.mobileNumber = mobileNumber;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.bookingHistory = new ArrayList<Booking>();
    }

    public ArrayList<Booking> getBookingHistory() {
        return this.bookingHistory;
    }

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
        }
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getName() {
        return this.name;

    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBookingHistory(ArrayList<Booking> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }

    public void addBooking(Booking booking) {
        bookingHistory.add(booking);
    }
}
