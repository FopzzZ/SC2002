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
            System.out.println("Reading from movies database"); // for testing
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
            System.out.println("Updating movies database"); // for testing
        } catch (IOException e) {
            System.out.println(e); // print error
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

    public void filterByType(MovieType type) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getType() == type) {
                tempList.add(movie);
            }
        }
        ;
        for (int i = 0; i < tempList.size(); ++i) {
            System.out.printf("Movie %d: %s\n", i + 1, tempList.get(i).getTitle());
        }
        System.out.printf("Total %d movies.\n", tempList.size());
    }

    public void filterByStatus(MovieStatus status) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getStatus() == status) {
                tempList.add(movie);
            }
        }
        ;
        for (int i = 0; i < tempList.size(); ++i) {
            System.out.printf("Movie %d: %s\n", i + 1, tempList.get(i).getTitle());
        }
        System.out.printf("Total %d movies.\n", tempList.size());
    }
    
    public void filterByDirector(String Director) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getDirector().equals(Director)) {
                tempList.add(movie);
            }
        }
        ;
        for (int i = 0; i < tempList.size(); ++i) {
            System.out.printf("Movie %d: %s\n", i + 1, tempList.get(i).getTitle());
        }
        System.out.printf("Total %d movies.\n", tempList.size());
    }
    
    public void filterByCast(String Cast) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        ArrayList<String> castList = new ArrayList<String>();
        for (Movie movie : movieList) {
            castList = movie.getCast();
            for(String actor : castList) {
                if (actor.equals(Cast)) {
                tempList.add(movie);
                }
            }
        }
        ;
        for (int i = 0; i < tempList.size(); ++i) {
            System.out.printf("Movie %d: %s\n", i + 1, tempList.get(i).getTitle());
        }
        System.out.printf("Total %d movies.\n", tempList.size());
    }
    
    public void filterByRating(String Rating) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getRating().equals(Rating)) {
                tempList.add(movie);
            }
        }
        ;
        for (int i = 0; i < tempList.size(); ++i) {
            System.out.printf("Movie %d: %s\n", i + 1, tempList.get(i).getTitle());
        }
        System.out.printf("Total %d movies.\n", tempList.size());
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
            System.out.println("No movie found.");
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

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void clearDatabase() {
        while (movieList.size() > 0) {
            movieList.remove(0);
        }
        writeToDB(movieList);
        System.out.println("Clearing movie database");
    }

    // adding initial movies to database for testing
    public static void main(String[] args) { // for testing
        // add movies run once
        ArrayList<String> cast = new ArrayList<String>();
        cast.add("Cast1");
        cast.add("Cast2");
        MovieController movieController = new MovieController();
        movieController.clearDatabase();
        movieController.createNewMovie("John Cena", MovieStatus.Showing, "now u see me",
                "4", MovieType.Common,
                "dk", cast);
        movieController.createNewMovie("Nemo", MovieStatus.Showing, "now u see me",
                "4", MovieType.Common,
                "dk", cast);
        movieController.createNewMovie("Bob bones", MovieStatus.Showing, "now u see me",
                "4", MovieType.Common,
                "dk", cast);
    }
}
