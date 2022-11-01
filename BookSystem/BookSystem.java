package SC2002.BookSystem;

import SC2002.Main;
import SC2002.AdminSystem.Admin;
import SC2002.Controller.MovieController;

public class BookSystem {
    public static MovieController movieCtrl;
    public static boolean isHoliday;
    Admin adminSystem;
    public BookSystem() {
        initBookSystem();
    }

    private void initBookSystem() {
        initMovieList();
        initAdminSystem();
    }

    private void initMovieList() {
        movieCtrl = new MovieController();
        // initialize movie list from movie.txt
    }
    
    private void initAdminSystem() {
        adminSystem = new Admin();
    }

    public void Work() {
        while(true) {
            System.out.println("Are you guest? (Y/N)");
            String input = new String();
            input = Main.sc.nextLine();
            if(input.equals("Y")) {
                //customerSystem.Work();
                break;
            } else if(input.equals("N")){
                adminSystem.Work();
                break;
            }
        }
    }
}
