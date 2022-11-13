package Entity.Movie;

import java.io.Serializable;
/**
* Review is an entity containing the score given to a movie and the contents of the review
*/
public class Review implements Serializable {
    private double rating;
    private String content;

    /**
    * A constructor for the Review class
    * 
    * @param rating Determines the rating of the review
    * @param content Determines the contents of the review
    */
    public Review(double rating, String content) {
        this.rating = rating;
        this.content = content;
    }

    
    /** 
     * A method to get the rating of the review as a double
     * 
     * @return double This returns the rating of the review as a double
     */
    public double getRating() {
        return this.rating;
    }
    
    
    /** 
     * A method to get the content of the review as a string
     * 
     * @return String this returns the content of the review as a string
     */
    public String getContent() {
        return this.content;
    }
}
