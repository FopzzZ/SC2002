package Entity.Movie;

public enum movieType {
    Blockbuster("Blockebuster"), 
    threeD("3-D"), 
    common("Common");
    private final String text;

    private movieType(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
