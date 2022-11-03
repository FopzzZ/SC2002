package Entity.Showtime;

import Entity.Movie.*;
import Entity.Cinema.*;
import Entity.Seat.*;

public class Showtime {
    private Time startTime;
    private Movie movie;
    // cineplex
    private Cinema cinema;
    private SeatPlan seatplan;

    public Showtime() {
        startTime = new Time();
        movie = new Movie();
        cinema = new Cinema();
        seatplan = new SeatPlan(0, 0);
    }

    public void setTime(Time time) {
        this.startTime = time;
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
}
