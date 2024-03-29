package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Scanner;

public class App {

    private static final int GREETINGS = 1;
    private static final int EVEN = 2;
    private static final int CALC = 3;
    private static final int GCD = 4;
    private static final int PROGRESSION = 5;
    private static final int PRIME = 6;
    private static final int EXIT = 0;

    private static final String MENU = ""
            + GREETINGS +     " - Greet\n"
            + EVEN +          " - Even\n"
            + CALC +          " - Calc\n"
            + GCD +           " - GCD\n"
            + PROGRESSION +   " - Progression\n"
            + PRIME +         " - Prime\n"
            + EXIT +          " - Exit";

    public static void main(final String[] args) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(MENU);
        System.out.print("Your choice: ");
        final Scanner sc = new Scanner(System.in);
        final int choice = sc.nextInt();

        switch (choice) {
            case GREETINGS -> Cli.greetings();
            case EVEN -> Even.run();
            case CALC -> Calc.run();
            case GCD -> Gcd.run();
            case PROGRESSION -> Progression.run();
            case PRIME -> Prime.run();
            default -> {
            }
        }
    }
}
