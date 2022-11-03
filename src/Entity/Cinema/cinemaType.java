package Entity.Cinema;

public enum CinemaType {
    GOLDCLASS("Gold Class"),
    PLATIUM("Platium"),
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
