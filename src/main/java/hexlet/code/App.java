package hexlet.code;

import hexlet.code.games.Even;
import java.util.Scanner;

public class App {

    private static final int GREETINGS = 1;
    private static final int EVEN = 2;

    public static void main(final String[] args) throws Exception {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n0 - Exit");
        System.out.print("Your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case GREETINGS -> Cli.greetings();
            case EVEN -> Engine.runGame(Even::new, Even.getDescription());
            default -> {
            }
        }
    }
}
