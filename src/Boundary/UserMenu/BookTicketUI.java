package Boundary.UserMenu;

import Controller.BookingController;
import Controller.CineplexController;
import Controller.InputController;
import Controller.MovieController;
import Controller.ShowtimeController;
import Controller.UserController;
import Entity.Booking;
import Entity.Ticket;
import Entity.Cineplex.Cineplex;
import Entity.Movie.Movie;
import Entity.Showtime.Showtime;

/**
* BookTicketUI is an entity containing the user interface for a user to book a ticket
*/
public class BookTicketUI {
    private String userEmail;

    public BookTicketUI(String userEmail) {
        this.userEmail = userEmail;
    }

    public void main() { // very similar to checkSeatAvailabilityUI
        CineplexController cineplexController = new CineplexController();
        MovieController movieController = new MovieController();
        cineplexController.listCineplex();
        System.out.print("Select cineplex: ");
        int cineplexChoice = InputController.getIntFromUser();
        Cineplex selectedCineplex = cineplexController.getCineplexList().get(cineplexChoice - 1);
        movieController.listMovies();
        System.out.print("Select movie: ");
        int movieChoice = InputController.getIntFromUser();
        System.out.println();
        Movie selectedMovie = movieController.getMovie(movieChoice - 1);
        ShowtimeController showtimeController = new ShowtimeController(selectedMovie);
        showtimeController.showAllFilteredShowtimesByCineplex(selectedCineplex);
        if (showtimeController.getFilteredShowtimeList().size() == 0) {
            System.out.println("No available showtimes");
            return;
        }
        System.out.print("Select showtime:");
        Showtime selectedShowtime = showtimeController.getFilteredShowtimeList()
                .get(InputController.getIntFromUser() - 1);
        selectedShowtime.getSeatplan().showSeatplan();
        System.out.print("Select row number: ");
        int rowNumber = InputController.getIntFromUser(1, 9);
        System.out.print("Select column letter: ");
        int colNumber = (int) InputController.getCapitalLetterFromUser() - 64;
        while (selectedShowtime.getSeatplan().occupy(rowNumber, colNumber) == false) {
            System.out.println("Seat is already occupied. Please select another seat");
            selectedShowtime.getSeatplan().showSeatplan();
            System.out.print("Select row number: ");
            rowNumber = InputController.getIntFromUser(1, 9);
            System.out.print("Select column letter: ");
            colNumber = (int) InputController.getCapitalLetterFromUser() - 64;
        }
        BookingController bookingController = new BookingController();
        UserController userController = new UserController();
        double ticketPrice = bookingController.getTicketPrice(selectedMovie, selectedShowtime,
                userController.getUser(userEmail));

        System.out.println("Ticket price is $" + ticketPrice);
        System.out.println("Confirm booking? (Y/N)");
        if (InputController.getYesOrNoFromUser()) {
            selectedMovie.addTicketSales(ticketPrice);
            movieController.addTickectSales(selectedMovie.getTitle(), ticketPrice);
            showtimeController.updateSeatingPlan(selectedShowtime);
            selectedShowtime.getSeatplan().showSeatplan();
            Ticket ticket = new Ticket(ticketPrice, selectedShowtime);
            String transactionID = bookingController.getTransactionID(selectedShowtime);
            Booking booking = new Booking(ticket, userEmail, transactionID);
            userController.addBookingToHistory(booking, userEmail);
        } else {
            return;
        }

    }
}
