package SC2002;

import java.util.Scanner;

import SC2002.Controller.MainController;

public class Main {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MainController system = new MainController();
        system.Work();
    }
}
