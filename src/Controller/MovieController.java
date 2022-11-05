package Controller;

import java.io.*;
import java.util.ArrayList;
import Entity.Movie.*;

public class MovieController {
    private ArrayList<Movie> movieList;

    private final static String DataBaseFilePath = "DataBase/Movies.txt";

    public MovieController() {
        movieList = new ArrayList<Movie>();
        File dbFile = new File(DataBaseFilePath);
        if (dbFile.exists())
            movieList = readFromDB();
    }

    public void createNewMovie(String movieTitle, MovieStatus status, String synposis, String rating, MovieType type,
            String director, ArrayList<String> cast) {
        Movie movie = new Movie(getLastID() + 1, movieTitle, synposis, director, type, status, rating, cast,
                new ArrayList<Review>());
        movieList.add(movie);
        writeToDB(movieList);
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
        writeToDB(movieList);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Movie> readFromDB() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DataBaseFilePath));
            ArrayList<Movie> movieListing = (ArrayList<Movie>) ois.readObject();
            ois.close();
            return movieListing;
        } catch (ClassNotFoundException | IOException e) {
        }
        return new ArrayList<Movie>();
    }

    public void writeToDB(ArrayList<Movie> movielist) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DataBaseFilePath));
            out.writeObject(movielist);
            out.flush();
            out.close();
        } catch (IOException e) {
            // ignore error
        }
    }

    public int getLastID() {
        if (movieList.size() == 0) {
            return 1;
        }
        return movieList.get(movieList.size() - 1).getID();
    }

    private int searchWithTitle(String title) {
        for (int i = 0; i < movieList.size(); ++i) {
            if (movieList.get(i).getTitle().equals(title))
                return i;
        }
        return -1;
    }

    private int searchWithID(int ID) {
        for (int i = 0; i < movieList.size(); ++i) {
            if (movieList.get(i).getID() == ID)
                return i;
        }
        return -1;
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
            System.out.printf("Movie %d: %s\n", movieList.get(i).getID(), movieList.get(i).getTitle());
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

    private void remove(int index) {
        movieList.remove(index);
    }
}
