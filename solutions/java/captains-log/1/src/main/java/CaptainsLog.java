import java.util.Random;

class CaptainsLog {

    // Extracted constants
    private static final char[] PLANET_CLASSES = {'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};
    
    private static final String SHIP_PREFIX = "NCC-";
    private static final int REGISTRY_MIN = 1000;
    private static final int REGISTRY_MAX = 9999;
    
    private static final double STARDATE_START = 41000.0;
    private static final double STARDATE_END = 42000.0;

    private final Random random;

    /**
     * Dependency Injection via constructor.
     */
    CaptainsLog(Random random) {
        this.random = random;
    }

    /**
     * O(1) complexity. Uses the array length dynamically to prevent 
     * IndexOutOfBounds if the array is updated in the future.
     */
    char randomPlanetClass() {
        return PLANET_CLASSES[random.nextInt(PLANET_CLASSES.length)];
    }

    /**
     * Generates a registry number between 1000 and 9999.
     * Logic: random.nextInt(limit) + offset.
     */
    String randomShipRegistryNumber() {
        int rangeSize = (REGISTRY_MAX - REGISTRY_MIN) + 1;
        int registryNumber = REGISTRY_MIN + random.nextInt(rangeSize);
        return SHIP_PREFIX + registryNumber;
    }

    /**
     * Generates a stardate in the [41000.0, 42000.0) range.
     * Explicit range calculation improves readability for peer reviewers.
     */
    double randomStardate() {
        double range = STARDATE_END - STARDATE_START;
        return STARDATE_START + (range * random.nextDouble());
    }
}