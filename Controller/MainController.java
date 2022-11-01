package SC2002.Controller;

import SC2002.Main;
import SC2002.AdminSystem.Admin;

public class MainController {
    public static MovieController movieCtrl;
    public static boolean isHoliday;
    Admin adminSystem;
    public MainController() {
        initMainController();
    }

    private void initMainController() {
        initMovieController();
        initAdminSystem();
    }

    private void initMovieController() {
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
