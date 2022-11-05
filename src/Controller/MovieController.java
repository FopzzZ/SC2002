package Controller;

import java.io.*;
import java.util.ArrayList;
import Entity.Movie.*;
import Entity.Showtime.Showtime;

public class MovieController {
    private static ArrayList<Movie> movieList;

    private final static String dataBaseFilePath = "database/Movies.txt";

    public MovieController() {
        movieList = new ArrayList<Movie>();
        File dbFile = new File(dataBaseFilePath);
        if (dbFile.exists())
            movieList = readFromDB();
    }

    public void createNewMovie(String movieTitle, MovieStatus status, String synposis, String rating, MovieType type,
            String director, ArrayList<String> cast) {
        Movie movie = new Movie(movieTitle, synposis, director, type, status, rating, cast,
                new ArrayList<Review>());
        addMovie(movie);
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
        writeToDB(movieList);
    }

    // public void addShowtime(Movie movie, Showtime showtime) {
    // int index = searchWithTitle(movie.getTitle());
    // movieList.get(index).addShowtime(showtime);
    // writeToDB(movieList);
    // }

    public void updateShowtime(Movie movie, ArrayList<Showtime> showtimes) {
        int index = searchWithTitle(movie.getTitle());
        movieList.get(index).updateShowtime(showtimes);
        writeToDB(movieList);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Movie> readFromDB() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataBaseFilePath));
            ArrayList<Movie> movieListing = (ArrayList<Movie>) ois.readObject();
            ois.close();
            System.out.println("Reading from database"); // for testing
            return movieListing;
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e); // for testing
        }
        return new ArrayList<Movie>();
    }

    public void writeToDB(ArrayList<Movie> movielist) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataBaseFilePath));
            out.writeObject(movielist);
            out.flush();
            out.close();
            System.out.println("Updating database"); // for testing
        } catch (IOException e) {
            // ignore error
        }
    }

    public int searchWithTitle(String title) { // returns index of movie in movieList
        for (int i = 0; i < movieList.size(); ++i) {
            if (movieList.get(i).getTitle().equals(title))
                return i;
        }
        return -1;
    }

    public int searchWithID(int ID) {
        if (ID > movieList.size()) {
            return -1;
        }
        return ID;
    }

    public void updateMovieByTitle(String title) {
        int index = searchWithTitle(title);
        if (index == -1) {
            System.out.println("No such movie");
            return;
        }
        boolean isDeleted = movieList.get(index).updateDetail();
        if (isDeleted) {
            remove(index);
        }
        writeToDB(movieList);
    }

    public void updateMovieByID(int ID) {
        int index = searchWithID(ID);
        if (index == -1) {
            System.out.println("No such movie");
            return;
        }
        boolean isDeleted = movieList.get(index).updateDetail();
        if (isDeleted) {
            remove(index);
        }
        writeToDB(movieList);
    }

    // return false if no such movie, return true if removed successfully
    public boolean removeMovieByTitle(String title) {
        int index = searchWithTitle(title);
        if (index == -1) {
            return false;
        }
        remove(index);
        writeToDB(movieList);
        return true;
    }

    public boolean removeMovieByID(int ID) {
        int index = searchWithID(ID);
        if (index == -1) {
            return false;
        }
        remove(index);
        writeToDB(movieList);
        return true;
    }

    public void listMovies() {
        for (int i = 0; i < movieList.size(); ++i) {
            System.out.printf("Movie %d: %s\n", i + 1, movieList.get(i).getTitle());
        }
        System.out.printf("Total %d movies.\n", movieList.size());
    }

    public void showDetail(String title) {
        int index = searchWithTitle(title);
        if (index != -1)
            System.out.println(movieList.get(index).toString());
        else
            System.out.println("No such movie.");
    }

    public void showDetail(int index) {
        if (index != -1)
            System.out.println(movieList.get(index).toString());
        else
            System.out.println("No such movie.");
    }

    private void remove(int index) {
        movieList.remove(index);
    }

    public Movie getMovie(int index) {
        return movieList.get(index);
    }
}
