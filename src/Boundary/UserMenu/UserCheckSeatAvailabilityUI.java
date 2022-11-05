package Boundary.UserMenu;

import Controller.CineplexController;
import Controller.InputController;
import Controller.MovieController;
import Controller.ShowtimeController;
import Entity.Cineplex.Cineplex;
import Entity.Movie.Movie;
import Entity.Showtime.Showtime;

public class UserCheckSeatAvailabilityUI {
    public void main() {
        CineplexController cineplexController = new CineplexController();
        MovieController movieController = new MovieController();
        cineplexController.listCineplex();
        System.out.print("Select cineplex:");
        int cineplexChoice = InputController.getIntFromUser();
        Cineplex selectedCineplex = cineplexController.getCineplexList().get(cineplexChoice - 1);
        movieController.listMovies();
        System.out.print("Select movie:");
        int movieChoice = InputController.getIntFromUser();
        Movie selectedMovie = movieController.getMovie(movieChoice - 1);
        ShowtimeController showtimeController = new ShowtimeController(selectedMovie);
        showtimeController.showAllFilteredShowtimes(selectedCineplex);
        if (showtimeController.getFilteredShowtimeList().size() == 0) {
            System.out.println("No available showtimes");
            return;
        }
        System.out.print("Select showtime:");
        Showtime selectedShowtime = showtimeController.getFilteredShowtimeList()
                .get(InputController.getIntFromUser() - 1);
        selectedShowtime.getSeatplan().showSeatplan();
    }

}
