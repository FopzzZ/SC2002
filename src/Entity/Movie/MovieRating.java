package Entity.Movie;
/**
* MovieRating is an entity representing the different categories of movie ratings.
*/

public enum MovieRating {
    G("General"),
    PG("Parental Guidance"),
    PG13("Parental Guidance 13"),
    NC16("No Children Under 16"),
    M18("Mature 18"),
    R21("Restricted 21");

    private final String text;

    /**
    * A constructor for the MovieRating class
    * 
    * @param text Determines the rating of the movie
    */
    private MovieRating(String text) {
        this.text = text;
    }

    /**
    * A method that returns the rating of the movie as a string
    * 
    * @return String This returns the rating of the movie as a string
    */
    public String toString() {
        return this.text;
    }
}

