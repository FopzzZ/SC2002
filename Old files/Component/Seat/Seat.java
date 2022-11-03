package Component.Seat;

public class Seat {
    private int rowNumber, columnNumber;
    private boolean isOccupied;
    private SeatType seatType;
    private Seat relatedSeat;

    public Seat() {
        this.rowNumber = -1;
        this.columnNumber = -1;
        this.isOccupied = false;
        this.seatType = SeatType.CoupleSeat;
        this.relatedSeat = new Seat();
    }

    public Seat(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.isOccupied = false;
        this.seatType = SeatType.SingleSeat;
        this.relatedSeat = new Seat();
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public void setRelatedSeat(Seat seat) {
        this.relatedSeat = seat;
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

    public SeatType getSeatType() {
        return this.seatType;
    }

    public Seat getRelatedSeat() {
        return this.relatedSeat;
    }
}