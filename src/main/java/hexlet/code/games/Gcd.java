package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS;

public final class Gcd {

    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void run() {
        final String[] questions = new String[ROUNDS];
        final String[] answers = new String[ROUNDS];
        for (int i = 0; i < ROUNDS; i++) {
            final int firstNumber = Utils.generateRandom(Utils.MAX);
            final int secondNumber = Utils.generateRandom(Utils.MAX);

            questions[i] = firstNumber + " " + secondNumber;
            answers[i] = String.valueOf(findGcd(firstNumber, secondNumber));
        }
        Engine.runGame(DESCRIPTION, new String[][]{questions, answers});
    }

    private static int findGcd(final int firstNumber, final int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }
        return findGcd(secondNumber, firstNumber % secondNumber);
    }
}
