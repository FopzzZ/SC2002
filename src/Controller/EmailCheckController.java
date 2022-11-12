package Controller;

import java.util.regex.Pattern;
import java.util.*;

/**
 * Controller to check if email is valid
 */
public class EmailCheckController {

    /**
     * Check if provided email is in a valid format
     * 
     * @param email email to be checked
     * @return boolean whether email is valid
     */
    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return emailPattern.matcher(email).matches();
    }
}
