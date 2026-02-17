class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder sb = new StringBuilder();
        boolean shouldConvertNextToUpper = false;

        for (int i = 0; i < identifier.length(); i++) {
            char ch = identifier.charAt(i);

            if (ch == ' ') {
                sb.append('_');
            } 

            else if (ch == '-') {
                shouldConvertNextToUpper = true;
            } 
            
            else if (Character.isDigit(ch)) {
                sb.append(convertLeet(ch));
            } 
            
            else if (Character.isLetter(ch)) {
                if (shouldConvertNextToUpper) {
                    sb.append(Character.toUpperCase(ch));
                    shouldConvertNextToUpper = false;
                } else {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    private static char convertLeet(char ch) {
        return switch (ch) {
            case '4' -> 'a';
            case '3' -> 'e';
            case '0' -> 'o';
            case '1' -> 'l';
            case '7' -> 't';
            default -> ch; 
        };
    }
}