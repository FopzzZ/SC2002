package Controller;

import java.io.*;
import java.util.ArrayList;
import Entity.Movie.*;
import Entity.Showtime.Showtime;

/**
 * Controller to access and write to movie database
 */
public class MovieController {
    private static ArrayList<Movie> movieList;

    private final static String dataBaseFilePath = "database/Movies.txt";

    /**
     * Class constructor
     */
    public MovieController() {
        movieList = new ArrayList<Movie>();
        File dbFile = new File(dataBaseFilePath);
        if (dbFile.exists())
            movieList = readFromDB();
    }

    /**
     * Creates and adds a new movie to database
     * 
     * @param movieTitle title of movie
     * @param status     showing status of movie
     * @param synopsis   synopsis of movie
     * @param type       type of movie
     * @param rating     rating of movie
     * @param director   director name
     * @param cast       list of cast
     */
    public void createNewMovie(String movieTitle, MovieStatus status, String synopsis, MovieType type,
            MovieRating rating,
            String director, ArrayList<String> cast) {
        Movie movie = new Movie(movieTitle, synopsis, director, type, status, rating, cast,
                new ArrayList<Review>());
        addMovie(movie);
    }

    /**
     * Adds a movie to database
     * 
     * @param movie movie to be added
     */
    public void addMovie(Movie movie) {
        movieList.add(movie);
        writeToDB(movieList);
    }

    /**
     * Updates showtime list of a movie
     * 
     * @param movie     movie to be updated
     * @param showtimes list of showtimes to update movie with
     */
    public void updateShowtime(Movie movie, ArrayList<Showtime> showtimes) {
        int index = searchWithTitle(movie.getTitle());
        movieList.get(index).updateShowtime(showtimes);
        writeToDB(movieList);
    }

    /**
     * Read from database
     * 
     * @return ArrayList<Movie> list of current movies
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Movie> readFromDB() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataBaseFilePath));
            ArrayList<Movie> movieListing = (ArrayList<Movie>) ois.readObject();
            ois.close();
            return movieListing;
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e);
        }
        return new ArrayList<Movie>();
    }

    /**
     * Write to database
     * 
     * @param movielist current list of movies to write to database
     */
    public void writeToDB(ArrayList<Movie> movielist) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataBaseFilePath));
            out.writeObject(movielist);
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e); // print error
        }
    }

    /**
     * Search for a movie by title
     * 
     * @return int index of movie in movie list
     */
    public int searchWithTitle(String title) {
        for (int i = 0; i < movieList.size(); ++i) {
            if (movieList.get(i).getTitle().toUpperCase().equals(title.toUpperCase()))
                return i;
        }
        return -1;
    }

    /**
     * Search for a movie by ID
     * 
     * @param ID ID of movie
     * @return int index of movie
     */
    public int searchWithID(int ID) {
        if (ID > movieList.size()) {
            return -1;
        }
        return ID - 1;
    }

    /**
     * Filter movies by type
     * 
     * @param type type to filter by
     * @return ArrayList<Movie> filtered list of movies
     */
    public ArrayList<Movie> filterByType(MovieType type) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getType() == type) {
                tempList.add(movie);
            }
        }
        return tempList;
    }

    /**
     * Filter movies by status
     * 
     * @param status status to filter by
     * @return ArrayList<Movie> filtered list of movies
     */
    public ArrayList<Movie> filterByStatus(MovieStatus status) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getStatus() == status) {
                tempList.add(movie);
            }
        }
        return tempList;
    }

    /**
     * Filter movies by director name
     * 
     * @param director director name to filter by
     * @return ArrayList<Movie> filtered list of movies
     */
    public ArrayList<Movie> filterByDirector(String director) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getDirector().equals(director)) {
                tempList.add(movie);
            }
        }
        return tempList;
    }

    /**
     * Filter movies by a cast member
     * 
     * @param Cast name of cast
     * @return ArrayList<Movie> filtered list of movies
     */
    public ArrayList<Movie> filterByCast(String Cast) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        ArrayList<String> castList = new ArrayList<String>();
        for (Movie movie : movieList) {
            castList = movie.getCast();
            for (String actor : castList) {
                if (actor.equals(Cast)) {
                    tempList.add(movie);
                }
            }
        }
        return tempList;
    }

    /**
     * Filter movies by rating
     * 
     * @param Rating rating to filter by
     * @return ArrayList<Movie> filtered list of movies
     */
    public ArrayList<Movie> filterByRating(MovieRating Rating) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getRating().equals(Rating)) {
                tempList.add(movie);
            }
        }
        return tempList;
    }

    /**
     * Update movie by title
     * 
     * @param title title of movie to update
     */
    public void updateMovieByTitle(String title) {
        int index = searchWithTitle(title);
        if (index == -1) {
            System.out.println("No such movie!");
            return;
        }
        boolean isDeleted = movieList.get(index).updateDetail();
        if (isDeleted) {
            remove(index);
        }
        writeToDB(movieList);
    }

    /**
     * Update movie by ID
     * 
     * @param ID ID of movie to update
     * @return boolean whether update is successful
     */
    public boolean updateMovieByID(int ID) {
        int index = searchWithID(ID);
        if (index == -1) {
            System.out.println("No such movie!");
            return false;
        }
        boolean isDeleted = movieList.get(index).updateDetail();
        if (isDeleted) {
            remove(index);
        }
        writeToDB(movieList);
        return true;
    }

    /**
     * Add ticket sales to a movie
     * 
     * @param title title of movie
     * @param price price of ticket
     */
    public void addTicketSales(String title, double price) {
        int index = searchWithTitle(title);
        movieList.get(index).addTicketSales(price);
        writeToDB(movieList);
    }

    /**
     * Remove a movie by title
     * 
     * @param title title of movie to remove
     * @return boolean whether movie is successfully removed
     */
    public boolean removeMovieByTitle(String title) {
        int index = searchWithTitle(title);
        if (index == -1) {
            return false;
        }
        remove(index);
        writeToDB(movieList);
        return true;
    }

    /**
     * Remove a movie by ID
     * 
     * @param ID ID of movie to remove
     * @return boolean whether movie is successfully removed
     */
    public boolean removeMovieByID(int ID) {
        int index = searchWithID(ID);
        if (index == -1) {
            return false;
        }
        System.out.println(getMovie(index).getTitle() + " has been removed!");
        remove(index);
        writeToDB(movieList);
        return true;
    }

    /**
     * Print list of movies
     */
    public void listMovies() {
        System.out.println("\n" +
                "-------------------\n" +
                "| Movie Catalogue |\n" +
                "-------------------");
        for (int i = 0; i < movieList.size(); ++i) {
            System.out.printf("Movie %d: %s\n", i + 1, movieList.get(i).getTitle());
        }
        System.out.printf("Total %d movies\n", movieList.size());
    }

    /**
     * Get list of movies
     * 
     * @return ArrayList<Movie> current list of movies
     */
    public ArrayList<Movie> getlistMovies() {
        return movieList;
    }

    /**
     * List top 5 movies by average review scores
     */
    public void listTop5ByRating() {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        tempList = readFromDB();
        ArrayList<Movie> topList = new ArrayList<Movie>();
        double highestRating = 0;

        while (topList.size() < 5) {
            if (tempList.size() == 0) {
                break;
            }
            highestRating = 0;
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).getAverageReviewScore() > highestRating) {
                    highestRating = tempList.get(i).getAverageReviewScore();
                }
            }
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).getAverageReviewScore() == highestRating) {
                    topList.add(tempList.get(i));
                    tempList.remove(i);
                }
            }
        }
        System.out.println("\n" +
                "-------------------------\n" +
                "| Top 5 Movies (Rating) |\n" +
                "-------------------------");
        for (int i = 0; i < topList.size(); ++i) {
            System.out.printf("No.%d rated movie: %s (avg score: %s)\n", i + 1, topList.get(i).getTitle(),
                    topList.get(i).getAverageReviewScore());
        }
    }

    /**
     * List top 5 movies by ticket sales
     */
    public void listTop5ByTicketSales() {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        tempList = readFromDB();
        ArrayList<Movie> topList = new ArrayList<Movie>();
        double highestSales = 0;

        while (topList.size() < 5) {
            if (tempList.size() == 0) {
                break;
            }
            highestSales = 0;
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).getTicketSales() > highestSales) {
                    highestSales = tempList.get(i).getTicketSales();
                }
            }
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).getTicketSales() == highestSales) {
                    topList.add(tempList.get(i));
                    tempList.remove(i);
                }
            }
        }
        System.out.println("\n" +
                "------------------------\n" +
                "| Top 5 Movies (Sales) |\n" +
                "------------------------");
        for (int i = 0; i < topList.size(); ++i) {
            System.out.printf("No.%d most sold movie: %s (sales: %s)\n", i + 1, topList.get(i).getTitle(),
                    topList.get(i).getTicketSales());
        }
    }

    /**
     * Add a user review to a movie by index
     * 
     * @param index         index of movie
     * @param rating        score of review
     * @param reviewContent content of review
     */
    public void addUserReview(int index, int rating, String reviewContent) {
        movieList.get(index).addReview(rating, reviewContent);
        System.out.println("Review added successfully");
        writeToDB(movieList);
    }

    /**
     * Show details of a movie by title
     * 
     * @param title title of movie
     */
    public void showDetail(String title) {
        int index = searchWithTitle(title);
        if (index != -1) {
            System.out.println("\n" +
                    "-----------------\n" +
                    "| Movie Details |\n" +
                    "-----------------");
            System.out.println(movieList.get(index).toString());
        } else
            System.out.println("No movie found");
    }

    /**
     * Show details of a movie by ID
     * 
     * @param ID ID of movie
     */
    public void showDetailByID(int ID) {
        int index = searchWithID(ID);
        if (index != -1) {
            System.out.println("\n" +
                    "-----------------\n" +
                    "| Movie Details |\n" +
                    "-----------------");
            System.out.println(movieList.get(index).toString());
        } else
            System.out.println("No movie found");
    }

    /**
     * Remove a movie by index
     * 
     * @param index index of movie to be removed
     */
    private void remove(int index) {
        movieList.remove(index);
    }

    /**
     * Get a movie by index
     * 
     * @param index index of movie
     * @return Movie movie at selected index
     */
    public Movie getMovie(int index) {
        return movieList.get(index);
    }

    /**
     * Get list of movies
     * 
     * @return ArrayList<Movie> current list of movies
     */
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Clears movie database
     */
    public void clearDatabase() {
        while (movieList.size() > 0) {
            movieList.remove(0);
        }
        writeToDB(movieList);
        System.out.println("Clearing movie database");
    }
}
