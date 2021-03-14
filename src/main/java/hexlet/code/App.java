package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import java.util.Scanner;

public class App {

    private static final int GREETINGS = 1;
    private static final int EVEN = 2;
    private static final int CALC = 3;
    private static final int GCD = 4;

    public static void main(final String[] args) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n0 - Exit");
        System.out.print("Your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case GREETINGS -> Cli.greetings();
            case EVEN -> Engine.runGame(new Even());
            case CALC -> Engine.runGame(new Calc());
            case GCD -> Engine.runGame(new Gcd());
            default -> {
            }
        }
    }
}
