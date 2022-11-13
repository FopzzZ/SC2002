package Entity;

import java.io.Serializable;

import Entity.Showtime.Showtime;

/**
* Ticket is an entity
*/
public class Ticket implements Serializable {
    private double price;
    private Showtime showtime;

    /**
    * A constructor for the Ticket class
    * 
    * @param price Determines the price of the ticket
    * @param showtime Determines the showtime of the ticket
    */
    public Ticket(double price, Showtime showtime) {
        this.price = price;
        this.showtime = showtime;
    }

    
    /** 
     * A method that returns the price of the ticket as a double
     * 
     * @return double This returns the price of the ticket
     */
    public double getPrice() {
        return this.price;
    }

    
    /** 
     * A method that returns the showtime of the ticket as a showtime
     * 
     * @return Showtime This returns the showtime of the ticket
     */
    public Showtime getShowtime() {
        return this.showtime;
    }
    
}
