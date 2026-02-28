class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        // Converting to string is a quick way to find the number of digits
        String numberString = String.valueOf(numberToCheck);
        int numDigits = numberString.length();
        
        int sum = 0;
        int temp = numberToCheck;

        while (temp > 0) {
            // Get the last digit
            int digit = temp % 10;
            
            // Add (digit^numDigits) to sum
            // Note: Math.pow returns a double, so we cast it to int
            sum += Math.pow(digit, numDigits);
            
            // Remove the last digit
            temp /= 10;
        }

        return sum == numberToCheck;
    }
}