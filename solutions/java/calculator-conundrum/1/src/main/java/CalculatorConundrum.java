class CalculatorConundrum {
    /**
     * Executes the arithmetic operation and returns a formatted result.
     * Implements a fail-fast strategy and exception wrapping for domain integrity.
     */
    public String calculate(int operand1, int operand2, String operation) {
        validateInputs(operation);

        try {
            int result = switch (operation) {
                case "+" -> operand1 + operand2;
                case "*" -> operand1 * operand2;
                case "/" -> {
                    try {
                        yield operand1 / operand2;
                    } catch (ArithmeticException e) {
                        // Wrapping low-level JVM exception into domain-specific exception
                        throw new IllegalOperationException("Division by zero is not allowed", e);
                    }
                }
                default -> throw new IllegalOperationException(
                    String.format("Operation '%s' does not exist", operation)
                );
            };

            return String.format("%d %s %d = %d", operand1, operation, operand2, result);
        } catch (IllegalOperationException e) {
            // Rethrowing the domain-specific exception to be handled by the caller
            throw e;
        }
    }

    /**
     * Validates that the operation token is not null or empty.
     */
    private void validateInputs(String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }
    }
}