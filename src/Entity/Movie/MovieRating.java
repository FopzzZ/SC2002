/**
Represents the different categories of movie ratings.
*/


package Entity.Movie;

public enum MovieRating {
    G("General"),
    PG("Parental Guidance"),
    PG13("Parental Guidance 13"),
    NC16("No Children Under 16"),
    M18("Mature 18"),
    R21("Restricted 21");

    private final String text;

    private MovieRating(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
