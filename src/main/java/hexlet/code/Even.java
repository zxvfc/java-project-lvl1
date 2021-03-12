package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {

    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int CORRECT_ANSWERS_LIMIT = 3;

    public static void game() {
        final String name = Cli.greetings();
        println("Answer 'yes' if number even otherwise answer 'no'.");

        final int[] numbersToCheck = new Random()
                .ints(MIN, MAX)
                .limit(CORRECT_ANSWERS_LIMIT)
                .toArray();

        int correctAnswers = 0;
        for (int number : numbersToCheck) {

            println("Question: " + number);
            System.out.print("Your answer: ");
            String answer = new Scanner(System.in).nextLine();

            if (isAnsweredCorrect(answer, number)) {
                correctAnswers++;
                println("Correct!");
            } else {
                String message = buildMessageForWrongAnswer(answer, number);
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

    private static String buildMessageForWrongAnswer(
            final String answer,
            final int number
    ) {
        return String.format(
                "'%s' is wrong answer ;(. Correct answer was '%s'.",
                answer,
                correctAnswerFor(number)
        );
    }

    private static String correctAnswerFor(final int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }

    private static void println(final String s) {
        System.out.println(s);
    }
}
