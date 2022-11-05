package Entity.Showtime;

import Entity.Cineplex.Cineplex;
import java.io.Serializable;
import Entity.Cinema.*;
import Entity.Seat.*;

public class Showtime implements Serializable {
    private boolean isHoliday;
    private Time startTime;
    private Time endTime;
    private Cineplex cineplex;
    private Cinema cinema;
    private SeatPlan seatplan;

    public Showtime() {
        startTime = new Time();
        endTime = new Time();
        cinema = new Cinema();
        seatplan = new SeatPlan(0, 0);
        isHoliday = false;
    }

    public Showtime(Time startTime, Time endTime, Cineplex cineplex, Cinema cinema, boolean isHoliday) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.cinema = cinema;
        this.cineplex = cineplex;
        this.isHoliday = isHoliday;
    }

    public void update(Showtime showtime) {
        this.startTime = showtime.getStartTime();
        this.endTime = showtime.getEndTime();
        this.cinema = showtime.getCinema();
        this.cineplex = showtime.getCineplex();
        this.isHoliday = showtime.getIsHoliday();
    }

    public void setStartTime(Time time) {
        this.startTime = time;
    }

    public void setEndTime(Time time) {
        this.endTime = time;
    }

    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
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

    public Time getStartTime() {
        return this.startTime;
    }

    public Time getEndTime() {
        return this.endTime;
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
        if (this.getIsHoliday())
            discount = "YES";
        else
            discount = "NO";
        ret = "\n"
                + "Start time: " + this.getStartTime().toString() + "\n"
                + "End time: " + this.getEndTime().toString() + "\n"
                + "Cineplex: " + this.getCineplex().getName() + "\n"
                + "Cinema: " + this.getCinema().getName() + "\n"
                + "Have holiday discount: " + discount + "\n\n";
        return ret;
    }

}
