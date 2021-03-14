package hexlet.code.games;

public final class Calc extends Game {

    private static final char[] OPERATIONS = {'+', '-', '*'};

    private final String question;
    private final String correctAnswer;

    public Calc() {
        final int firstNumber = getRandomNumber();
        final int secondNumber = getRandomNumber();
        final int operationIndex = getRandomNumber() % OPERATIONS.length;
        final char operation = OPERATIONS[operationIndex];

        question = "%s %c %s".formatted(firstNumber,
                                        operation,
                                        secondNumber
        );
        correctAnswer = correctAnswerFor(firstNumber, operation, secondNumber);
    }

    public static String getDescription() {
        return "What is the result of the expression?";
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    private String correctAnswerFor(final int firstNumber,
                                    final char operation,
                                    final int secondNumber) {
        return String.valueOf(evaluate(firstNumber,
                                       operation,
                                       secondNumber
        ));
    }

    private int evaluate(final int firstNumber,
                         final char operation,
                         final int secondNumber) {
        return switch (operation) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            default -> throw new IllegalStateException(
                    "Unexpected value: " + operation
            );
        };
    }
}
