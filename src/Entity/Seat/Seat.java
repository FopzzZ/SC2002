package Entity.Seat;

import java.io.Serializable;

public class Seat implements Serializable {
    private int rowNumber, columnNumber;
    private boolean isOccupied;
    private SeatType seatType;
    // relatedSeat is 'null' if seat type is single seat
    private Seat relatedSeat;

    public Seat() {
        this.rowNumber = -1;
        this.columnNumber = -1;
        this.isOccupied = false;
        this.seatType = SeatType.CoupleSeat;
        this.relatedSeat = null;
    }

    public Seat(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.isOccupied = false;
        this.seatType = SeatType.SingleSeat;
        this.relatedSeat = null;
    }

    /**
    * Method to set the row number of seat
    *
    * @param Integer that has the row number    
    */
       
    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }
    /**
    * Method to set the column number of seat
    *
    * @param Integer that has the column number    
    */

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }
     /**
    * Method to set the Seat Type
    *
    * @return SeatType This returns the type of the seat object.    
    */
    
    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    /**
    * Method to set the related seats
    *
    * @return Seat Type This returns the type of the related seats. 
    */
    
    public void setRelatedSeat(Seat seat) {
        this.relatedSeat = seat;
    }
    /**
    * Method to see if seat is occupied.
    *  
    */

    public void occupy() {
        this.isOccupied = true;
    }
    /**
    * Method to see if seat is unoccupied.
    *  
    */

    public void unOccupy() {
        this.isOccupied = false;
    }

    public int getRowNumber() {
        return this.rowNumber;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }

    public SeatType getSeatType() {
        return this.seatType;
    }

    public Seat getRelatedSeat() {
        return this.relatedSeat;
    }
}
