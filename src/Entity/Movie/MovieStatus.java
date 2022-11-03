package Entity.Movie;

public enum MovieStatus {
    Coming("Coming Soon"),
    Preview("Preview"),
    Showing("Showing"),
    Ended("End of showing");

    private final String text;

    private MovieStatus(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
