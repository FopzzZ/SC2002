package SC2002.Controller;

import SC2002.Main;
import SC2002.Component.Movie.*;

public class MovieController {
    public static Movie[] movieList;
    public static int numOfMovies;
    public MovieController() {
        movieList = new Movie[1001];
        numOfMovies = 0;
    }
    public void createMovie() {
        System.out.println("Enter the new movie's title: ");
        String s = Main.sc.nextLine();
        movieList[++numOfMovies] = new Movie();
        movieList[numOfMovies].setTitle(s);
        System.out.printf("Have created new movie <%s>.\n", s);
    }

    private int searchWithTitle(String title) {
        for(int i = 1; i <= numOfMovies; ++i) {
            if(movieList[i].getTitle().equals(title)) 
                return i;
        }
        return -1;
    }

    public void updateMovie() {
        System.out.println("Enter the title of the movie you want to edit: ");
        String s = Main.sc.nextLine();
        int index = searchWithTitle(s);
        if(index == -1) {
            System.out.println("No such movie");
            return;
        }
        System.out.println("Enter the attribute you want to edit");
        System.out.println("1: Title");
        System.out.println("2: Statu(Coming Soon/Preview/Now Showing/End of Showing)");
        System.out.println("3: Type(Blockbuster/3D)");
        System.out.println("4: Director");
        System.out.println("5: Synopsis");
        System.out.println("6: Add Cast");
        String input = Main.sc.nextLine();
        System.out.println("Enter the value: ");
        String content = Main.sc.nextLine();
        switch(input) {
            case "1": movieList[index].setTitle(content); break;
            case "2": 
                switch(content) {
                    case "Coming Soon": movieList[index].setStatu(movieStatu.Coming);break;
                    case "Preview": movieList[index].setStatu(movieStatu.Preview);break;
                    case "Now Showing": movieList[index].setStatu(movieStatu.Showing);break;
                    case "End of Showing": remove(index);break;
                    default:
                        break;
                } break;
            case "3":   
                switch(content) {
                    case "Blockbuster": movieList[index].setType(movieType.Blockbuster); break;
                    case "3D": movieList[index].setType(movieType.threeD); break;
                    default:
                        break;
                } break;
            case "4": movieList[index].setDirector(content);
            case "5": movieList[index].setSynopsis(content);
            case "6": movieList[index].addCast(content);
            default:
                System.out.println("Invalid input.");
                break;
        }
    }

    public void removeMovie() {
        System.out.println("Enter the title of movie you want to remove: ");
        String s = Main.sc.nextLine();
        int index = searchWithTitle(s);
        if(index == -1) {
            System.out.println("No such movie");
            return;
        }
        remove(index);
        System.out.printf("Successfully removed the movie <%s>.\n", s);
    }

    public void listMovies() {
        for(int i = 1; i <= numOfMovies; ++i) {
            System.out.printf("Movie%d: %s\n", i, movieList[i].getTitle());
        }
        System.out.printf("Totally %d movies.", numOfMovies);
    }

    public void showDetail(String title) {
        int index = searchWithTitle(title);
        if(index != -1)
            movieList[index].showDetail();
        else 
            System.out.println("No such movie.");
    }
    
    private void remove(int index) {
        for(int i = index; i <= numOfMovies - 1; ++i)
            movieList[i] = movieList[i + 1];
    }
}
