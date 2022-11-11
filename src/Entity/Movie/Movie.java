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

    
    /** 
     * A method to get the average score for a given movie from all reveiws as a double
     * 
     * @return double Returns the average score given by all reviews
     */
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

    
    /** 
     * A method to get the average score for a given movie from all reviews as a string
     * 
     * @return String Returns the average score given by all reviews
     */
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

    
    /** 
     * A method that takes in an arraylist of showtimes and assigns it to a movie
     * 
     * @param showtimes Determines the showtimes assigned to a movie in the form of an arraylist
     */
    public void updateShowtime(ArrayList<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    
    /** 
     * A method to get the menu to update movie details
     * 
     * @return boolean Returns false if an error ocurred and movie details were not updated
     */
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

    
    /** 
     * A method that takes in a string and sets it as the title of the movie
     * 
     * @param movieTitle Determines the title of the movie
     */
    public void setTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    
    /** 
     * A method that takes in a MovieType and sets it as the type of the movie
     * 
     * @param type Determines the type of the movie
     */
    public void setType(MovieType type) {
        this.type = type;
    }

    
    /** 
     * A method that takes in a MovieStatus and sets it as the status of the movie
     * 
     * @param status Determines the status of the movie
     */
    public void setStatus(MovieStatus status) {
        this.status = status;
    }

    
    /** 
     * A method that takes in a MovieRating and sets it as the rating of the movie
     * 
     * @param rating Determines the rating of the movie
     */
    public void setRating(MovieRating rating) {
        this.rating = rating;
    }

    
    /** 
     * A method that takes in a string and sets it as the synopsis of a movie
     * 
     * @param synopsis Determines the synopsis of the movie
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    
    /** 
     * A method that takes in a string and sets it as the director of the movie
     * 
     * @param director Determines the director of the movie
     */
    public void setDirector(String director) {
        this.director = director;
    }

    
    /** 
     * A method that takes in a string and adds it to the cast list of the movie
     * 
     * @param cast Determines the cast to be added to the cast list of the movie
     */
    public void addCast(String cast) {
        this.cast.add(cast);
    }

    
    /** 
     * A method that takes in a double, ticket price, and adds it to the ticket sales of the movie
     * 
     * @param ticketPrice Determines the amount to be added to the ticket sales of the movie
     */
    public void addTicketSales(double ticketPrice) {
        this.ticketSales += ticketPrice;
    }

    
    /** 
     * A method that takes in a double and string, saves it to a review and adds it to the list of reviews of the movie and updates the average score of the movie
     * 
     * @param rating Determines the score associated with the review of the movie
     * @param content Determines the content of the review of the movie
     */
    public void addReview(double rating, String content) {
        this.reviews.add(new Review(rating, content));
        this.reviewScore = getAverageReviewScore();
    }

    
    /** 
     * A method that takes in a showtime and adds it to the current list of showtimes of the movie
     * 
     * @param showtime Determines the showtime to be added to the movie
     */
    public void addShowtime(Showtime showtime) {
        this.showtimes.add(showtime);
    }

    
    /** 
     * A method that returns the title of the movie as a string
     * 
     * @return String This returns the title of the movie as a string
     */
    public String getTitle() {
        return this.movieTitle;
    }

    
    /** 
     * A method that returns the status of the movie as a MovieStatus
     * 
     * @return MovieStatus This returns the status of the movie as a MovieStatus
     */
    public MovieStatus getStatus() {
        return this.status;
    }

    
    /** 
     * A method that returns the synopsis of the movie as a string
     * 
     * @return String This returns the synopsis of the movie as a string
     */
    public String getSynopsis() {
        return this.synopsis;
    }

    
    /** 
     * A method that returns the director of the movie as a string
     * 
     * @return String This returns the director of the movie as a string
     */
    public String getDirector() {
        return this.director;
    }

    
    /** 
     * A method that returns the cast of the movie as an arraylist
     * 
     * @return ArrayList<String> This returns the cast of the movie as an arraylist
     */
    public ArrayList<String> getCast() {
        return this.cast;
    }

    
    /** 
     * A method that returns the reviews of the movie as an arraylist
     * 
     * @return ArrayList<Review> This returns the reviews of the movie as an arraylist
     */
    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    
    /** 
     * A method that returns the showtimes of the movie as an arraylist
     * 
     * @return ArrayList<Showtime> This returns the showtimes of the movie as an arraylist
     */
    public ArrayList<Showtime> getShowtimes() {
        return this.showtimes;
    }

    
    /** 
     * A method that returns the type of the movie as a MovieType
     * 
     * @return MovieType This returns the type of the movie as a MovieType
     */
    public MovieType getType() {
        return this.type;
    }

    
    /** 
     * A method that returns the rating of the movie as a MovieRating
     * 
     * @return MovieRating This returns the rating of the movie as a MovieRating
     */
    public MovieRating getRating() {
        return this.rating;
    }

    
    /** 
     * A method that returns the review score of the movie as a double
     * 
     * @return double This returns the review score of the movie as a double
     */
    public double getReviewScore() {
        return this.reviewScore;
    }

    
    /** 
     * A method that returns the total value of the tickets sold for the movie as a double
     * 
     * @return double This returns the total value of the tickets sold for the movie as a double
     */
    public double getTicketSales() {
        return this.ticketSales;
    }

    
    /** 
     * A method that returns 
     * 
     * @return String
     */
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
