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

    public static int getIntFromUser() {
        int input = -1;
        boolean validInput = false;
        while (!validInput) {
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input! Please try again.");
            }
            sc.nextLine();
        }
        return input;
    }

    public static int getIntFromUser(int start, int end) {
        int input = getIntFromUser();
        while (input < start || input > end) {
            System.out.println("Please enter a number from " + start + " to " + end);
            input = getIntFromUser();
        }
        return input;
    }

    public static boolean getYesOrNoFromUser() { // Y or N to boolean
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            input = sc.nextLine();
            if (input.equals("Y") || input.equals("N")) {
                validInput = true;
            } else {
                System.out.println("Must be either Y or N");
            }
        }
        if (input.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public static String getEmailFromUser() {
        String pattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; // TODO change regex
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            input = getStringFromUser();
            if (input.matches(pattern)) {
                validInput = true;
            } else {
                System.out.println("Please enter a valid email!");
            }
        }
        return input;
    }

    public static String getTimeFromUser() { // TODO make more specific so accepts valid time
        String pattern = "[\\d]{12}";
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            input = getStringFromUser();
            if (input.matches(pattern)) {
                validInput = true;
            } else {
                System.out.println("Please enter a valid time!");
            }
        }
        return input;
    }
}
