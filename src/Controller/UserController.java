package Controller;

import java.util.ArrayList;

import Controller.InputController;
import Controller.MovieController;
import Entity.Movie.Movie;

public class UserController {
    public class 
    
    public void searchMovies() {
        System.out.println("How would you like to search for a movie?");
        System.out.println("(1) Search by Movie Title\n (2) Search by Movie Type\n (3) Search by Movie Director\n (4) Search by Movie Rating\n (5) Back");
        
        int choice = InputController.getIntFromUser();
        int result = -1;
        int found = -1;

    private ArrayList<movie> resultList = new ArrayList<movie>;
    private ArrayList<Integer> resultInt = new ArrayList<Integer>;

    ArrayList<movie> movielist = MovieController.readFromDB();
    // TO DO: Finish search function to return a list of movies so that can search
    // by type and director
    // TO DO: Edit Movie.java to include search functions for type, director and
    // rating
    switch(choice)
    {
            case 1:
                string inputTitle = InputController.getStringFromUser();
                for(int i = 0; i < movieList.size; i++) {
                    result = MovieController.searchWithTitle(inputTitle);
                    if(result > 0 && ) {
                        resultList.add(movieList.get(result));
                        resultInt.add(result);
                        
                    }
                }
                
                break;
            case 2:
                string inputType = InputController.getStringFromUser();
                result = MovieController.searchWithType(inputType);
                break;
            case 3:
                string inputDirector = InputController.getStringFromUser();
                result = MovieController.searchWithDirector(inputDirector);
                break;
            case 4:
                string inputRating = InputController.getStringFromUser();
                result = MovieController.searchWithRating(inputRating);
                break;
            case 5:
                result = -2;
                break;
                
        }if(found==-1)
    {
        System.out.println("Movie not found");
    }
    }

    public void bookTicket() {

    }
}
