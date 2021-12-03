package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.Map;
import java.util.function.IntBinaryOperator;

import static hexlet.code.Engine.ROUNDS;

public final class Calc {

    private static final String DESCRIPTION = "What is the result of the expression?";

    private static final Map<String, IntBinaryOperator> OPERATIONS = Map.of(
            "+", Math::addExact,
            "-", Math::subtractExact,
            "*", Math::multiplyExact
    );

    public static void run() {
        final String[][] questionsToAnswers = new String[ROUNDS][];
        for (int i = 0; i < ROUNDS; i++) {
            final int firstNumber = Utils.generateRandom(Utils.MAX);
            final int secondNumber = Utils.generateRandom(Utils.MAX);
            final var operation = getRandomOperation();

            final String question = firstNumber + " " + operation.getKey() + " " + secondNumber;
            final String answer = buildAnswer(firstNumber, operation.getValue(), secondNumber);
            questionsToAnswers[i] = new String[]{question, answer};
        }

        Engine.runGame(DESCRIPTION, questionsToAnswers);
    }

    private static Map.Entry<String, IntBinaryOperator> getRandomOperation() {
        final int operationIndex = Utils.generateRandom(OPERATIONS.size() - 1);
        return OPERATIONS.entrySet().stream().toList().get(operationIndex);
    }

    private static String buildAnswer(final int firstNumber,
                                   final IntBinaryOperator operation,
                                   final int secondNumber) {

        return String.valueOf(operation.applyAsInt(firstNumber, secondNumber));
    }
}
