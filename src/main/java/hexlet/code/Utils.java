package hexlet.code;

import java.util.Random;

public class Utils {

    public static final int MAX = 100;

    public static int generateRandom(final int max) {
        return generateRandom(0, max);
    }

    public static int generateRandom(final int min, final int max) {
        return min + new Random().nextInt(max - min);
    }
}
