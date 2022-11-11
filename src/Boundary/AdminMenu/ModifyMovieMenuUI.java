package Boundary.AdminMenu;

import java.util.ArrayList;

import Controller.InputController;
import Controller.MovieController;
import Entity.Movie.MovieRating;
import Entity.Movie.MovieStatus;
import Entity.Movie.MovieType;

public class ModifyMovieMenuUI {
    MovieController movieController;

    public void main() {
        movieController = new MovieController();
        while (true) {
            System.out.println("\n" +
                    "-----------------\n" +
                    "| Modify Movies |\n" +
                    "-----------------\n" +
                    "1. Create movie listing\n" +
                    "2. Update movie listing\n" +
                    "3. Remove movie listing\n" +
                    "4. Back to main menu\n");
            System.out.print("Select action: ");
            switch (InputController.getIntFromUser(1, 4)) {
                case 1:
                    createMovieListing();
                    break;
                case 2:
                    updateMovieListing();
                    break;
                case 3:
                    removeMovieListing();
                    break;
                case 4:
                    return;
            }
        }
    }

    private void createMovieListing() {
        String movieTitle, movieSynopsis, movieDirector, castInput;
        ArrayList<String> castNames = new ArrayList<String>();
        MovieStatus showingStatus = MovieStatus.Coming;
        MovieType movieType = MovieType.Common;
        MovieRating rating = MovieRating.G;
        System.out.println("\n" +
                "------------------------\n" +
                "| Create Movie Listing |\n" +
                "------------------------");
        System.out.println("Enter movie title: ");
        movieTitle = InputController.getStringFromUser();
        System.out.print("\n[Step 1]\n" +
                "1. Coming Soon\n" +
                "2. Preview\n" +
                "3. Now Showing\n" +
                "\nSelect showing status: ");
        switch (InputController.getIntFromUser(1, 3)) {
            case 1:
                showingStatus = MovieStatus.Coming;
                break;
            case 2:
                showingStatus = MovieStatus.Preview;
                break;
            case 3:
                showingStatus = MovieStatus.Showing;
                break;

        }
        System.out.print("\n[Step 2]\n" +
                "1. G (General)\n" +
                "2. PG (Parental Guidance)\n" +
                "3. PG13 (Parental Guidance 13)\n" +
                "4. NC16 (No Children Under 16)\n" +
                "5. M18 (Mature 18)\n" +
                "6. R21 (Restricted 21)\n" +
                "\nSelect movie rating: ");
        switch (InputController.getIntFromUser(1, 6)) {
            case 1:
                rating = MovieRating.G;
                break;
            case 2:
                rating = MovieRating.PG;
                break;
            case 3:
                rating = MovieRating.PG13;
                break;
            case 4:
                rating = MovieRating.NC16;
                break;
            case 5:
                rating = MovieRating.M18;
                break;
            case 6:
                rating = MovieRating.R21;
                break;
        }
        System.out.print("\n[Step 3]\nEnter synopsis: ");
        movieSynopsis = InputController.getStringFromUser();
        System.out.print("\n[Step 4]\nEnter director's name: ");
        movieDirector = InputController.getStringFromUser();
        System.out.print("\n[Step 5]\nEnter a cast's name (Enter 'DONE' when done): ");
        castInput = InputController.getStringFromUser();
        while (!castInput.equals("DONE")) {
            castNames.add(castInput);
            castInput = InputController.getStringFromUser();
        }
        movieController.createNewMovie(movieTitle, showingStatus, movieSynopsis, movieType,
                rating, movieDirector, castNames);
    }

    private void updateMovieListing() {
        System.out.println("\n" +
                "------------------------\n" +
                "| Update Movie Listing |\n" +
                "------------------------\n" +
                "Enter non-existent movie index to exit!");
        movieController.listMovies();
        System.out.print("\nSelect movie to update: ");
        int ID = InputController.getIntFromUser();
        movieController.updateMovieByID(ID);
    }

    private void removeMovieListing() { // deletes off database for now
        System.out.println("\n" +
                "------------------------\n" +
                "| Remove Movie Listing |\n" +
                "------------------------\n" +
                "Enter non-existent movie index to exit!");
        movieController.listMovies();
        System.out.print("\nSelect movie to remove: ");
        int ID = InputController.getIntFromUser();
        boolean success = movieController.removeMovieByID(ID);
        if (success)
            System.out.println("Movie has been removed!");
        else
            System.out.println("No such movie!");
    }
}
