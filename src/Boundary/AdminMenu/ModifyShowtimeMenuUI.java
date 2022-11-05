package Boundary.AdminMenu;

import Controller.InputController;

public class ModifyShowtimeMenuUI {
    public void main() {
        while (true) {
            System.out.println("Select movie to modify showtimes:");
            // TODO print list of movies and then select one
            System.out.println("\n" +
                    "--------------------\n" +
                    "| Modify Showtimes |\n" +
                    "--------------------\n" +
                    "1. Create showtime\n" +
                    "2. Update showtime\n" +
                    "3. Remove showtime\n" +
                    "4. Back to main menu\n");
            System.out.println("Select action: ");
            switch (InputController.getIntFromUser(1, 4)) {
                case 1:
                    createMovieShowtime();
                    break;
                case 2:
                    updateMovieShowtime();
                    break;
                case 3:
                    removeMovieShowtime();
                    break;
                case 4:
                    return;
            }
        }

    }

    private void removeMovieShowtime() {
    }

    private void updateMovieShowtime() {
    }

    private void createMovieShowtime() {
    }
}
