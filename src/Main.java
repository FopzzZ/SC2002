package src;
import java.util.Scanner;

import src.Controller.MainController;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        MainController system = new MainController();
        system.Work();
    }
}
