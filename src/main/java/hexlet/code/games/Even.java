package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Utils.MAX;
import static hexlet.code.Utils.generateRandom;

public final class Even {

    private static final String DESCRIPTION = "Answer 'yes' if number even otherwise answer 'no'.";

    public static void run() {
        final String[][] questionsToAnswers = new String[ROUNDS][];
        for (int i = 0; i < ROUNDS; i++) {
            final int number = generateRandom(MAX);
            final String question = String.valueOf(number);
            final String answer = isEven(number) ? "yes" : "no";
            questionsToAnswers[i] = new String[]{question, answer};
        }
        Engine.runGame(DESCRIPTION, questionsToAnswers);
    }

    private static boolean isEven(final int number) {
        return number % 2 == 0;
    }
}
