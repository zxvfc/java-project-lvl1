package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String greetings() {
        System.out.print("May I have your name? ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }
}
