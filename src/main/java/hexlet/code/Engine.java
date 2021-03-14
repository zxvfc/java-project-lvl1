package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.games.GameData;
import java.util.Scanner;

public class Engine {

    private static final int ROUNDS_TO_WIN = 3;

    public static void runGame(final Game game) {
        final String name = Cli.greetings();
        System.out.println(game.getDescription());

        for (int round = 0; round < ROUNDS_TO_WIN; round++) {

            final GameData gameData = game.generateData();

            System.out.println("Question: " + gameData.getQuestion());
            final String correctAnswer = gameData.getCorrectAnswer();

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
