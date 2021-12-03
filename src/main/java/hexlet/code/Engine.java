package hexlet.code;

import java.util.Objects;
import java.util.Scanner;

public class Engine {

    public static final int ROUNDS = 3;
    private static final String FAILED_MESSAGE_TEMPLATE = """
                '%s' is wrong answer ;(. Correct answer was '%s'.
                Let's try again, %s!
                """;

    public static void runGame(final String gameDescription, final String[][] questionsToAnswers) {
        System.out.print("May I have your name? ");
        final String name = new Scanner(System.in).nextLine();
        System.out.println("Hello, " + name + "!");

        System.out.println(gameDescription);

        for (final String[] questionToAnswer : questionsToAnswers) {

            final String question = questionToAnswer[0];
            System.out.println("Question: " + question);

            System.out.print("Your answer: ");
            final String userAnswer = new Scanner(System.in).nextLine();

            final String correctAnswer = questionToAnswer[1];
            if (!Objects.equals(userAnswer, correctAnswer)) {
                System.out.printf((FAILED_MESSAGE_TEMPLATE) + "%n", userAnswer, correctAnswer, name);
                return;
            }

            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + name + "!");
    }

}
