package Controller;

import java.util.ArrayList;

import Entity.Cinema.Cinema;
import Entity.Cineplex.Cineplex;
import Entity.Movie.Movie;
import Entity.Showtime.*;

public class ShowtimeController {
    private Movie movie;
    private ArrayList<Showtime> showtimeList;
    private MovieController movieController;

    public ShowtimeController(Movie movie) {
        this.movie = movie;
        movieController = new MovieController();
        showtimeList = movie.getShowtimes();
    }

    public void create(Movie movie, Time startTime, Time endTime, Cineplex cineplex, Cinema cinema, boolean isHoliday) {
        showtimeList.add(new Showtime(startTime, endTime, cineplex, cinema, isHoliday));
        movieController.updateShowtime(movie, showtimeList);

    } // adds a showtime to movie

    public void showAllShowtimes() {
        for (int i = 0; i < showtimeList.size(); ++i) {
            System.out.printf("Showtime %d: %s\n", i + 1, showtimeList.get(i).toString());
        }
        System.out.printf("Total %d showtimes.\n", showtimeList.size());
    }

    public void updateShowtime(int index, Showtime showtime) {
        showtimeList.get(index).update(showtime);
        movieController.updateShowtime(movie, showtimeList);
    }

    public void removeShowtime(int index) {
        showtimeList.remove(index);
        movieController.updateShowtime(movie, showtimeList);
    }

    public ArrayList<Showtime> getShowtimeList() {
        return this.showtimeList;
    }
}
