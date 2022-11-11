import java.util.ArrayList;

import Controller.AdminController;
import Controller.BookingController;
import Controller.CineplexController;
import Controller.MovieController;
import Controller.ShowtimeController;
import Controller.UserController;
import Entity.Cinema.Cinema;
import Entity.Cineplex.Cineplex;
import Entity.Movie.Movie;
import Entity.Movie.MovieRating;
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
                adminController.create("bobby", "bobby1");
                adminController.create("john", "john1");

                // initialise cineplex list

                CineplexController cineplexController = new CineplexController();
                cineplexController.clearDatabase();
                cineplexController.addNewCineplex("Bishan");
                cineplexController.addNewCineplex("Jurong");
                cineplexController.addNewCineplex("Orchard");

                // initialise movies list
                MovieController movieController = new MovieController();
                movieController.clearDatabase();

                // first movie
                ArrayList<String> cast1 = new ArrayList<String>();
                cast1.add("Christian Bale");
                cast1.add("Cillian Murphy");
                cast1.add("Katie Holmes");
                cast1.add("Michael Caine");
                cast1.add("Liam Neeson");
                cast1.add("Morgan Freeman");
                cast1.add("Gary Oldman");
                movieController.createNewMovie("Batman Begins", MovieStatus.Showing,
                                "After witnessing his parents' death, Bruce learns the art of fighting to confront injustice. When he returns to Gotham as Batman, he must stop a secret society that intends to destroy the city.",
                                MovieType.Common,
                                MovieRating.PG13, "Christopher Nolan", cast1);

                // second movie
                ArrayList<String> cast2 = new ArrayList<String>();
                cast2.add("Leonardo DiCaprio");
                cast2.add("Joseph Gordon-Levitt");
                cast2.add("Tom Hardy");
                cast2.add("Cillian Murphy");
                cast2.add("Elliot Page");
                cast2.add("Marion Cotillard");
                cast2.add("Ken Watanabe");
                movieController.createNewMovie("Inception", MovieStatus.Showing,
                                "Cobb steals information from his targets by entering their dreams. Saito offers to wipe clean Cobb's criminal history as payment for performing an inception on his sick competitor's son.",
                                MovieType.Common,
                                MovieRating.PG13, "Christopher Nolan", cast2);

                // third movie
                ArrayList<String> cast3 = new ArrayList<String>();
                cast3.add("Owen Wilson");
                cast3.add("Paul Newman");
                cast3.add("Larry the Cable Guy");
                cast3.add("Bonnie Hunt");
                cast3.add("Tony Shalhoub");
                cast3.add("John Ratzenberger");
                cast3.add("Joe Ranft");
                cast3.add("George Carlin");
                movieController.createNewMovie("Cars", MovieStatus.Showing,
                                "Lightning McQueen, a racing car, learns a hard lesson in life when he damages a lot of property in Radiator Springs. His task is to repair the damage done before he can get back on the road.",
                                MovieType.Common,
                                MovieRating.G, "John Lasseter", cast3);

                // initialise showtimes
                addShowtime(0, 0, 0, "202212131600", "202212131800", false);
                addShowtime(0, 1, 1, "202211121600", "202211121800", false);
                addShowtime(0, 2, 2, "202212111600", "202212111800", false);

                addShowtime(1, 0, 0, "202211111600", "202211111800", false);
                addShowtime(1, 1, 1, "202211121600", "202211121800", false);
                addShowtime(1, 2, 2, "202212111600", "202212111800", false);

                addShowtime(2, 0, 0, "202211111600", "202211111800", false);
                addShowtime(2, 1, 1, "202211121600", "202211121800", false);
                addShowtime(2, 2, 2, "202212111600", "202212111800", false);

                // initialise surcharges and discounts
                BookingController bookingController = new BookingController();
                bookingController.clearDatabase();
                bookingController.setSurcharges(2, 4, 5,
                                2, 3, 5,
                                5, 2, 3, 8);
        }

        public static void addShowtime(int movieIndex, int cineplexIndex, int cinemaIndex, String start, String end,
                        boolean isHoliday) {
                MovieController movieController = new MovieController();
                CineplexController cineplexController = new CineplexController();
                Movie movie = movieController.getMovie(movieIndex);
                Time startTime = new Time(start);
                Time endTime = new Time(end);
                ShowtimeController showtimeController = new ShowtimeController(movie);

                Cineplex selectedCineplex = cineplexController.getCineplexList().get(cineplexIndex);
                Cinema selectedCinema = cineplexController.getCinemaList(selectedCineplex).get(cinemaIndex);
                showtimeController.create(movie, startTime, endTime, selectedCineplex, selectedCinema, isHoliday);

        }
}
