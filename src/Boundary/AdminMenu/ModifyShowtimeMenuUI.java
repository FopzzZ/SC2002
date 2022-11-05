package Boundary.AdminMenu;

import Controller.InputController;

public class ModifyShowtimeMenuUI {
    public void main() {
        System.out.println("Select movie to modify showtimes:");
        // TODO print list of movies and then select one
        System.out.println("1. Create movie showtime");
        System.out.println("2. Update movie showtime");
        System.out.println("3. Remove movie showtime");
        System.out.println("4. Return to main menu");
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

    private void removeMovieShowtime() {
    }

    private void updateMovieShowtime() {
    }

    private void createMovieShowtime() {
    }
}
