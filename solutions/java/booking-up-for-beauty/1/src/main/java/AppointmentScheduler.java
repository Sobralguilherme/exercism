import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class AppointmentScheduler {

    // Defined as constants to avoid re-parsing the pattern on every method call
    private static final DateTimeFormatter INPUT_FORMATTER = 
        DateTimeFormatter.ofPattern("M/d/yyyy HH:mm:ss");

    private static final DateTimeFormatter DESCRIPTION_FORMATTER = 
        DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, 'at' h:mm a", Locale.ENGLISH);

    /**
     * Parses a date string into a LocalDateTime object.
     * @param appointmentDateDescription String format "7/25/2019 13:45:00"
     */
    public LocalDateTime schedule(String appointmentDateDescription) {
        return LocalDateTime.parse(appointmentDateDescription, INPUT_FORMATTER);
    }

    /**
     * Checks if the provided appointment date is in the past.
     */
    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    /**
     * Checks if the appointment falls in the afternoon (12:00 PM - 5:59 PM).
     */
    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int hour = appointmentDate.getHour();
        return hour >= 12 && hour < 18;
    }

    /**
     * Returns a human-readable description of the appointment.
     * Example: "You have an appointment on Friday, March 29, 2019, at 3:00 PM."
     */
    public String getDescription(LocalDateTime appointmentDate) {
        String formattedDate = appointmentDate.format(DESCRIPTION_FORMATTER);
        return String.format("You have an appointment on %s.", formattedDate);
    }

    /**
     * Calculates the salon's anniversary date (September 15th) for the current year.
     */
    public LocalDate getAnniversaryDate() {
        return LocalDate.now()
                .withMonth(9)
                .withDayOfMonth(15);
    }
}