// The expected oven time in minutes
const int EXPECTED_MINUTES_IN_OVEN = 40;

// The amount of preparation time per layer in minutes
const int PREPARATION_MINUTES_PER_LAYER = 2;

int ovenTime() {
    // Returns the standard baking time
    return EXPECTED_MINUTES_IN_OVEN;
}

int remainingOvenTime(int actualMinutesInOven) {
    // Subtracts the time already spent from the expected time
    return ovenTime() - actualMinutesInOven;
}

int preparationTime(int numberOfLayers) {
    // Multiplies layers by the prep time per layer
    return numberOfLayers * PREPARATION_MINUTES_PER_LAYER;
}

int elapsedTime(int numberOfLayers, int actualMinutesInOven) {
    // The sum of preparation time and the time already spent in the oven
    return preparationTime(numberOfLayers) + actualMinutesInOven;
}