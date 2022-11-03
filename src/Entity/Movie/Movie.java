package Entity.Movie;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Controller.InputController;

public class Movie implements Serializable {
    private String movieTitle, synopsis, director;
    private MovieType type;
    private MovieStatus status;
    private String rating;
    private ArrayList<String> cast;
    private ArrayList<Review> reviews;

    public Movie() {
        initComponents();
    }

    private void initComponents() {
        movieTitle = "";
        status = MovieStatus.Coming;
        type = MovieType.common;
        synopsis = "";
        rating = "normal";
        director = "";
        cast = new ArrayList<String>();
        reviews = new ArrayList<Review>();
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

    public boolean updateDetail() {
        System.out.println("Enter the attribute you want to edit");
        System.out.println("1: Title");
        System.out.println("2: Statu(Coming Soon/Preview/Now Showing/End of Showing)");
        System.out.println("3: Type(Blockbuster/3D)");
        System.out.println("4: Director");
        System.out.println("5: Synopsis");
        System.out.println("6: Add Cast");
        String input = InputController.getStringFromUser();
        System.out.println("Enter the value: ");
        String content = InputController.getStringFromUser();
        switch (input) {
            case "1":
                this.setTitle(content);
                break;
            case "2":
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
            case "3":
                switch (content) {
                    case "Blockbuster":
                        this.setType(MovieType.Blockbuster);
                        break;
                    case "3D":
                        this.setType(MovieType.threeD);
                        break;
                    default:
                        break;
                }
                break;
            case "4":
                this.setDirector(content);
                break;
            case "5":
                this.setSynopsis(content);
                break;
            case "6":
                this.addCast(content);
                break;
            default:
                System.out.println("Invalid input.");
                break;
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
        for (int i = 0; i < this.getReviews().size(); ++i) {
            reviewS += "\n\n" + this.getReviews().get(i).getContent();
        }
        if (this.getReviews().size() == 0) {
            reviewS = "N/A";
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
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Movie movie1 = new Movie();
        movie1.setTitle("SpiderMan");
        movie1.setStatus(MovieStatus.Showing);
        movie1.setSynopsis("Spider man 1");
        movie1.setDirector("IDK");
        movie1.addCast("CastA");
        movie1.addCast("CastB");
        movie1.addReview(5, "Nice movie.");
        movie1.addReview(2.0, "Not good.");
        movie1.setType(MovieType.threeD);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("database/abc.txt"));
        oos.writeObject(movie1);
        oos.writeObject(movie1);
        oos.close();
        Movie movie2 = new Movie();
        Movie movie3 = new Movie();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("database/abc.txt"));
        movie2 = (Movie) ois.readObject();
        movie3 = (Movie) ois.readObject();
        System.out.println(movie2.toString());
        System.out.println(movie3.toString());
        ois.close();
    }
}
