package Entity.Showtime;

import java.io.Serializable;
import java.util.Calendar;

//Could be replace with 
public class Time implements Serializable {
    private int year, month, day, hour, minutes;

    public Time() {
        this.year = 1970;
        this.month = 1;
        this.day = 1;
    }

    public Time(String time) {
        this.year = Integer.parseInt(time.substring(0, 4));
        this.month = Integer.parseInt(time.substring(4, 6));
        this.day = Integer.parseInt(time.substring(6, 8));
        this.hour = Integer.parseInt(time.substring(8, 10));
        this.minutes = Integer.parseInt(time.substring(10, 12));
    }

    public Time(int year, int month, int day, int hour, int minutes) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minutes = minutes;
    }

    public String toString() {
        String ret = "";
        ret = "" + this.year + "  ";
        if(this.month <= 9) ret += "0";
        ret += "" + this.month;
        ret += "-" ;
        if(this.day <= 9 ) ret += "0";
        ret = ret + this.day;
        ret = ret + ", ";
        if(this.hour <= 9) ret += "0";
        ret = ret + this.hour;
        ret = ret + ":";
        if(minutes <= 9) ret += "0";
        ret = ret + this.minutes;
        return ret;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    // 1 is fri, 4 is mon, 5 is tue
    public int getDayOfWeek() {
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    // testing
    public static void main(String[] args) {
        Time time = new Time(2022, 11, 7, 12, 00);
        System.out.println(time.toString());
        System.out.println(time.getDayOfWeek());

    }

}
