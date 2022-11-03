package src.AdminSystem;

import src.Main;
import src.Controller.MainController;

public class AdminSystem{
    loginSystem loginSys;
    public AdminSystem() {
        loginSys = new loginSystem();
    }

    public void Work() {
        if(!loginSys.login()) return;
        String input = new String();
        while(true) {
            System.out.println("Input number for your operations:");
            System.out.println("1: Edit movie list");
            System.out.println("2: Edit showtimes");
            System.out.println("3: Edit system config");
            System.out.println("4: Exit");
            input = Main.sc.nextLine();
            boolean exit = false;
            switch (input) {
                case "1":
                    EditMovie();
                    break;
                case "2":
                    EditShowtime();
                    break;
                case "3":
                    EditConfig(); 
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    break;
            } 
            if(exit)    break;
        }
    }

    public void EditMovie() {
        System.out.println("Select type of edition for movie");
        System.out.println("1: Create a new movie");
        System.out.println("2: Update movie details");
        System.out.println("3: Remove a movie");   
        System.out.println("4: List all movies");
        String input = new String();
        input = Main.sc.nextLine();
        switch(input) {
            case "1":
                MainController.movieCtrl.createMovie();
                break;
            case "2":
                MainController.movieCtrl.updateMovie();
                break;
            case "3":
                MainController.movieCtrl.removeMovie();
                break;
            case "4":
                MainController.movieCtrl.listMovies();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    public void EditShowtime() {
        System.out.println("Select type of edition for movie");
        System.out.println("1: Create a new movie");
        System.out.println("2: Update movie details");
        System.out.println("3: Remove a movie");   
        String input = new String();
        input = Main.sc.next();
        switch(input) {
            case "1":
                createShowtime();
                break;
            case "2":
                updateShowtime();
                break;
            case "3":
                removeShowtime();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    public void createShowtime() {

    }

    public void updateShowtime() {

    }

    public void removeShowtime() {

    }
    public void EditConfig() {
        
    }
}
