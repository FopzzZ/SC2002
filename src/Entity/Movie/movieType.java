package Entity.Movie;

public enum MovieType {
    Blockbuster("Blockbuster"),
    ThreeD("3-D"),
    Common("Common");

    private final String text;

    private MovieType(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
