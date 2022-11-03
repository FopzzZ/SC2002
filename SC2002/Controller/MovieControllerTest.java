package SC2002.Controller;

public class MovieControllerTest {
    public static void main(String[] args) {
        MovieController c = new MovieController();
        c.addMovie("Test1");
        while(true){
            c.updateMovie();
            c.showDetail("Test1");
        }
    }
}
