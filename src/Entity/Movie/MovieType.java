package Entity.Movie;
/**
* MovieType is an entity representing the different categories of movie types
*/
public enum MovieType {
    Blockbuster("Blockbuster"),
    ThreeD("3-D"),
    Common("Common");

    private final String text;

    /**
    * A constructor for the MovieType class
    * 
    * @param text Determines the type of the movie
    */
    private MovieType(String text) {
        this.text = text;
    }

    /**
    * A method that returns the type of the movie as a string
    * 
    * @return String This returns the type of the movie as a string
    */
    public String toString() {
        return this.text;
    }
}
