package hexlet.code.games;

public final class Even extends Game {

    @Override
    public String getDescription() {
        return "Answer 'yes' if number even otherwise answer 'no'.";
    }

    @Override
    public GameData generateData() {
        final int number = getRandomNumber();
        final String question = String.valueOf(number);
        final String correctAnswer = correctAnswerFor(number);
        return new GameData(question, correctAnswer);
    }

    private static String correctAnswerFor(final int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }
}
