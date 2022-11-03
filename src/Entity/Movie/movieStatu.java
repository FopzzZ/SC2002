package Entity.Movie;

public enum movieStatu {
    Coming("Coming Soon"), 
    Preview("Preview"), 
    Showing("Showing"),
    Ended("End of showing");
    private final String text;

    private movieStatu(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
