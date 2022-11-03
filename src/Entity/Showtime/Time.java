package Entity.Showtime;

//Could be replace with 
public class Time {
    int year, month, day, hour, minutes;

    public Time() {
        this.year = 1970;
        this.month = 1;
        this.day = 1;
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
        ret = "" + this.year + "  " + this.month + "-" + day + ", " + hour + ":" + minutes;
        return ret;
    }

    public static void main(String[] args) {
        Time time = new Time(2022,12,2,23,59);
        System.out.println(time.toString());
    }
}
