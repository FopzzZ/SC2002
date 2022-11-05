package Entity.Seat;

public enum SeatType {
    SingleSeat("Single Seat"),
    CoupleSeat("Couple Seat"),
    EliteSeat("Elite Seat"),
    UltimaSeat("Ultima Seat");

    private final String text;

    private SeatType(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
