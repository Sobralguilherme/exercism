public class LogLine {
    private final String logLine;
    
    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
       // Extract the level string (e.g., "INF" from "[INF]: Message")
        String levelPart = logLine.substring(1, 4);
        
        return switch (levelPart) {
            case "TRC" -> LogLevel.TRACE;
            case "DBG" -> LogLevel.DEBUG;
            case "INF" -> LogLevel.INFO;
            case "WRN" -> LogLevel.WARNING;
            case "ERR" -> LogLevel.ERROR;
            case "FTL" -> LogLevel.FATAL;
            default    -> LogLevel.UNKNOWN;
        };
    }

    public String getOutputForShortLog() {
       // Get the integer code from the enum
        int code = getLogLevel().getCode();
        
        // Extract the message (everything after the first ": ")
        String message = logLine.split(": ", 2)[1];

        return code + ":" + message;
    }
}
