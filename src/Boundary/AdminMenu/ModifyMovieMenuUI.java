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
            System.out.println("Select action: ");
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
        System.out.println("Enter movie title: ");
        movieTitle = InputController.getStringFromUser();
        System.out.println("Select showing status:\n" +
                "1. Coming Soon\n" +
                "2. Preview\n" +
                "3. Now Showing\n" +
                "4. End of Showing");
        switch (InputController.getIntFromUser(1, 4)) {
            case 1:
                showingStatus = MovieStatus.Coming;
                break;
            case 2:
                showingStatus = MovieStatus.Preview;
                break;
            case 3:
                showingStatus = MovieStatus.Showing;
                break;
            case 4:
                showingStatus = MovieStatus.Ended;
                break;

        }
        System.out.println("Select movie rating:\n" +
                "1. G (General)\n" +
                "2. PG (Parental Guidance)\n" +
                "3. PG13 (Parental Guidance 13)\n" +
                "4. NC16 (No Children Under 16)\n" +
                "5. M18 (Mature 18)\n" +
                "6. R21 (Restricted 21)");
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
        System.out.println("Enter synopsis: ");
        movieSynopsis = InputController.getStringFromUser();
        System.out.println("Enter director's name: ");
        movieDirector = InputController.getStringFromUser();
        System.out.println("Enter a cast's name: (Enter END when done)");
        castInput = InputController.getStringFromUser();
        while (!castInput.equals("END")) {
            castNames.add(castInput);
            castInput = InputController.getStringFromUser();
        }
        movieController.createNewMovie(movieTitle, showingStatus, movieSynopsis, movieType,
                rating, movieDirector, castNames);
    }

    private void updateMovieListing() {
        movieController.listMovies();
        System.out.println("Select movie to update: ");
        int ID = InputController.getIntFromUser();
        movieController.updateMovieByID(ID);
    }

    private void removeMovieListing() { // deletes off database for now
        movieController.listMovies();
        System.out.println("Select movie to remove: ");
        int ID = InputController.getIntFromUser();
        boolean success = movieController.removeMovieByID(ID);
        if (success)
            System.out.println("Movie has been removed");
        else
            System.out.println("The movie does not exist.");
    }
}
