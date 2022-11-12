package Controller;

import java.util.Scanner;

/**
 * Controller for getting input from user and checking if its valid
 */
public class InputController {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Gets a string from user
     * 
     * @return String string entered by user
     */
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

    /**
     * Gets an int from user
     * 
     * @return int int entered by user
     */
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

    /**
     * Gets an int from a specified range from user
     * 
     * @param start start of range (inclusive)
     * @param end   end of range (inclusive)
     * @return int int entered by user
     */
    public static int getIntFromUser(int start, int end) {
        int input = getIntFromUser();
        while (input < start || input > end) {
            System.out.println("Please enter a number from " + start + " to " + end);
            input = getIntFromUser();
        }
        return input;
    }

    /**
     * Gets Y or N from user
     * 
     * @return boolean Y is 1 N is 0
     */
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

    /**
     * Gets email from user
     * 
     * @return String email entered by user
     */
    public static String getEmailFromUser() {
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            input = getStringFromUser();
            if (EmailCheckController.isValid(input)) {
                validInput = true;
            } else {
                System.out.println("Please enter a valid email!");
            }
        }
        return input;
    }

    /**
     * Gets a time from suer
     * 
     * @return String time in a specific format
     */
    public static String getTimeFromUser() {
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            input = getStringFromUser();
            if (DateTimeCheckController.isValid(input)) {
                validInput = true;
            } else {
                System.out.println("Please enter a valid date and time (YYYYMMddHHmm)");
            }
        }
        return input;
    }

    /**
     * Gets mobile number from user
     * 
     * @return String mobile number entered by user
     */
    public static String getMobileNumberFromUser() {
        String pattern = "[\\d]{8}"; // 8 digit mobile number
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            input = getStringFromUser();
            if (input.matches(pattern)) {
                validInput = true;
            } else {
                System.out.println("Please enter a valid mobile number!");
            }
        }
        return input;
    }

    /**
     * Gets a capital letter from user
     * 
     * @return char letter entered by user
     */
    public static char getCapitalLetterFromUser() { // A-Z
        String pattern = "[A-Z]{1}";
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            input = getStringFromUser();
            if (input.matches(pattern)) {
                validInput = true;
            } else {
                System.out.println("Please enter a valid character!");
            }
        }
        return input.charAt(0);
    }

    /**
     * Gets dob from user
     * 
     * @return String dob entered by user
     */
    public static String getDateOfBirthFromUser() {
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            input = getStringFromUser();
            if (DoBCheckController.isValid(input)) {
                validInput = true;
            } else {
                System.out.println("Please enter a valid date of birth!");
            }
        }
        return input;
    }

    /**
     * Gets a double from user
     * 
     * @return double double entered by user
     */
    public static double getDoubleFromUser() { // should work
        String pattern = "[-]?[0-9]+[.]?[0-9]{0,2}?";
        String input = "";
        boolean validInput = false;
        while (!validInput) {
            input = getStringFromUser();
            if (input.matches(pattern)) {
                validInput = true;
            } else {
                System.out.println("Please enter a valid amount!");
            }
        }
        return Double.parseDouble(input);
    }
}
