package Controller;

import java.util.regex.Pattern;

public class DoBCheckController {

  public static boolean isValid(String dateOfBirth) {
    String doBRegex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";

    Pattern doBPattern = Pattern.compile(doBRegex);
    if (dateOfBirth == null)
      return false;
    return doBPattern.matcher(dateOfBirth).matches();

  }
}
