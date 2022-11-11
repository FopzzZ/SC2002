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
        sortShowtimesByStartTime();
        movieController.updateShowtime(movie, showtimeList);

    } // adds a showtime to movie

    public void showAllShowtimes() {
        System.out.println("\n" +
                "-------------\n" +
                "| Showtimes |\n" +
                "-------------");
        for (int i = 0; i < showtimeList.size(); ++i) {
            System.out.printf("Showtime %d: %s\n", i + 1, showtimeList.get(i).toString());
        }
        System.out.printf("Total %d showtimes\n\n", showtimeList.size());
    }

    public void showAllFilteredShowtimesByCineplex(Cineplex cineplex) {
        System.out.println("\n" +
                "-------------\n" +
                "| Showtimes |\n" +
                "-------------");
        filteredShowtimeList = new ArrayList<Showtime>();
        for (Showtime showtime : showtimeList) {
            if (showtime.getCineplex().getName().equals(cineplex.getName())) {
                filteredShowtimeList.add(showtime);
            }
        }
        for (int i = 0; i < filteredShowtimeList.size(); ++i) {
            System.out.printf("Showtime %d: %s\n", i + 1, filteredShowtimeList.get(i).toString());
        }
        System.out.printf("Total %d showtimes\n\n", filteredShowtimeList.size());
    }

    public boolean updateShowtime(int index, Showtime showtime) {
        if (0 <= index & index < getShowtimeList().size()) {
            showtimeList.get(index).update(showtime);
            // System.out.println("Editing: " +
            // showtimeList.get(index).getCinema().getName()); #checking
            sortShowtimesByStartTime();
            movieController.updateShowtime(movie, showtimeList);
            System.out.println("Success");
            return true;
        } else {
            System.out.println("No such show time");
            return false;
        }
    }

    private void sortShowtimesByStartTime() {
        showtimeList.sort(null);
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
            System.out.println("Error, showtime not found");
        }
        movieController.updateShowtime(movie, showtimeList);
    }

    public boolean removeShowtime(int index) {
        if (0 <= index & index < getShowtimeList().size()) {
            showtimeList.remove(index);
            movieController.updateShowtime(movie, showtimeList);
            System.out.println("Successfully removed!");
            return true;
        }
        System.out.println("Failed to remove!");
        return false;
    }

    public ArrayList<Showtime> getShowtimeList() {
        return this.showtimeList;
    }

    public ArrayList<Showtime> getFilteredShowtimeList() {
        return this.filteredShowtimeList;
    }

    public boolean validShowtimes(int index) {
        if (0 <= index & index < getShowtimeList().size()) {
            return true;
        }
        System.out.printf("Please enter a number from 1 to %d\n", getShowtimeList().size());
        return false;
    }
}
