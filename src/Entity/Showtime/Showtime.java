package Entity.Showtime;

import Entity.Cineplex.Cineplex;
import java.io.Serializable;
import Entity.Cinema.*;
import Entity.Seat.*;

public class Showtime implements Serializable, Comparable<Showtime> {
    private boolean isHoliday;
    private Time startTime;
    private Time endTime;
    private Cineplex cineplex;
    private Cinema cinema;
    private SeatPlan seatPlan;

    public Showtime() {
        startTime = new Time();
        endTime = new Time();
        cinema = new Cinema();
        seatPlan = new SeatPlan(0, 0);
        isHoliday = false;
    }

    public Showtime(Time startTime, Time endTime, Cineplex cineplex, Cinema cinema, boolean isHoliday) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.cinema = cinema;
        this.cineplex = cineplex;
        this.isHoliday = isHoliday;
        this.seatPlan = new SeatPlan(9, 24); // default for now
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

    public void setSeatPlan(SeatPlan seatPlan) {
        this.seatPlan = seatPlan;
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
        return this.seatPlan;
    }

    public boolean getIsHoliday() {
        return this.isHoliday;
    }

    public Cineplex getCineplex() {
        return this.cineplex;
    }

    public int compareTo(Showtime y) {
        if (this.getStartTime().getYear() != y.startTime.getYear())
            return this.getStartTime().getYear() < y.getStartTime().getYear() ? -1 : 1;
        if (this.getStartTime().getMonth() != y.startTime.getMonth())
            return this.startTime.getMonth() < y.getStartTime().getMonth() ? -1 : 1;
        if (this.getStartTime().getDay() != y.startTime.getDay())
            return this.getStartTime().getDay() < y.getStartTime().getDay() ? -1 : 1;
        if (this.getStartTime().getHour() != y.startTime.getHour())
            return this.getStartTime().getHour() < y.getStartTime().getHour() ? -1 : 1;
        if (this.getStartTime().getMinutes() != y.startTime.getMinutes())
            return this.getStartTime().getMinutes() < y.getStartTime().getMinutes() ? -1 : 1;
        return 0;
    }

    public String toString() {
        String ret = new String();
        String isHoliday = "";
        if (this.getIsHoliday())
            isHoliday = "YES";
        else
            isHoliday = "NO";
        ret = "\n"
                + "Start time: " + this.getStartTime().toString() + "\n"
                + "End time: " + this.getEndTime().toString() + "\n"
                + "Cineplex: " + this.getCineplex().getName() + "\n"
                + "Cinema: " + this.getCinema().getName() + "\n"
                + "Cinema type: " + this.getCinema().getType().toString() + "\n"
                + "Is a holiday: " + isHoliday + "\n";
        return ret;
    }

    public boolean matchExceptSeatplan(Showtime other) {
        if (this.startTime.equals(other.getStartTime()) &&
                this.endTime.equals(other.getEndTime()) &&
                this.cineplex.equals(other.getCineplex()) &&
                this.cinema.equals(other.getCinema()) &&
                this.isHoliday == other.getIsHoliday()) {
            return true;
        } else {
            return false;
        }
    }

}
