package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static final int GREETINGS = 1;
    private static final int EVEN = 2;

    private static final int CORRECT_ANSWERS_LIMIT = 3;

    public static void menu() {
        println("Please enter the game number and press Enter.");
        println("1 - Greet\n2 - Even\n0 - Exit");
        print("Your choice: ");

        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case GREETINGS -> greetings();
            case EVEN -> even();
            default -> println("Buy!");
        }
    }

    private static void greetings() {
        String name = askName();
        sayHello(name);
    }

    private static void sayHello(final String name) {
        println("Hello, " + name + "!");
    }

    private static void even() {
        String name = askName();
        sayHello(name);
        println("Answer 'yes' if number even otherwise answer 'no'.");

        final int[] numbersToCheck = {0, 1, 2};

        int correctAnswers = 0;
        for (int number : numbersToCheck) {

            println("Question: " + number);
            print("Your answer: ");
            String answer = new Scanner(System.in).nextLine();

            if (isAnsweredCorrect(answer, number)) {
                correctAnswers++;
                println("Correct!");
            } else {
                String message = String.format(
                        "'%s' is wrong answer ;(. Correct answer was '%s'.",
                        answer,
                        correctAnswerFor(number)
                );
                println(message);
                break;
            }
        }

        if (correctAnswers == CORRECT_ANSWERS_LIMIT) {
            println("Congratulations, " + name + "!");
        } else {
            println("Let's try again, " + name + "!");
        }
    }

    private static boolean isAnsweredCorrect(
            final String answer,
            final int number
    ) {
        return correctAnswerFor(number).equalsIgnoreCase(answer);
    }

    private static String correctAnswerFor(final int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }

    private static String askName() {
        print("May I have your name? ");
        return new Scanner(System.in).nextLine();
    }

    private static void println(final String s) {
        System.out.println(s);
    }

    private static void print(final String s) {
        System.out.print(s);
    }
}
