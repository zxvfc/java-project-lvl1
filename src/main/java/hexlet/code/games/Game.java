package hexlet.code.games;

import java.util.Random;

public abstract class Game {

    private static final int MIN = 1;
    private static final int MAX = 100;

    public abstract String getQuestion();

    public abstract String getCorrectAnswer();

    final int getRandomNumber() {
        return new Random().nextInt(MAX - MIN) + MIN;
    }
}
