package Entity.Movie;

import java.io.Serializable;

public class Review implements Serializable {
    private double rating;
    private String content;

    public Review(double rating, String content) {
        this.rating = rating;
        this.content = content;
    }

    public double getRating() {
        return this.rating;
    }
    
    public String getContent() {
        return this.content;
    }
}
