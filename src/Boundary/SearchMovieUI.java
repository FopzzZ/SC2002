package Boundary;

import Controller.*;
import Entity.Movie.*;

public class SearchMovieUI {
    private String title;
    private String type;
    private int option;

    public void main(){
        while (option!=4) {
            System.out.println("1. Search by movie title");
            System.out.println("2. Search by movie type");
            System.out.println("3. List all movie title");
            System.out.println("4. Exit");
            switch (option = InputController.getIntFromUser()) {
                case 1:
                    searchByTitle();
                    break;
                case 2:
                    searchByType();
                    break;
                case 3:
                    showAllMovies();
                    break;
                case 4:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid input! Please try again.");
            }
        }
    }

    public void searchByTitle(){
        title = InputController.getStringFromUser();
    }

    public void searchByType(){
        type = InputController.getStringFromUser();
    }

    public void showAllMovies(){

    }
}
