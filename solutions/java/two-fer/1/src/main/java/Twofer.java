public class Twofer {
    /**
     * Returns a string following the "One for X, one for me" pattern.
     *
     * @param name The name of the person; if null or blank, "you" is used.
     * @return A formatted two-fer string.
     */
    public String twofer(String name) {
        // Use .isBlank() for a more efficient and modern check (Java 11+)
        String recipient = (name == null || name.isBlank()) ? "you" : name;
        
        return String.format("One for %s, one for me.", recipient);
    }
}