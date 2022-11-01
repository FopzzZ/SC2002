package SC2002.Component.ShowTime;

import SC2002.Component.Cinema.cinema;
import SC2002.Component.Movie.Movie;
import SC2002.Component.Seat.Seat;
import SC2002.Component.Seat.Seatplan;
import SC2002.Component.Time.*;

public class Showtime {
    Time startTime;
    Movie movie;
    //cineplex
    cinema cinema;
    Seatplan seatplan;
    public Showtime() {
        startTime = new Time();
        movie = new Movie();
        cinema = new cinema();
    }

    public void setTime(Time time){
        this.startTime = time;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setCinema(cinema cinema) {
        this.cinema = cinema;
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
}
