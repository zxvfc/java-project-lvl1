package hexlet.code;

import hexlet.code.games.Game;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Engine {

    private static final int ROUNDS_TO_WIN = 3;

    public static void runGame(final Callable<Game> constructor,
                               final String description) throws Exception {
        final String name = Cli.greetings();
        System.out.println(description);

        for (int round = 0; round < ROUNDS_TO_WIN; round++) {

            final Game instance = constructor.call();

            System.out.println("Question: " + instance.getQuestion());
            final String correctAnswer = instance.getCorrectAnswer();

            System.out.print("Your answer: ");
            final String userAnswer = new Scanner(System.in).nextLine();

            if (!isAnsweredCorrect(userAnswer, correctAnswer)) {
                printFailedMessages(name, userAnswer, correctAnswer);
                return;
            }

            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + name + "!");
    }

    private static boolean isAnsweredCorrect(final String userAnswer,
                                             final String correctAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer);
    }

    private static void printFailedMessages(final String name,
                                            final String userAnswer,
                                            final String correctAnswer) {
        final String message = """
                '%s' is wrong answer ;(. Correct answer was '%s'.
                Let's try again, %s!
                """.formatted(userAnswer, correctAnswer, name);

        System.out.println(message);
    }
}
