package hexlet.code.games;

import java.util.Random;

public abstract class Game {

    private static final int MAX = 100;

    public abstract String getDescription();

    public abstract GameData generateData();

    final int getRandomNumber() {
        return new Random().nextInt(MAX);
    }
}
