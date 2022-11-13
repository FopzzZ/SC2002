package Entity.Movie;
/**
* MovieStatus is an entity representing the different categories of movie statuses.
*/
public enum MovieStatus {
    Coming("Coming Soon"),
    Preview("Preview"),
    Showing("Now Showing");

    private final String text;

    /**
    * A constructor for the MovieStatus class
    * 
    * @param text Determines the status of the movie
    */
    private MovieStatus(String text) {
        this.text = text;
    }

    /**
    * A method that returns the status of the movie as a string
    * 
    * @return String This returns the status of the movie as a string
    */
    public String toString() {
        return this.text;
    }
}
