package hexlet.code.games;

public final class Even extends Game {

    private final String correctAnswer;
    private final String question;

    public Even() {
        final int number = getRandomNumber();

        question = String.valueOf(number);
        correctAnswer = correctAnswerFor(number);
    }

    public static String getDescription() {
        return "Answer 'yes' if number even otherwise answer 'no'.";
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    private static String correctAnswerFor(final int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }
}
