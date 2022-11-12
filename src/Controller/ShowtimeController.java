package Controller;

import java.util.ArrayList;

import Entity.Cinema.Cinema;
import Entity.Cineplex.Cineplex;
import Entity.Movie.Movie;
import Entity.Showtime.*;

/**
 * Controller to manage showtimes of a movie
 */
public class ShowtimeController {
    private Movie movie;
    private ArrayList<Showtime> showtimeList;
    private ArrayList<Showtime> filteredShowtimeList;
    private MovieController movieController;

    /**
     * Class constructor
     * 
     * @param movie movie to be managed
     */
    public ShowtimeController(Movie movie) {
        this.movie = movie;
        movieController = new MovieController();
        showtimeList = movie.getShowtimes();
    }

    /**
     * Creates a new showtime
     * 
     * @param movie     movie
     * @param startTime start time
     * @param endTime   end time
     * @param cineplex  cineplex
     * @param cinema    cinema
     * @param isHoliday whether it is a holiday
     */
    public void create(Movie movie, Time startTime, Time endTime, Cineplex cineplex, Cinema cinema, boolean isHoliday) {
        showtimeList.add(new Showtime(startTime, endTime, cineplex, cinema, isHoliday));
        sortShowtimesByStartTime();
        movieController.updateShowtime(movie, showtimeList);

    }

    /**
     * Prints all showtimes
     */
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

    /**
     * Print showtimes filterd by cineplex
     * 
     * @param cineplex cineplex to filter by
     */
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

    /**
     * Update a showtime
     * 
     * @param index    index of showtime to update
     * @param showtime updated showtime
     * @return boolean whether showtime is successfully updated
     */
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

    /**
     * Sort showtimes by start time
     */
    private void sortShowtimesByStartTime() {
        showtimeList.sort(null);
    }

    /**
     * Update seating plan
     * 
     * @param updatedShowtime showtime with updated seating plan
     */
    public void updateSeatingPlan(Showtime updatedShowtime) {
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

    /**
     * Remove a showtime
     * 
     * @param index index of showtime to be removed
     * @return boolean whether showtime is successfully removed
     */
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

    /**
     * Get list of showtimes
     * 
     * @return ArrayList<Showtime> current list of showtimes
     */
    public ArrayList<Showtime> getShowtimeList() {
        return this.showtimeList;
    }

    /**
     * Get filtered list of showtimes
     * 
     * @return ArrayList<Showtime> filtered list of showtimes
     */
    public ArrayList<Showtime> getFilteredShowtimeList() {
        return this.filteredShowtimeList;
    }

    /**
     * Checks if an index is valid
     * 
     * @param index index to check
     * @return boolean whether index is valid
     */
    public boolean validShowtimes(int index) {
        if (0 <= index & index < getShowtimeList().size()) {
            return true;
        }
        return false;
    }
}
