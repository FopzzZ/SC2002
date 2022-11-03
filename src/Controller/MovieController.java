package Controller;

import java.util.ArrayList;

import Main;
import Component.Movie.*;

public class MovieController {
    public ArrayList<Movie> movieList;

    public MovieController() {
        movieList = new ArrayList<Movie>();
    }

    public void createMovie() {
        System.out.println("Enter the new movie's title: ");
        String s = Main.sc.nextLine();
        addMovie(s);
        System.out.printf("Have created new movie <%s>.\n", s);
    }

    public void addMovie(String s) {
        Movie newMovie = new Movie();
        newMovie.setTitle(s);
        movieList.add(newMovie);
    }

    private int searchWithTitle(String title) {
        for (int i = 0; i < movieList.size(); ++i) {
            if (movieList.get(i).getTitle().equals(title))
                return i;
        }
        return -1;
    }

    public void updateMovie() {
        System.out.println("Enter the title of the movie you want to edit: ");
        String s = Main.sc.nextLine();
        int index = searchWithTitle(s);
        if (index == -1) {
            System.out.println("No such movie");
            return;
        }
        boolean isDeleted = movieList.get(index).updateDetail();
        if (isDeleted) {
            remove(index);
        }
    }

    public void removeMovie() {
        System.out.println("Enter the title of movie you want to remove: ");
        String s = Main.sc.nextLine();
        int index = searchWithTitle(s);
        if (index == -1) {
            System.out.println("No such movie");
            return;
        }
        remove(index);
        System.out.printf("Successfully removed the movie <%s>.\n", s);
    }

    public void listMovies() {
        for (int i = 0; i < movieList.size(); ++i) {
            System.out.printf("Movie%d: %s\n", i + 1, movieList.get(i).getTitle());
        }
        System.out.printf("Totally %d movies.", movieList.size());
    }

    public void showDetail(String title) {
        int index = searchWithTitle(title);
        if (index != -1)
            movieList.get(index).showDetail();
        else
            System.out.println("No such movie.");
    }

    private void remove(int index) {
        movieList.remove(index);
    }
}
