package Component.Time;

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

    public void show() {
        System.out.printf("%d %d-%d, %d:%d\n", year, month, day, hour, minutes);
    }
}
