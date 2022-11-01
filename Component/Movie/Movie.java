package SC2002.Component.Movie;

import java.io.*;

public class Movie implements Serializable{
    private String movieTitle, synopsis, director;
    movieType type;
    movieStatu statu;
    int numOfCasts, numOfReviews;
    private String[] cast;
    private Review[] reviews;
    double overallRating;
    double sumOfRating;
    public Movie() {
        initComponents();
    }
    
    private void initComponents() {
        numOfCasts = 0;
        movieTitle = "";
        statu = movieStatu.Coming;
        type = movieType.common;
        synopsis = "";
        director = "";
        numOfReviews = 0;
        cast = new String[100];
        reviews = new Review[500];
    }
    //showDetail used to show all elemnts of the movie to user.
    public void showDetail() {
        System.out.printf("Movie Title: %s\nStatu: %s\nSynopsis: %s\n", this.getTitle(), this.getStatu(), this.getSynopsis());
        System.out.print("Type of movie: "); 
        System.out.println(this.type);
        System.out.printf("\nDirector: %s\n", this.getDirector());

        System.out.print("Cast: ");
        for(int i = 0; i < numOfCasts; i++) 
            System.out.printf("%s ", this.cast[i]); 
        System.out.printf("\nOverall Rating: ");
        if(numOfReviews > 1 ) {
            System.out.printf("%.1f\n", overallRating);
        } else System.out.println("NA");

        for(int i = 0; i < numOfReviews; i++) {
            System.out.printf("Reviews%3d:\n", i + 1);
            System.out.printf("Rating: %.1f\nContent: %s\n",this.reviews[i].rating, this.reviews[i].content); 
        }
        System.out.println("");
    }

    public void setTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setType(movieType type) {
        this.type = type;
    }

    public void setStatu(movieStatu statu) {
        this.statu = statu;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void addCast(String cast) {
        this.cast[numOfCasts++] = cast;
    }

    public void addReview(double rating, String content) {
        if(numOfReviews >= 500) return;
        this.reviews[numOfReviews++] = new Review(rating, content);
        sumOfRating += rating;
        overallRating = sumOfRating / numOfReviews;
    }

    public String getTitle() {
        return this.movieTitle;
    }

    public movieStatu getStatu() {
        return this.statu;
    }

    public String getSynopsis() {
        return this.synopsis;
    }

    public String getDirector() {
        return this.director;
    }

    public String[] getCast() {
        return this.cast;
    }

    public Review[] getReviews() {
        return this.reviews;
    }
    
    public movieType getType() {
        return this.type;
    }
    // Just for unit test
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Movie movie1 = new Movie();
        movie1.setTitle("SpiderMan");
        movie1.setStatu(movieStatu.Showing);
        movie1.setSynopsis("Spider man 1");
        movie1.setDirector("IDK");
        movie1.addCast("CastA");
        movie1.addCast("CastB");
        movie1.addReview(5, "Nice movie.");
        movie1.addReview(2.0, "Not good.");
        movie1.setType(movieType.threeD);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.txt"));
        oos.writeObject(movie1);
        oos.writeObject(movie1);
        oos.close();
        Movie movie2 = new Movie();
        Movie movie3 = new Movie();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc.txt"));
        movie2 = (Movie) ois.readObject();
        movie3 = (Movie) ois.readObject();
        movie2.showDetail();

        movie3.showDetail();
        ois.close();
    }
}
