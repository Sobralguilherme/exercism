public class Secrets {

    /**
     * Shifts bits to the right, ensuring 0s are inserted from the left.
     * We use the unsigned right shift operator (>>>).
     */
    public static int shiftBack(int value, int amount) {
        return value >>> amount;
    }

    /**
     * Sets bits to 1 based on a mask.
     * The bitwise OR (|) ensures that if a bit is 1 in the mask, it becomes 1 in the result.
     */
    public static int setBits(int value, int mask) {
        return value | mask;
    }

    /**
     * Flips bits based on a mask.
     * The bitwise XOR (^) flips the bit if the mask bit is 1, and leaves it alone if 0.
     */
    public static int flipBits(int value, int mask) {
        return value ^ mask;
    }

    /**
     * Resets bits to 0 based on a mask.
     * We use the bitwise NOT (~) on the mask to target the 0s, then AND (&) it with the value.
     */
    public static int clearBits(int value, int mask) {
        return value & ~mask;
    }
}