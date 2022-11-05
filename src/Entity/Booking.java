package Entity;

public class Booking {
    private Ticket ticket;
    private String name;
    private String mobileNumber;
    private String email;
    private String transactionID;

    public Booking() {

    }

    public Booking(Ticket ticket, String name, String mobileNumber, String email, String transactionID) {
        this.ticket = ticket;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.transactionID = transactionID;
    }

    public Ticket getTicket() {
        return this.ticket;
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

    public String getTransactionID() {
        return this.transactionID;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
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

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }
}
