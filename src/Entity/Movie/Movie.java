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
    private String rating;
    private ArrayList<String> cast;
    private ArrayList<Review> reviews;
    private ArrayList<Showtime> showtimes;

    public Movie() {
        this.movieTitle = "";
        this.status = MovieStatus.Coming;
        this.type = MovieType.Common;
        this.synopsis = "";
        this.rating = "normal";
        this.director = "";
        this.cast = new ArrayList<String>();
        this.reviews = new ArrayList<Review>();
        this.showtimes = new ArrayList<Showtime>();
    }

    public Movie(String movieTitle, String synposis, String director, MovieType type, MovieStatus status,
            String rating, ArrayList<String> cast, ArrayList<Review> review) {
        this.movieTitle = movieTitle;
        this.status = status;
        this.type = type;
        this.synopsis = synposis;
        this.rating = rating;
        this.director = director;
        this.cast = cast;
        this.reviews = review;
        this.showtimes = new ArrayList<Showtime>();
    }

    public String getOverallReviewsRating() {
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
        while (input != 7) {
            System.out.println("1: Title");
            System.out.println("2: Status(Coming Soon/Preview/Now Showing/End of Showing)");
            System.out.println("3: Type(Blockbuster/3D)");
            System.out.println("4: Director");
            System.out.println("5: Synopsis");
            System.out.println("6: Add Cast");
            System.out.println("7: Exit");
            System.out.println("Select attribute to edit");
            input = InputController.getIntFromUser(1, 7);

            switch (input) {
                case 1:
                    System.out.println("Enter movie title: ");
                    content = InputController.getStringFromUser();
                    this.setTitle(content);
                    break;
                case 2:
                    System.out.println("Enter movie status (Coming Soon/Preview/Now Showing/End of Showing): ");
                    content = InputController.getStringFromUser();
                    switch (content) {
                        case "Coming Soon":
                            this.setStatus(MovieStatus.Coming);
                            break;
                        case "Preview":
                            this.setStatus(MovieStatus.Preview);
                            break;
                        case "Now Showing":
                            this.setStatus(MovieStatus.Showing);
                            break;
                        case "End of Showing":
                            return true;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Enter movie type (Blockbuster/3D): ");
                    content = InputController.getStringFromUser();
                    switch (content) {
                        case "Blockbuster":
                            this.setType(MovieType.Blockbuster);
                            break;
                        case "3D":
                            this.setType(MovieType.ThreeD);
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Enter director's name: ");
                    content = InputController.getStringFromUser();
                    this.setDirector(content);
                    break;
                case 5:
                    System.out.println("Enter synopsis: ");
                    content = InputController.getStringFromUser();
                    this.setSynopsis(content);
                    break;
                case 6:
                    int cont = 0;
                    while(cont == 0) {
                        System.out.println("Enter name of cast member (Enter "Done" to stop): ");
                        content = InputController.getStringFromUser();
                        if(content.equals("Done")) {
                            cont = 1;
                        }
                        else {
                            this.addCast(content);
                        }
                    }
                    break;
                case 7:
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

    public void setRating(String rating) {
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

    public void addReview(double rating, String content) {
        this.reviews.add(new Review(rating, content));
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

    public String getRating() {
        return this.rating;
    }

    public String toString() {
        String castS = new String();
        for (int i = 0; i < this.getCast().size(); ++i) {
            if (i != 0)
                castS += ",";
            castS += this.getCast().get(i);
        }

        String reviewS = new String();

        if (this.getReviews().size() == 0) {
            reviewS = "N/A";
        } else {
            for (int i = 0; i < this.getReviews().size(); ++i) {
                reviewS += "\n\n" + this.getReviews().get(i).getContent();
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
                + "Overall rating: " + this.getOverallReviewsRating() + "\n"
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
