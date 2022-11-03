package Entity.Movie;

public enum MovieType {
    Blockbuster("Blockebuster"),
    threeD("3-D"),
    common("Common");

    private final String text;

    private MovieType(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
