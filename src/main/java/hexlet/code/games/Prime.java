package hexlet.code.games;

public final class Prime extends Game {

    private static final int MIN_PRIME = 2;

    @Override
    public String getDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public GameData generateData() {
        final int number = getRandomNumber();

        final String question = String.valueOf(number);
        final String answer = isPrime(number) ? "yes" : "no";
        return new GameData(question, answer);
    }

    private boolean isPrime(final int number) {
        if (number < MIN_PRIME) {
            return false;
        }
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
