package SC2002;
import java.util.Scanner;

import SC2002.BookSystem.BookSystem;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BookSystem system = new BookSystem();
        system.Work();
    }
}
