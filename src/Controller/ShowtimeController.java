package Controller;

import java.util.ArrayList;

import Entity.Cinema.Cinema;
import Entity.Cineplex.Cineplex;
import Entity.Movie.Movie;
import Entity.Showtime.*;

public class ShowtimeController {
    private Movie movie;
    private ArrayList<Showtime> showtimeList;
    private ArrayList<Showtime> filteredShowtimeList;
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

    public void showAllFilteredShowtimes(Cineplex cineplex) {
        filteredShowtimeList = new ArrayList<Showtime>();
        for (Showtime showtime : showtimeList) {
            if (showtime.getCineplex().getName().equals(cineplex.getName())) {
                filteredShowtimeList.add(showtime);
            }
        }
        for (int i = 0; i < filteredShowtimeList.size(); ++i) {
            System.out.printf("Showtime %d: %s\n", i + 1, filteredShowtimeList.get(i).toString());
        }
        System.out.printf("Total %d showtimes.\n", filteredShowtimeList.size());
    }

    public void updateShowtime(int index, Showtime showtime) {
        showtimeList.get(index).update(showtime);
        movieController.updateShowtime(movie, showtimeList);
    }

    public void updateSeatingPlan(Showtime updatedShowtime) { // TODO make better, now is temp solution
        boolean found = false;
        for (Showtime showtime : showtimeList) {
            if (showtime.matchExceptSeatplan(updatedShowtime)) {
                showtime.setSeatPlan(updatedShowtime.getSeatplan());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Showtime not found error");
        }
        movieController.updateShowtime(movie, showtimeList);
    }

    public void removeShowtime(int index) {
        showtimeList.remove(index);
        movieController.updateShowtime(movie, showtimeList);
    }

    public ArrayList<Showtime> getShowtimeList() {
        return this.showtimeList;
    }

    public ArrayList<Showtime> getFilteredShowtimeList() {
        return this.filteredShowtimeList;
    }

    // TODO implement a sort showtime function
}
