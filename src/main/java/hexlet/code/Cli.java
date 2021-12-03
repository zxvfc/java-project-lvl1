package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greetings() {
        System.out.print("May I have your name? ");
        final String name = new Scanner(System.in).nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
