package Entity.Movie;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Controller.InputController;
import Entity.Showtime.Showtime;

public class Movie implements Serializable {
    private String movieTitle, synopsis, director;
    private MovieType type;
    private MovieStatus status;
    private MovieRating rating;
    private ArrayList<String> cast;
    private ArrayList<Review> reviews;
    private double reviewScore;
    private ArrayList<Showtime> showtimes;
    private double ticketSales;

    public Movie() {
        this.movieTitle = "";
        this.status = MovieStatus.Coming;
        this.type = MovieType.Common;
        this.rating = MovieRating.G;
        this.synopsis = "";
        this.reviewScore = 0;
        this.director = "";
        this.cast = new ArrayList<String>();
        this.reviews = new ArrayList<Review>();
        this.showtimes = new ArrayList<Showtime>();
        this.ticketSales = 0;
    }

    public Movie(String movieTitle, String synposis, String director, MovieType type, MovieStatus status,
            MovieRating rating,
            ArrayList<String> cast, ArrayList<Review> review) {
        this.movieTitle = movieTitle;
        this.status = status;
        this.type = type;
        this.rating = rating;
        this.synopsis = synposis;
        this.director = director;
        this.cast = cast;
        this.reviews = review;
        this.showtimes = new ArrayList<Showtime>();
        this.reviewScore = 0;
        this.ticketSales = 0;
    }

    public double getAverageReviewScore() { // returns average review score
        double sum = 0;
        if (reviews.size() > 0) {
            for (Review review : reviews) {
                sum += review.getRating();
            }
            sum /= reviews.size();
        }

        return sum;
    }

    public String getOverallReviewsRatingToString() {
        double sum = 0;
        if (reviews.size() > 1) {
            for (Review review : reviews) {
                sum += review.getRating();
            }
            DecimalFormat df = new DecimalFormat("#.##");
            return df.format(sum / reviews.size());
        } else {
            return "N/A";
        }
    }

    public void updateShowtime(ArrayList<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public boolean updateDetail() { // move to movieController/adminMenuUI
        int input = 0;
        String content;
        int index = 0;
        while (input != 7) {
            System.out.println("1: Title");
            System.out.println("2: Status (Coming Soon/Preview/Now Showing/End of Showing)");
            System.out.println("3: Type (Blockbuster/3D/Common)");
            System.out.println("4: Rating (G/PG/PG13/NC16/M18/R21)");
            System.out.println("5: Director");
            System.out.println("6: Synopsis");
            System.out.println("7: Add Cast");
            System.out.println("8: Exit");
            System.out.println("Select attribute to edit");
            input = InputController.getIntFromUser(1, 8);

            switch (input) {
                case 1:
                    System.out.println("Enter movie title: ");
                    content = InputController.getStringFromUser();
                    this.setTitle(content);
                    break;
                case 2:
                    System.out.println(
                            "Enter movie status (1. Coming Soon / 2. Preview / 3. Now Showing / 4. End of Showing): ");
                    index = InputController.getIntFromUser(1, 4);
                    switch (index) {
                        case 1:
                            this.setStatus(MovieStatus.Coming);
                            break;
                        case 2:
                            this.setStatus(MovieStatus.Preview);
                            break;
                        case 3:
                            this.setStatus(MovieStatus.Showing);
                            break;
                        case 4:
                            return true;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Enter movie type (1. Blockbuster / 2. Three-D / 3. Common): ");
                    index = InputController.getIntFromUser(1, 3);
                    switch (index) {
                        case 1:
                            this.setType(MovieType.Blockbuster);
                            break;
                        case 2:
                            this.setType(MovieType.ThreeD);
                            break;
                        case 3:
                            this.setType(MovieType.Common);
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Enter movie rating (1. G / 2. PG / 3. PG13 / 4. NC16 / 5. M18 / 6. R21): ");
                    index = InputController.getIntFromUser(1, 6);
                    switch (index) {
                        case 1:
                            this.setRating(MovieRating.G);
                            break;
                        case 2:
                            this.setRating(MovieRating.PG);
                            break;
                        case 3:
                            this.setRating(MovieRating.PG13);
                            break;
                        case 4:
                            this.setRating(MovieRating.NC16);
                            break;
                        case 5:
                            this.setRating(MovieRating.M18);
                            break;
                        case 6:
                            this.setRating(MovieRating.R21);
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Enter director's name: ");
                    content = InputController.getStringFromUser();
                    this.setDirector(content);
                    break;
                case 6:
                    System.out.println("Enter synopsis: ");
                    content = InputController.getStringFromUser();
                    this.setSynopsis(content);
                    break;
                case 7:
                    int cont = 0;
                    while (cont == 0) {
                        System.out.println("Enter name of cast member (Enter 'Done' to stop): ");
                        content = InputController.getStringFromUser();
                        if (content.equals("Done")) {
                            cont = 1;
                        } else {
                            this.addCast(content);
                        }
                    }
                    break;
                case 8:
                    break;
            }
        }

        return false;
    }

    public void setTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setType(MovieType type) {
        this.type = type;
    }

    public void setStatus(MovieStatus status) {
        this.status = status;
    }

    public void setRating(MovieRating rating) {
        this.rating = rating;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void addCast(String cast) {
        this.cast.add(cast);
    }

    public void addTicketSales(double ticketPrice) {
        this.ticketSales += ticketPrice;
    }

    public void addReview(double rating, String content) {
        this.reviews.add(new Review(rating, content));
        this.reviewScore = getAverageReviewScore();
    }

    public void addShowtime(Showtime showtime) {
        this.showtimes.add(showtime);
    }

    public String getTitle() {
        return this.movieTitle;
    }

    public MovieStatus getStatus() {
        return this.status;
    }

    public String getSynopsis() {
        return this.synopsis;
    }

    public String getDirector() {
        return this.director;
    }

    public ArrayList<String> getCast() {
        return this.cast;
    }

    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    public ArrayList<Showtime> getShowtimes() {
        return this.showtimes;
    }

    public MovieType getType() {
        return this.type;
    }

    public MovieRating getRating() {
        return this.rating;
    }

    public double getReviewScore() {
        return this.reviewScore;
    }

    public double getTicketSales() {
        return this.ticketSales;
    }

    public String toString() {
        String castS = new String();
        for (int i = 0; i < this.getCast().size(); ++i) {
            if (i != 0)
                castS += ", ";
            castS += this.getCast().get(i);
        }

        String reviewS = new String();

        if (this.getReviews().size() == 0) {
            reviewS = "N/A";
        } else {
            for (int i = 0; i < this.getReviews().size(); ++i) {
                reviewS += "\n\n" + (i + 1) + ". (" + this.getReviews().get(i).getRating() + ") - "
                        + this.getReviews().get(i).getContent();
            }
        }

        String ret = new String();
        ret += "Movie Title: " + this.getTitle() + "\n"
                + "Status: " + this.getStatus() + "\n"
                + "Synposis: " + this.getSynopsis() + "\n"
                + "Rating: " + this.getRating() + "\n"
                + "Type of movie: " + this.getType() + "\n"
                + "Director: " + this.getDirector() + "\n"
                + "Cast: " + castS + "\n"
                + "Overall score: " + this.getReviewScore() + "\n"
                + "Reviews: " + reviewS + "\n";

        return ret;
    }

    // unit test
    // public static void main(String[] args) throws FileNotFoundException,
    // IOException, ClassNotFoundException {
    // Movie movie1 = new Movie();
    // movie1.setTitle("SpiderMan 1");
    // movie1.setStatus(MovieStatus.Showing);
    // movie1.setSynopsis("Spider man 1");
    // movie1.setDirector("IDK");
    // movie1.addCast("CastA");
    // movie1.addCast("CastB");
    // movie1.addReview(5, "Nice movie.");
    // movie1.addReview(2.0, "Not good.");
    // movie1.setType(MovieType.ThreeD);

    // Movie movie2 = new Movie();
    // movie2.setTitle("SpiderMan 2");
    // movie2.setStatus(MovieStatus.Showing);
    // movie2.setSynopsis("Spider man 2");
    // movie2.setDirector("IDK");
    // movie2.addCast("CastA");
    // movie2.addCast("CastB");
    // movie2.addReview(5, "Nice movie.");
    // movie2.addReview(2.0, "Good.");
    // movie2.setType(MovieType.ThreeD);

    // ArrayList<Movie> movieList = new ArrayList<Movie>();
    // movieList.add(movie2);
    // // movieList.add(movie1);
    // ObjectOutputStream oos = new ObjectOutputStream(new
    // FileOutputStream("database/abc.txt"));
    // oos.writeObject(movieList);
    // oos.close();

    // ObjectInputStream ois = new ObjectInputStream(new
    // FileInputStream("database/abc.txt"));
    // ArrayList<Movie> movies = (ArrayList<Movie>) ois.readObject();

    // for (Movie m : movies) {
    // System.out.println(m.toString());
    // }
    // ois.close();
    // }
}
