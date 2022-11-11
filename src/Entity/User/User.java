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

    /**
     * @return ArrayList<Booking>
     */
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
            System.out.println("Start time: " + booking.getTicket().getShowtime().getStartTime().toString());
            System.out.println("Start time: " + booking.getTicket().getShowtime().getEndTime().toString());
            System.out.println("Location: " + booking.getTicket().getShowtime().getCineplex().getName() + " Cineplex "
                    + booking.getTicket().getShowtime().getCinema().getName());
            System.out.println("Ticket price: " + String.format("$%.2f", booking.getTicket().getPrice()));
        }
    }

    /**
     * @return String
     */
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * @return String
     */
    public String getName() {
        return this.name;

    }

    /**
     * @return String
     */
    public String getMobileNumber() {
        return this.mobileNumber;
    }

    /**
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param dateOfBirth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param mobileNumber
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;

    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param bookingHistory
     */
    public void setBookingHistory(ArrayList<Booking> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }

    /**
     * @param booking
     */
    public void addBooking(Booking booking) {
        bookingHistory.add(booking);
    }
}
