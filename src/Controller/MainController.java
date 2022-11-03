package Controller;

import Main;
import AdminSystem.AdminSystem;

public class MainController {
    public static MovieController movieCtrl;
    public static boolean isHoliday;
    AdminSystem adminSystem;

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
        adminSystem = new AdminSystem();
    }

    public void Work() {
        while (true) {
            System.out.println("Are you customer? (Y/N)");
            String input = new String();
            input = Main.sc.nextLine();
            if (input.equals("Y")) {
                // customerSystem.Work();
                break;
            } else if (input.equals("N")) {
                adminSystem.Work();
                break;
            }
        }
    }
}
