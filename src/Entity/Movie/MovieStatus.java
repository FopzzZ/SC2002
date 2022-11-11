package Entity.Movie;

public enum MovieStatus {
    Coming("Coming Soon"),
    Preview("Preview"),
    Showing("Now Showing");

    private final String text;

    private MovieStatus(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
