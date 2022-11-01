package SC2002.Component.Seat;

public class Seat {
    private int rowNumber, columnNumber;
    private boolean isOccupied;
    private String seatType;
    public Seat (int rowNumber, int columnNumber){
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.isOccupied = false;
        this.seatType = "SingleSeat";
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public void occupy() {
        this.isOccupied = true;
    }

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

    public String getSeatType() {
        return this.seatType;
    }
}