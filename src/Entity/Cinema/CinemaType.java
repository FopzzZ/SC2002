package Entity.Cinema;

public enum CinemaType {
    GOLDCLASS("Gold Class"),
    PLATINUM("Platinum"),
    IMAX("IMax"),
    NORMAL("Normal");

    private final String text;

    private CinemaType(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
