public class LogLevels {
    
    public static String message(String logLine) {
       int colonIndex = logLine.indexOf(":");
       String message = logLine.substring(colonIndex + 1).trim();
       return message;
    }

    public static String logLevel(String logLine) {
      int startIndex = logLine.indexOf("[");
      int endIndex = logLine.indexOf("]");
      String level = logLine.substring(startIndex + 1, endIndex).toLowerCase();
      return level;
}

    public static String reformat(String logLine) {
       String messagePart = message(logLine);
       String levelPart = logLevel(logLine);
       return messagePart + " (" + levelPart + ")";
    }
}
