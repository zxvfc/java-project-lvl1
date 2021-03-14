package hexlet.code.games;

public final class Gcd extends Game {

    private final String question;
    private final String correctAnswer;

    public Gcd() {

        final int firstNumber = getRandomNumber();
        final int secondNumber = getRandomNumber();

        question = firstNumber + " " + secondNumber;
        correctAnswer = String.valueOf(gcd(firstNumber, secondNumber));
    }

    public static String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    private int gcd(final int firstNumber, final int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }
        return gcd(secondNumber, firstNumber % secondNumber);
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
