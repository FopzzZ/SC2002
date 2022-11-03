package Controller;

import java.util.Scanner;

public class InputController {
    private static Scanner sc = new Scanner(System.in);

    public static String getStringFromUser() {
        String input = "";
        while (input.equals("")) {
            input = sc.nextLine();
            if (input.equals("")) {
                System.out.println("Cannot be empty, try again!");
            }
        }
        return input;
    }

    public static String getYesOrNoFromUser() {
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            input = sc.nextLine();
            if (input == "Y" || input == "N") {
                validInput = true;
            } else {
                System.out.println("Must be either Y or N");
            }
        }
        return input;
    }
}