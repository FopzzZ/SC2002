package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * Controller to check if given date of birth is valid
 */
public class DoBCheckController {

    /**
     * Check if dob provided is valid and in the correct format
     * 
     * @param date dob to be checked
     * @return boolean whether dob provided is valid and in correct format
     */
    public static boolean isValid(final String date) {

        boolean valid = false;

        try {

            // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
            LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("d/M/uuuu")
                            .withResolverStyle(ResolverStyle.STRICT));

            valid = true;

        } catch (DateTimeParseException e) {
            // e.printStackTrace();
            valid = false;
        }

        return valid;
    }
}
