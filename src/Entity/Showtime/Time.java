package Entity.Showtime;

import java.io.Serializable;
import java.util.Calendar;

/**
* Time is an entity
*/
public class Time implements Serializable {
    private int year, month, day, hour, minutes;

    /**
    * A constructor for the Time class with default values assigned
    */
    public Time() {
        this.year = 1970;
        this.month = 1;
        this.day = 1;
    }

    /**
    * A constructor for the Time class
    * 
    * @param time Determines the time as a string
    */
    public Time(String time) {
        this.year = Integer.parseInt(time.substring(0, 4));
        this.month = Integer.parseInt(time.substring(4, 6));
        this.day = Integer.parseInt(time.substring(6, 8));
        this.hour = Integer.parseInt(time.substring(8, 10));
        this.minutes = Integer.parseInt(time.substring(10, 12));
    }

    /**
    * A constructor for the Time class
    * 
    * @param year Determines the year
    * @param month Determines the month
    * @param day Determines the day
    * @param hour Determines the hour
    * @param minutes Determines the minutes
    */
    public Time(int year, int month, int day, int hour, int minutes) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minutes = minutes;
    }

    
    /** 
     * A method that returns the time as a string
     * 
     * @return String This returns the time as a string
     */
    public String toString() {
        String ret = "";
        ret = this.year + "-";
        if (this.month <= 9)
            ret += "0";
        ret += this.month + "-";
        if (this.day <= 9)
            ret += "0";
        ret += this.day + ", ";
        if (this.hour <= 9)
            ret += "0";
        ret += this.hour + ":";
        if (this.minutes <= 9)
            ret += "0";
        ret += this.minutes;
        return ret;
    }

    
    /** 
     * A method that returns the year as an int 
     * 
     * @return int This returns the year 
     */
    public int getYear() {
        return this.year;
    }

    
    /** 
     * A method that returns the month as an int
     * 
     * @return int This returns the month
     */
    public int getMonth() {
        return this.month;
    }

    
    /** 
     * A method that returns the day as an int
     * 
     * @return int This returns the day
     */
    public int getDay() {
        return this.day;
    }

    
    /** 
     * A method that returns the hour as an int
     * 
     * @return int This returns the hour
     */
    public int getHour() {
        return this.hour;
    }

    
    /** 
     * A method that returns the minutes as an int
     * 
     * @return int This returns the minutes
     */
    public int getMinutes() {
        return this.minutes;
    }

    
    /** 
     * A method that returns the day of the week as an int
     * 
     * @return int This returns the day of the week (1 is friday, 2 is saturday and so on)
     */
    // 1 is fri, 4 is mon, 5 is tue
    public int getDayOfWeek() {
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        return c.get(Calendar.DAY_OF_WEEK);
    }

}
