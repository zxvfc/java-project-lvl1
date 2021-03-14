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

    int gcd(final int n1, final int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
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
