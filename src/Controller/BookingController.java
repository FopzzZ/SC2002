package Controller;

import Entity.Cinema.CinemaType;
import Entity.Movie.Movie;
import Entity.Movie.MovieType;
import Entity.Showtime.Showtime;
import Entity.User.AgeClass;
import Entity.User.User;

public class BookingController {
    public BookingController() {

    }

    // get ticket price based on type of movie,class of cinema, age, day of week or
    // public holiday
    public double getTicketPrice(Movie movie, Showtime showtime, User user) { // TODO add seat type
        double defaultPrice = 8.0; // for normal class cinema, common movie type, adult and weekday (Mon-Thur)
        // add price based on cinemaClass
        CinemaType cinemaClass = showtime.getCinema().getType();
        switch (cinemaClass) {
            case GOLDCLASS:
                defaultPrice += 2.0;
                break;
            case PLATINUM:
                defaultPrice += 4.0;
                break;
            case IMAX:
                defaultPrice += 5.0;
                break;
            case NORMAL:
                break;
        }
        // add price based on movieType
        MovieType movieType = movie.getType();
        switch (movieType) {
            case Blockbuster:
                defaultPrice += 2.0;
                break;
            case ThreeD:
                defaultPrice += 3.0;
                break;
            case Common:
                break;
        }
        // add price based on age
        AgeClass ageClass = getAgeClass(user, showtime);
        switch (ageClass) {
            case CHILD:
                defaultPrice -= 5;
                break;
            case SENIORCITIZEN:
                defaultPrice -= 5;
                break;
            case ADULT:
                break;
        }
        int dayOfWeek = showtime.getStartTime().getDayOfWeek();
        switch (dayOfWeek) {
            case 1, 2, 3:
                defaultPrice += 2.0;
                break;
            case 4, 5, 6, 7:
                break;
        }
        return defaultPrice;
    }

    private AgeClass getAgeClass(User user, Showtime showtime) { // TODO this is just a rough one
        int showtimeYear; // showtimeMonth, showtimeDay;
        showtimeYear = showtime.getStartTime().getYear();
        // showtimeMonth = showtime.getStartTime().getMonth();
        // showtimeDay = showtime.getStartTime().getDay();
        String dob = user.getDateOfBirth();
        int dobYear; // dobMonth, dobDay;
        // dobDay = Integer.parseInt(dob.substring(0, 2));
        // dobMonth = Integer.parseInt(dob.substring(2, 4));
        dobYear = Integer.parseInt(dob.substring(4, 8));
        int roughAge = showtimeYear - dobYear;
        if (roughAge > 65) {
            return AgeClass.SENIORCITIZEN;
        } else if (roughAge < 18) {
            return AgeClass.CHILD;
        } else {
            return AgeClass.ADULT;
        }

    }
}
