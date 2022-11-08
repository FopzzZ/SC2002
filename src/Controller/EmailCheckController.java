package Controller;

import java.util.regex.Pattern;
import java.util.*;

public class EmailCheckController {
    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return emailPattern.matcher(email).matches();
    }
    
    public static void main(String[] args) {
        //For testing
        ArrayList<String> emailAddress = new ArrayList<String>();
        
        emailAddress.add("bob@gmail.com");
        emailAddress.add("john@gmail..com");
        emailAddress.add("@gmail.com");
        emailAddress.add("a.b.c@gmail.org");
        emailAddress.add("bryan@hotmail");
        
        for(String address : emailAddress) {
          if(isValid(address)) {
              System.out.println("Valid");
          }
          else {
              System.out.println("Invalid");
          }
        }
      
    }
  
}



