package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Utils.MAX;
import static hexlet.code.Utils.generateRandom;

public final class Even {

    private static final String DESCRIPTION = "Answer 'yes' if number even otherwise answer 'no'.";

    public static void run() {
        final String[] questions = new String[ROUNDS];
        final String[] answers = new String[ROUNDS];
        for (int i = 0; i < ROUNDS; i++) {
            final int number = generateRandom(MAX);
            questions[i] = String.valueOf(number);
            answers[i] = isEven(number) ? "yes" : "no";
        }
        Engine.runGame(DESCRIPTION, new String[][]{questions, answers});
    }

    private static boolean isEven(final int number) {
        return number % 2 == 0;
    }
}
