package Entity.Seat;

import java.io.Serializable;
/**
* Seat is an entity
*/
public class Seat implements Serializable {
    private int rowNumber, columnNumber;
    private boolean isOccupied;
    private SeatType seatType;
    // relatedSeat is 'null' if seat type is single seat
    private Seat relatedSeat;
    /**
    * A constructor for the Seat class with default values
    */
    public Seat() {
        this.rowNumber = -1;
        this.columnNumber = -1;
        this.isOccupied = false;
        this.seatType = SeatType.CoupleSeat;
        this.relatedSeat = null;
    }
    /**
    * A constructor for the Seat class
    * 
    * @param rowNumber Determines the row number of the seat
    * @param columnNumber Determines the column number of the seat
    */
    public Seat(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.isOccupied = false;
        this.seatType = SeatType.SingleSeat;
        this.relatedSeat = null;
    }

    
    /** 
     * A method that takes in an integer and sets it as the row number of the seat
     * 
     * @param rowNumber Determines the row number of the seat
     */
    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    
    /** 
     * A method that takes in an integer and sets it as the column number of the seat
     * 
     * @param columnNumber Determines the column number of the seat
     */
    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    
    /** 
     * A method that takes in a seatType and sets it as the type of the seat
     * 
     * @param seatType Determines the type of the seat
     */
    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    
    /** 
     * A method that takes in a seat and sets it as a related seat of the seat
     * 
     * @param seat Determines the seat to be related to the seat
     */
    public void setRelatedSeat(Seat seat) {
        this.relatedSeat = seat;
    }
    /** 
     * A method that sets the seat as occupied
     */
    public void occupy() {
        this.isOccupied = true;
    }
    /** 
     * A method that sets the seat as unoccupied
     */
    public void unOccupy() {
        this.isOccupied = false;
    }

    
    /** 
     * A method that returns the row number of the seat
     * 
     * @return int This returns the row number of the seat
     */
    public int getRowNumber() {
        return this.rowNumber;
    }

    
    /** 
     * A method that returns the column number of the seat
     * 
     * @return int This returns the column number of the seat
     */
    public int getColumnNumber() {
        return this.columnNumber;
    }

    
    /** 
     * A method that returns whether the seat is occupied or not
     * 
     * @return boolean This returns true if the seat is occupied and false if the seat is unoccupied
     */
    public boolean isOccupied() {
        return this.isOccupied;
    }

    
    /** 
     * A method that returns the type of the seat
     * 
     * @return SeatType This returns the type of the seat as a seatType
     */
    public SeatType getSeatType() {
        return this.seatType;
    }

    
    /** 
     * A method that returns the seat related to this seat
     * 
     * @return Seat This returns the seat related to the seat
     */
    public Seat getRelatedSeat() {
        return this.relatedSeat;
    }
}