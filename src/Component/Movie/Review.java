package src.Component.Movie;

import java.io.Serializable;

public class Review implements Serializable{
    double rating;
    String content;
    public Review(double rating, String content) {
        this.rating = rating;
        this.content = content;
    } 
}
