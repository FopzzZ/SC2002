package Entity;

import java.io.Serializable;

import Entity.Showtime.Showtime;

public class Ticket implements Serializable {
    private double price;
    private Showtime showtime;

    public Ticket(double price, Showtime showtime) {
        this.price = price;
        this.showtime = showtime;
    }

    public double getPrice() {
        return this.price;
    }

    public Showtime getShowtime() {
        return this.showtime;
    }
    
}
