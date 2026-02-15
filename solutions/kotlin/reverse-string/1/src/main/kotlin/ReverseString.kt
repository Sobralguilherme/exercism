fun reverse(input: String): String {
    // Use the built-in reversed() function on the input
    return input.reversed()
}

// Example usage to test:
fun main() {
    val original = "stressed"
    val result = reverse(original)
    println("Original: $original") // Original: stressed
    println("Reversed: $result")   // Reversed: desserts
}
