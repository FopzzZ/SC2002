package SC2002.Component.Seat;

public class CoupleSeat extends Seat{

    private CoupleSeat relatedSeat;

    public CoupleSeat() {
        super(-1, -1);
        this.relatedSeat = new CoupleSeat();
        this.setSeatType("CoupleSeat");
    }

    public CoupleSeat(int rowNumber, int columnNumber) {
        super(rowNumber, columnNumber);
        relatedSeat = new CoupleSeat();
    }

    public void setRelatedSeat(CoupleSeat relatedSeat) {
        this.relatedSeat = relatedSeat;
    }

    public CoupleSeat getRelatedSeat() {
        return this.relatedSeat;
    }
}
