package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS;

public final class Prime {

    private static final int MIN_PRIME = 2;
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void run() {
        final String[][] questionsToAnswers = new String[ROUNDS][];
        for (int i = 0; i < ROUNDS; i++) {
            final int number = Utils.generateRandom(Utils.MAX);
            final String question = String.valueOf(number);
            final String answer = isPrime(number) ? "yes" : "no";
            questionsToAnswers[i] = new String[]{question, answer};
        }
        Engine.runGame(DESCRIPTION, questionsToAnswers);
    }

    private static boolean isPrime(final int number) {
        if (number < MIN_PRIME) {
            return false;
        }
        for (int i = MIN_PRIME; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
