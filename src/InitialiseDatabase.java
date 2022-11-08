import java.util.ArrayList;

import Controller.AdminController;
import Controller.CineplexController;
import Controller.MovieController;
import Controller.ShowtimeController;
import Controller.UserController;
import Entity.Cinema.Cinema;
import Entity.Cineplex.Cineplex;
import Entity.Movie.Movie;
import Entity.Movie.MovieStatus;
import Entity.Movie.MovieType;
import Entity.Showtime.Time;

//file for testing
public class InitialiseDatabase {
    public static void main(String[] args) {

        // initialise user list
        UserController userController = new UserController();
        userController.clearDatabase();
        userController.addUser("bob@gmail.com", "99128412", "Bob", "20/02/2000");
        userController.addUser("john@gmail.com", "96729103", "John", "26/03/1961");

        // initialise admin list
        AdminController adminController = new AdminController();
        adminController.clearDatabase();
        adminController.create("bobby1", "bobby");
        adminController.create("john1", "john");

        // initialise cineplex list

        CineplexController cineplexController = new CineplexController();
        cineplexController.clearDatabase();
        cineplexController.addNewCineplex("Bishan");
        cineplexController.addNewCineplex("Jurong");
        cineplexController.addNewCineplex("Orchard");

        // initialise movies list
        ArrayList<String> cast = new ArrayList<String>();
        cast.add("Cast1");
        cast.add("Cast2");
        MovieController movieController = new MovieController();
        movieController.clearDatabase();
        movieController.createNewMovie("John Cena", MovieStatus.Showing, "now u see me",
                "4", MovieType.Common,
                "dk", cast);
        movieController.createNewMovie("Nemo", MovieStatus.Showing, "now u see me",
                "4", MovieType.Common,
                "dk", cast);
        movieController.createNewMovie("Bob bones", MovieStatus.Showing, "now u see me",
                "4", MovieType.Common,
                "dk", cast);

        // initialise showtimes
        addShowtime("202207111600", "202207111800", false);
        addShowtime("202208111600", "202208111800", false);
        addShowtime("202209111600", "202209111800", false);
    }

    public static void addShowtime(String start, String end, boolean isHoliday) {
        MovieController movieController = new MovieController();
        CineplexController cineplexController = new CineplexController();
        ArrayList<Movie> movieList = movieController.getMovieList();
        Time startTime = new Time(start);
        Time endTime = new Time(end);
        for (Movie movie : movieList) {
            ShowtimeController showtimeController = new ShowtimeController(movie);
            for (int i = 0; i < cineplexController.getCineplexList().size(); i++) {
                Cineplex selectedCineplex = cineplexController.getCineplexList().get(i);
                for (int j = 0; j < cineplexController.getCinemaList(selectedCineplex).size(); j++) {
                    Cinema selectedCinema = cineplexController.getCinemaList(selectedCineplex).get(j);
                    showtimeController.create(movie, startTime, endTime, selectedCineplex, selectedCinema, isHoliday);
                }
            }
        }
    }
}
