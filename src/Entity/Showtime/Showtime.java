package Entity.Showtime;

import Entity.Cineplex.Cineplex;
import java.io.Serializable;
import Entity.Cinema.*;
import Entity.Seat.*;

/**
* Showtime is an entity 
*/
public class Showtime implements Serializable, Comparable<Showtime> {
    private boolean isHoliday;
    private Time startTime;
    private Time endTime;
    private Cineplex cineplex;
    private Cinema cinema;
    private SeatPlan seatPlan;

    /**
    * A constructor for the Showtime class with default values
    */
    public Showtime() {
        startTime = new Time();
        endTime = new Time();
        cinema = new Cinema();
        seatPlan = new SeatPlan(0, 0);
        isHoliday = false;
    }

    /**
    * A constructor for the Showtime class
    * 
    * @param startTime Determines the start time of the show
    * @param endTime Determines the end time of the show
    * @param cineplex Determines cineplex of the showtime
    * @param cinema Determines the cinema of the showtime
    * @param isHoliday Determines if the showtime falls on a holiday or not
    */
    public Showtime(Time startTime, Time endTime, Cineplex cineplex, Cinema cinema, boolean isHoliday) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.cinema = cinema;
        this.cineplex = cineplex;
        this.isHoliday = isHoliday;
        this.seatPlan = new SeatPlan(9, 24); // default
    }

    
    /** 
     * A method that takes in a showtime and updates the existing showtime
     * 
     * @param showtime Determines the showtime with details to update the existing showtime
     */
    public void update(Showtime showtime) {
        this.startTime = showtime.getStartTime();
        this.endTime = showtime.getEndTime();
        this.cinema = showtime.getCinema();
        this.cineplex = showtime.getCineplex();
        this.isHoliday = showtime.getIsHoliday();
    }

    
    /** 
     * A method that takes in a time and sets it as the start time of the showtime
     * 
     * @param time Determines the time to set as the start time
     */
    public void setStartTime(Time time) {
        this.startTime = time;
    }

    
    /** 
     * A method that takes in a time and sets it as the end time of the showtime
     * 
     * @param time Determines the time to set as the end time
     */
    public void setEndTime(Time time) {
        this.endTime = time;
    }

    
    /** 
     * A method that takes in a cineplex and sets it as the cineplex of the showtime
     * 
     * @param cineplex Determines the cineplex of the showtime
     */
    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    
    /** 
     * A method that takes in a cinema and sets it as the cinema of the showtime
     * 
     * @param cinema Determines the cinema of the showtime
     */
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    
    /** 
     * A method that takes in a seatplan and sets it as the seatplan of the showtime
     * 
     * @param seatPlan Determines the seat plan to be set for the showtime
     */
    public void setSeatPlan(SeatPlan seatPlan) {
        this.seatPlan = seatPlan;
    }

    
    /** 
     * A method that takes in a boolean and sets it as whether the showtime is a holiday or not
     * 
     * @param isHoliday Determines if the showtime is a holiday or not
     */
    public void setIsHoliday(boolean isHoliday) {
        this.isHoliday = isHoliday;
    }

    
    /** 
     * A method that returns the start time of the showtime as a time
     * 
     * @return Time This returns the start time of the showtime
     */
    public Time getStartTime() {
        return this.startTime;
    }

    
    /** 
     * A method that returns the end time of the showtime as a time
     * 
     * @return Time This returns the end time of the showtime
     */
    public Time getEndTime() {
        return this.endTime;
    }

    
    /** 
     * A method that returns the cinema of the showtime as a cinema
     * 
     * @return Cinema This returns the cinema of the showtime
     */
    public Cinema getCinema() {
        return this.cinema;
    }

    
    /** 
     * A method that returns the seat plan of the showtime as a seatPlan
     * 
     * @return SeatPlan This returns the seat plan of the showtime
     */
    public SeatPlan getSeatplan() {
        return this.seatPlan;
    }

    
    /** 
     * A method that returns true if the showtime falls on a holiday and false otherwise
     * 
     * @return boolean This returns true if the showtime falls on a holiday and false otherwise
     */
    public boolean getIsHoliday() {
        return this.isHoliday;
    }

    
    /** 
     * A method that returns the cineplex of the showtime as a cineplex
     * 
     * @return Cineplex This returns the cineplex of the showtime as a cineplex
     */
    public Cineplex getCineplex() {
        return this.cineplex;
    }

    
    /** 
     * A method that takes in a showtime and compares if the start time of the showtime is earlier than the one that called the method
     * 
     * @param y Determines the showtime to be compared to
     * 
     * @return int This returns -1 if the start time of showtime y is later, 1 if the start time of showtime y is earlier and 0 if they are equal 
     */
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

    
    /** 
     * A method that returns the showtime details as a string
     * 
     * @return String This returns the showtime details
     */
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

    
    /** 
     * A method that takes in a showtime and checks if it is equal to the showtime that called the method except for the seatPlan attribute
     * 
     * @param other Determines the showtime to be compared to
     * 
     * @return boolean This returns true if the showtimes have the same attributes aside from seatPlan and false otherwise
     */
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
