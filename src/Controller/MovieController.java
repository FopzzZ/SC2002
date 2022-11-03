package Controller;

import java.util.ArrayList;

import Entity.Movie.Movie;

public class MovieController {
    private ArrayList<Movie> movieList;

    public MovieController() {
        movieList = new ArrayList<Movie>();
    }

    public void createMovie() {
        System.out.println("Enter the new movie's title: ");
        String s = InputController.getStringFromUser();
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

    public void updateMovie(String title) {
        int index = searchWithTitle(title);
        if (index == -1) {
            System.out.println("No such movie");
            return;
        }
        boolean isDeleted = movieList.get(index).updateDetail();
        if (isDeleted) {
            remove(index);
        }
    }

    //return false if no such movie, return true if removed successfully
    public boolean removeMovie(String title) {
        int index = searchWithTitle(title);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
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
            System.out.println(movieList.get(index).toString());
        else
            System.out.println("No such movie.");
    }

    private void remove(int index) {
        movieList.remove(index);
    }
}
