package hexlet.code.games;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Progression extends Game {

    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 5;

    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;

    private static final String HIDE_SYMBOL = "..";
    private static final String DELIMITER = " ";

    @Override
    public String getDescription() {
        return "What number is missing in the progression?";
    }

    @Override
    public GameData generateData() {
        final List<String> sequence = generateSequence();

        final int hiddenPosition = getRandomNumber() % sequence.size();

        final String answer = sequence.get(hiddenPosition);
        sequence.set(hiddenPosition, HIDE_SYMBOL);
        final String question = String.join(DELIMITER, sequence);

        return new GameData(question, answer);
    }

    private List<String> generateSequence() {
        final int baseNumber = getRandomNumber();
        final int step = getRandomNumber() % MAX_STEP + MIN_STEP;
        final int length = getRandomNumber() % MAX_LENGTH + MIN_LENGTH;

        return IntStream.iterate(baseNumber, number -> number + step)
                        .limit(length)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.toList());
    }
}
