package hexlet.code.games;

public final class Calc extends Game {

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';

    private static final char[] OPERATIONS = {PLUS, MINUS, MULTIPLY};

    @Override
    public String getDescription() {
        return "What is the result of the expression?";
    }

    @Override
    public GameData generateData() {
        final int firstNumber = getRandomNumber();
        final int secondNumber = getRandomNumber();
        final char operation = getOperation();

        final String question = "%s %c %s".formatted(firstNumber,
                                                     operation,
                                                     secondNumber
        );
        final String answer = correctAnswerFor(firstNumber,
                                               operation,
                                               secondNumber);

        return new GameData(question, answer);
    }

    private char getOperation() {
        final int operationIndex = getRandomNumber() % OPERATIONS.length;
        return OPERATIONS[operationIndex];
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
            case PLUS -> firstNumber + secondNumber;
            case MINUS -> firstNumber - secondNumber;
            case MULTIPLY -> firstNumber * secondNumber;
            default -> throw new IllegalStateException(
                    "Unexpected value: " + operation
            );
        };
    }
}
