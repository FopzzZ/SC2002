package Entity.Seat;

import java.io.Serializable;
import java.util.ArrayList;

public class SeatPlan implements Serializable {
    ArrayList<Seat> seats;
    int row, column;

    public SeatPlan(int row, int column) {
        seats = new ArrayList<Seat>();
        this.row = row;
        this.column = column;
        for (int i = 1; i <= row; ++i)
            for (int j = 1; j <= column; ++j) {
                Seat seat = new Seat(i, j);
                seats.add(seat);
            }
    }

    // only single seats now
    public void showSeatplan() { // hardcoded for 9 rows and 24 columns
        System.out.print("            SCREEN\n"); // fixed spaces for now
        System.out.print("  ");
        for (int j = 1; j <= this.column; ++j) {
            System.out.print(String.valueOf((char) (j + 'A' - 1)));
            if (j == this.column / 3)
                System.out.print(" ");
            if (j == this.column / 3 * 2)
                System.out.print(" ");
        }
        System.out.print("\n");
        for (int i = 1; i <= this.row; ++i) {
            System.out.print(i + " ");
            for (int j = 1; j <= this.column; ++j) {

                Seat seat = seats.get((i - 1) * this.column + j - 1);
                if (seat.isOccupied())
                    System.out.print("X");
                else
                    System.out.print("O");
                if (j == this.column / 3)
                    System.out.print(" ");
                if (j == this.column / 3 * 2)
                    System.out.print(" ");
                if (j == this.column)
                    System.out.println("");
            }
        }
    }

    public boolean occupy(int rowNumber, int columnNumber) { // returns false if seat is already occupied
        Seat seat = seats.get((rowNumber - 1) * this.column + columnNumber - 1);
        if (seat.isOccupied())
            return false;
        seat.occupy();
        if (seat.getSeatType() == SeatType.CoupleSeat) {
            Seat coupleSeat = seat.getRelatedSeat();
            coupleSeat.occupy();
        }
        return true;
    }

    // unit test(done)
    public static void main(String[] args) {
        SeatPlan seatPlan = new SeatPlan(9, 24);
        seatPlan.showSeatplan();
        seatPlan.occupy(2, 3);
        seatPlan.occupy(3, 3);
        seatPlan.showSeatplan();
    }
}
