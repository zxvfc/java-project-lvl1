package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS;

public final class Gcd {

    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void run() {
        final String[][] questionsToAnswers = new String[ROUNDS][];
        for (int i = 0; i < ROUNDS; i++) {
            final int firstNumber = Utils.generateRandom(Utils.MAX);
            final int secondNumber = Utils.generateRandom(Utils.MAX);

            final String question = firstNumber + " " + secondNumber;
            final String answer = String.valueOf(findGcd(firstNumber, secondNumber));
            questionsToAnswers[i] = new String[]{question, answer};
        }
        Engine.runGame(DESCRIPTION, questionsToAnswers);
    }

    private static int findGcd(final int firstNumber, final int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }
        return findGcd(secondNumber, firstNumber % secondNumber);
    }
}
