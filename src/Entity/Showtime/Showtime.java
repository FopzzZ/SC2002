package Entity.Showtime;

import Entity.Cineplex.Cineplex;
import Entity.Movie.*;
import java.io.Serializable;
import Entity.Cinema.*;
import Entity.Seat.*;

public class Showtime implements Serializable{
    private int ID;
    private boolean isHoliday;
    private Time startTime;
    private Movie movie;
    private Cineplex cineplex;
    private Cinema cinema;
    private SeatPlan seatplan;

    public Showtime() {
        startTime = new Time();
        movie = new Movie();
        cinema = new Cinema();
        seatplan = new SeatPlan(0, 0);
        isHoliday = false;
    }

    public Showtime(int ID, Movie movie, Time startTime, Cineplex cineplex, Cinema cinema, boolean isHoliday) {
        this.ID = ID;
        this.movie = movie;
        this.startTime = startTime;
        this.cinema = cinema;
        this.cineplex = cineplex;   
        this.isHoliday = isHoliday;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTime(Time time) {
        this.startTime = time;
    }

    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void setSeatPlan(SeatPlan seatplan) {
        this.seatplan = seatplan;
    }
    
    public void setIsHoliday(boolean isHoliday) {
        this.isHoliday = isHoliday;
    }

    public int getID() {
        return this.ID;
    }

    public Time getTime() {
        return this.startTime;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public Cinema getCinema() {
        return this.cinema;
    }

    public SeatPlan getSeatplan() {
        return this.seatplan;
    }

    public boolean getIsHoliday() {
        return this.isHoliday;
    }

    public Cineplex getCineplex() {
        return this.cineplex;
    }

    public String toString() {
        String ret = new String();
        String discount = "";
        if(this.getIsHoliday()) discount = "YES";
        else discount = "NO";
        ret = "Showtime ID: " + this.getID() + "\n"
            + "Movie: " + this.getMovie().getTitle() + "\n"
            + "Time: " + this.getTime().toString() + "\n"
            + "Cineplex: " + this.getCineplex().getName() + "\n"
            + "Cinema: " + this.getCinema().getName() + "\n"
            + "Have holiday discount: " + discount +"\n\n";
        return ret;
    }

    //unit test(haven't do)
}
