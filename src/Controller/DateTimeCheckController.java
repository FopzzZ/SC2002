package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateTimeCheckController {

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
