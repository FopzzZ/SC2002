package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * Controller to verify date time
 */
public class DateTimeCheckController {

    /**
     * Checks if a given string is in a valid date time format
     * 
     * @param date string to be checked
     * @return boolean whether the string is in a valid date time format
     */
    public static boolean isValid(final String date) {

        boolean valid = false;

        try {
            LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("uuuuMMddHHmm")
                            .withResolverStyle(ResolverStyle.STRICT));
            valid = true;
        } catch (DateTimeParseException e) {
            // e.printStackTrace();
            valid = false;
        }
        return valid;
    }
}
