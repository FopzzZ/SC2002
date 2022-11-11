package Boundary.UserMenu;

import Controller.CineplexController;
import Controller.InputController;
import Controller.MovieController;
import Controller.ShowtimeController;
import Entity.Cineplex.Cineplex;
import Entity.Movie.Movie;
import Entity.Showtime.Showtime;

public class CheckSeatAvailabilityUI {
    public void main() {
        CineplexController cineplexController = new CineplexController();
        MovieController movieController = new MovieController();
        cineplexController.listCineplex();
        System.out.print("\nSelect cineplex:");
        int cineplexChoice = InputController.getIntFromUser(1, cineplexController.getCineplexList().size());
        Cineplex selectedCineplex = cineplexController.getCineplexList().get(cineplexChoice - 1);
        movieController.listMovies();
        System.out.print("\nSelect movie:");
        int movieChoice = InputController.getIntFromUser(1, movieController.getlistMovies().size());
        Movie selectedMovie = movieController.getMovie(movieChoice - 1);
        ShowtimeController showtimeController = new ShowtimeController(selectedMovie);
        showtimeController.showAllFilteredShowtimesByCineplex(selectedCineplex);
        if (showtimeController.getFilteredShowtimeList().size() == 0) {
            System.out.println("No available showtimes");
            return;
        }
        System.out.print("Select showtime:");
        Showtime selectedShowtime = showtimeController.getFilteredShowtimeList()
                .get(InputController.getIntFromUser(1, showtimeController.getFilteredShowtimeList().size()) - 1);
        selectedShowtime.getSeatplan().showSeatplan();
    }

}
