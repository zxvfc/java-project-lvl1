package hexlet.code.games;

public final class GameData {

    private final String question;

    private final String correctAnswer;

    public GameData(final String quest, final String expectedAnswer) {
        this.question = quest;
        this.correctAnswer = expectedAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
