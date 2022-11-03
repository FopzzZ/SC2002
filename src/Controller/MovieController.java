package Controller;

import java.io.*;
import java.util.ArrayList;

import Entity.Movie.Movie;
import Entity.Movie.MovieStatus;
import Entity.Movie.MovieType;
import Entity.Movie.Review;

public class MovieController {
    private ArrayList<Movie> movieList;

    private final static String DataBaseFilePath = "DataBase/Movies.txt";

    public MovieController() {
        movieList = new ArrayList<Movie>();
        File dbFile = new File(DataBaseFilePath);
        if(dbFile.exists())
            movieList = readFromDB();
    }

    public void createNewMovie(String movieTitle,MovieStatus status, String synposis, String rating, MovieType type, String director, ArrayList<String> cast) {
        Movie movie = new Movie(getLastID() + 1, movieTitle, synposis, director, type, status, rating, cast, new ArrayList<Review>());
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

    private int getLastID() {
        int maxID = 0;
        for(Movie movie: movieList) {
            if(movie.getID() > maxID)
                maxID = movie.getID();
        }
        return maxID;
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
            System.out.printf("Movie%d: %s\n", movieList.get(i).getID(), movieList.get(i).getTitle());
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
