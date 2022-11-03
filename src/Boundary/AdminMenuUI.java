package Boundary;

import Controller.*;

import java.util.*;

public class AdminMenuUI{
    public void main(){
        boolean loggedIn = true; //think of some way to implement
        while (loggedIn) {
            System.out.println("|Admin Menu|" +
                    "1. Search/List movies\n" +
                    "2. View movie details\n" +
                    "3. Modify movie listing\n"+
                    "4. Modify movie session\n"+
                    "3. Configure system settings\n" +
                    "6. Log out\n");
            System.out.print("Select action: ");
            switch(InputController.getIntFromUser()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    loggedIn = false;
                    System.out.println("Logged out successfully!");
                    break;
                default:
                    break;
            }
        }
    }   
}
