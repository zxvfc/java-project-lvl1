package hexlet.code.games;

public final class Gcd extends Game {

    @Override
    public String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public GameData generateData() {
        final int firstNumber = getRandomNumber();
        final int secondNumber = getRandomNumber();

        final String question = firstNumber + " " + secondNumber;
        final String answer = getCorrectAnswer(firstNumber, secondNumber);

        return new GameData(question, answer);
    }

    private String getCorrectAnswer(final int firstNumber,
                                    final int secondNumber) {
        return String.valueOf(gcd(firstNumber, secondNumber));
    }

    private int gcd(final int firstNumber, final int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }
        return gcd(secondNumber, firstNumber % secondNumber);
    }
}
