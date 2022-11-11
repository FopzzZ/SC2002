package Boundary.AdminMenu;

import Controller.CineplexController;
import Controller.InputController;
import Controller.MovieController;
import Controller.ShowtimeController;
import Entity.Cinema.Cinema;
import Entity.Cineplex.Cineplex;
import Entity.Movie.Movie;
import Entity.Showtime.Showtime;
import Entity.Showtime.Time;

public class ModifyShowtimeMenuUI {
    private MovieController movieController;
    private ShowtimeController showtimeController;
    private CineplexController cineplexController;
    private Movie selectedMovie;

    public static void main(String[] args) { // for testing
        ModifyShowtimeMenuUI modifyShowtimeMenuUI = new ModifyShowtimeMenuUI();
        modifyShowtimeMenuUI.main();
    }

    public void main() {
        cineplexController = new CineplexController();
        movieController = new MovieController();
        movieController.listMovies();
        System.out.print("\nSelect movie to modify showtimes: ");
        selectedMovie = movieController
                .getMovie(InputController.getIntFromUser(1, movieController.getlistMovies().size()) - 1);
        showtimeController = new ShowtimeController(selectedMovie);
        while (true) {
            System.out.println("\n" +
                    "--------------------\n" +
                    "| Modify Showtimes |\n" +
                    "--------------------\n" +
                    "1. List all showtimes\n" +
                    "2. Create showtime\n" +
                    "3. Update showtime\n" +
                    "4. Remove showtime\n" +
                    "5. Back to main menu");
            System.out.print("\nSelect action: ");
            switch (InputController.getIntFromUser(1, 5)) {
                case 1:
                    showtimeController.showAllShowtimes();
                    break;
                case 2:
                    createMovieShowtime();
                    break;
                case 3:
                    updateMovieShowtime();
                    break;
                case 4:
                    removeMovieShowtime();
                    break;
                case 5:
                    return;
            }
        }

    }

    private void createMovieShowtime() {
        System.out.print("\nEnter start time in the format YYYYMMddHHmm: ");
        Time startTime = new Time(InputController.getTimeFromUser());
        System.out.print("\nEnter end time in the format YYYYMMddHHmm: ");
        Time endTime = new Time(InputController.getTimeFromUser());
        cineplexController.listCineplex();
        System.out.print("\nSelect cineplex: ");
        Cineplex selectedCineplex = cineplexController.getCineplexList().get(InputController.getIntFromUser() - 1);
        System.out.println("\n" +
                "-----------\n" +
                "| Cinemas |\n" +
                "-----------");
        cineplexController.listCinemas(selectedCineplex);
        System.out.print("\nSelect cinema: ");
        Cinema selectedCinema = cineplexController.getCinemaList(selectedCineplex)
                .get(InputController.getIntFromUser() - 1);
        System.out.print("\nIs this on a holiday? (Y/N): ");
        boolean isHoliday = InputController.getYesOrNoFromUser();
        showtimeController.create(selectedMovie, startTime, endTime, selectedCineplex, selectedCinema, isHoliday);

    }

    private void updateMovieShowtime() {
        showtimeController.showAllShowtimes();
        System.out.print("\nSelect showtime to update: ");
        int selection = InputController.getIntFromUser();
        System.out.print("\nEnter start time in the format YYYYMMddHHmm: ");
        Time startTime = new Time(InputController.getTimeFromUser());
        System.out.print("\nEnter end time in the format YYYYMMddHHmm: ");
        Time endTime = new Time(InputController.getTimeFromUser());
        cineplexController.listCineplex();
        System.out.print("\nSelect cineplex: ");
        Cineplex selectedCineplex = cineplexController.getCineplexList().get(InputController.getIntFromUser() - 1);
        System.out.println("\n" +
                "-----------\n" +
                "| Cinemas |\n" +
                "-----------");
        cineplexController.listCinemas(selectedCineplex);
        System.out.print("\nSelect cinema: ");
        Cinema selectedCinema = cineplexController.getCinemaList(selectedCineplex)
                .get(InputController.getIntFromUser() - 1);
        System.out.print("\nIs this on a holiday? (Y/N): ");
        boolean isHoliday = InputController.getYesOrNoFromUser();
        Showtime newShowtime = new Showtime(startTime, endTime, selectedCineplex, selectedCinema, isHoliday);
        showtimeController.updateShowtime(selection - 1, newShowtime);

    }

    private void removeMovieShowtime() {
        showtimeController.showAllShowtimes();
        System.out.print("Select showtime to remove: ");
        int selection = InputController.getIntFromUser();
        showtimeController.removeShowtime(selection - 1);
    }

}
