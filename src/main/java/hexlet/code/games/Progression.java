package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.stream.IntStream;

import static hexlet.code.Engine.ROUNDS;

public final class Progression {

    private static final String DESCRIPTION = "What number is missing in the progression?";

    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 5;

    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;

    private static final String HIDE_SYMBOL = "..";
    private static final String DELIMITER = " ";

    public static void run() {
        final String[][] questionsToAnswers = new String[ROUNDS][];
        for (int i = 0; i < ROUNDS; i++) {
            final int baseNumber = Utils.generateRandom(Utils.MAX);
            final int step = Utils.generateRandom(MIN_STEP, MAX_STEP);
            final int length = Utils.generateRandom(MIN_LENGTH, MAX_LENGTH);

            final String[] sequence = buildSequence(baseNumber, step, length);

            final int hiddenPosition = Utils.generateRandom(sequence.length);
            final String question = buildQuestion(sequence, hiddenPosition);
            final String answer = sequence[hiddenPosition];

            questionsToAnswers[i] = new String[]{question, answer};
        }

        Engine.runGame(DESCRIPTION, questionsToAnswers);
    }

    private static String[] buildSequence(final int baseNumber, final int step, final int length) {
        return IntStream.iterate(baseNumber, number -> number + step)
                .limit(length)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
    }

    private static String buildQuestion(final String[] sequence, final int hiddenPosition) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < sequence.length; i++) {
            result.append(i == hiddenPosition ? HIDE_SYMBOL : sequence[i])
                    .append(DELIMITER);
        }
        return result.toString();
    }

}
