public class Twofer {
    /**
     * Returns a string following the "One for X, one for me" pattern.
     * Uses direct concatenation for optimal performance as per modern Java standards.
     *
     * @param name The name of the person; if null or blank, "you" is used.
     * @return A formatted two-fer string.
     */
    public String twofer(String name) {
        // Resolve the recipient name with a safe fallback
        String recipient = (name == null || name.isBlank()) ? "you" : name;

        // Use direct concatenation (+) for maximum efficiency
        return "One for " + recipient + ", one for me.";
    }
}