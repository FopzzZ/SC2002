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

    public void createNewMovie(String movieTitle, MovieStatus status, String synopsis, MovieType type,
            MovieRating rating,
            String director, ArrayList<String> cast) {
        Movie movie = new Movie(movieTitle, synopsis, director, type, status, rating, cast,
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
            // System.out.println("Reading from movies database");
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
            // System.out.println("Updating movies database"); // for testing
        } catch (IOException e) {
            System.out.println(e); // print error
        }
    }

    public int searchWithTitle(String title) { // returns index of movie in movieList
        for (int i = 0; i < movieList.size(); ++i) {
            if (movieList.get(i).getTitle().toUpperCase().equals(title.toUpperCase()))
                return i;
        }
        return -1;
    }

    public int searchWithID(int ID) {
        if (ID > movieList.size()) {
            return -1;
        }
        return ID - 1;
    }

    public ArrayList<Movie> filterByType(MovieType type) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getType() == type) {
                tempList.add(movie);
            }
        }
        return tempList;
    }

    public ArrayList<Movie> filterByStatus(MovieStatus status) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getStatus() == status) {
                tempList.add(movie);
            }
        }
        return tempList;
    }

    public ArrayList<Movie> filterByDirector(String Director) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getDirector().equals(Director)) {
                tempList.add(movie);
            }
        }
        return tempList;
    }

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

    public ArrayList<Movie> filterByRating(MovieRating Rating) {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getRating().equals(Rating)) {
                tempList.add(movie);
            }
        }
        return tempList;
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

    public void addTickectSales(String title, double price) {
        int index = searchWithTitle(title);
        movieList.get(index).addTicketSales(price);
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
        System.out.println("\n" +
                "-------------------\n" +
                "| Movie Catalogue |\n" +
                "-------------------");
        for (int i = 0; i < movieList.size(); ++i) {
            System.out.printf("Movie %d: %s\n", i + 1, movieList.get(i).getTitle());
        }
        System.out.printf("Total %d movies\n", movieList.size());
    }

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
        // System.out.println("Top movies by rating:");
        System.out.println("\n" +
                "-------------------------\n" +
                "| Top 5 Movies (Rating) |\n" +
                "-------------------------");
        for (int i = 0; i < topList.size(); ++i) {
            System.out.printf("Movie rated no.%d: %s (rating: %s)\n", i + 1, topList.get(i).getTitle(),
                    topList.get(i).getAverageReviewScore());
        }
    }

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
        // System.out.println("Top movies by sales:");
        System.out.println("\n" +
                "------------------------\n" +
                "| Top 5 Movies (Sales) |\n" +
                "------------------------");
        for (int i = 0; i < topList.size(); ++i) {
            System.out.printf("No.%d Most sold movie: %s (sales: %s)\n", i + 1, topList.get(i).getTitle(),
                    topList.get(i).getTicketSales());
        }
    }

    public void addUserReview(int index, int rating, String reviewContent) {
        movieList.get(index).addReview(rating, reviewContent);
        System.out.println("Review added successfully"); // test
        writeToDB(movieList);
    }

    public void showDetail(String title) {
        int index = searchWithTitle(title);
        if (index != -1) {
            System.out.println("\n" +
                    "-----------------\n" +
                    "| Movie Details |\n" +
                    "-----------------");
            System.out.println(movieList.get(index).toString());
        } else
            System.out.println("No movie found.");
    }

    public void showDetailByID(int ID) {
        int index = searchWithID(ID);
        if (index != -1) {
            System.out.println("\n" +
                    "-----------------\n" +
                    "| Movie Details |\n" +
                    "-----------------");
            System.out.println(movieList.get(index).toString());
        } else
            System.out.println("No movie found.");
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
                MovieType.Common,
                MovieRating.G, "dk", cast);
        movieController.createNewMovie("Nemo", MovieStatus.Showing, "now u see me",
                MovieType.Common,
                MovieRating.G, "dk", cast);
        movieController.createNewMovie("Bob bones", MovieStatus.Showing, "now u see me",
                MovieType.Common,
                MovieRating.G, "dk", cast);
    }
}
