package Entity.Seat;

/**
* SeatType is an entity containing the type of the seat
*/
public enum SeatType {
    SingleSeat("Single Seat"),
    CoupleSeat("Couple Seat"),
    EliteSeat("Elite Seat"),
    UltimaSeat("Ultima Seat");

    private final String text;

    /** 
     * A constructor for the SeatType class
     * 
     * @param text Determines the seat type
     */
    private SeatType(String text) {
        this.text = text;
    }

    /** 
     * A method that converts the seat type as a string
     * 
     * @return String This returns the seat type
     */
    public String toString() {
        return this.text;
    }
}
