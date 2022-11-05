package Boundary.AdminMenu;

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
    private Movie selectedMovie;

    public static void main(String[] args) { // for testing
        ModifyShowtimeMenuUI modifyShowtimeMenuUI = new ModifyShowtimeMenuUI();
        modifyShowtimeMenuUI.main();
    }

    public void main() {
        movieController = new MovieController();
        movieController.listMovies();
        System.out.println("Select movie to modify showtimes:");
        selectedMovie = movieController.getMovie(InputController.getIntFromUser() - 1);
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
                    "5. Back to main menu\n");
            System.out.println("Select action: ");
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
        System.out.println("Enter start time in the format YYYYMMDDHHMM:");
        Time startTime = new Time(InputController.getTimeFromUser());
        System.out.println("Enter end time in the format YYYYMMDDHHMM:");
        Time endTime = new Time(InputController.getTimeFromUser());
        // Select cineplex
        // Select cinema
        // isHoliday
        showtimeController.create(selectedMovie, startTime, endTime, new Cineplex(), new Cinema(), false);

    }

    private void updateMovieShowtime() {
        showtimeController.showAllShowtimes();
        System.out.println("Select showtime to update:");
        int selection = InputController.getIntFromUser();
        System.out.println("Enter start time in the format YYYYMMDDHHMM:");
        Time startTime = new Time(InputController.getTimeFromUser());
        System.out.println("Enter end time in the format YYYYMMDDHHMM:");
        Time endTime = new Time(InputController.getTimeFromUser());
        // Select cineplex
        // Select cinema
        // isHoliday
        Showtime newShowtime = new Showtime(startTime, endTime, null, null, false);
        showtimeController.updateShowtime(selection - 1, newShowtime);

    }

    private void removeMovieShowtime() {
        showtimeController.showAllShowtimes();
        System.out.println("Select showtime to remove:");
        int selection = InputController.getIntFromUser();
        showtimeController.removeShowtime(selection - 1);
    }

}
