package Entity.Showtime;

import Entity.Movie.*;
import Entity.Cinema.*;
import Entity.Seat.*;


public class Showtime {
    private Time startTime;
    private Movie movie;
    // cineplex
    private cinema cinema;
    private Seatplan seatplan;

    public Showtime() {
        startTime = new Time();
        movie = new Movie();
        cinema = new cinema();
        seatplan = new Seatplan(0, 0);
    }

    public void setTime(Time time) {
        this.startTime = time;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setCinema(cinema cinema) {
        this.cinema = cinema;
    }

    public void setSeatPlan(Seatplan seatplan) {
        this.seatplan = seatplan;
    }

    public Time getTime() {
        return this.startTime;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public cinema getCinema() {
        return this.cinema;
    }

    public Seatplan getSeatplan() {
        return this.seatplan;
    }
}
