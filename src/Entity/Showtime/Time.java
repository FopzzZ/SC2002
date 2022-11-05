package Entity.Showtime;

//Could be replace with 
public class Time {
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
        ret = "" + this.year + "  " + this.month + "-" + day + ", " + hour + ":" + minutes;
        return ret;
    }

    public static void main(String[] args) {
        Time time = new Time(2022, 12, 2, 23, 59);
        System.out.println(time.toString());
    }
}
