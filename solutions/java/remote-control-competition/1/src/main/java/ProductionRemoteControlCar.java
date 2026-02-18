import java.util.Objects;

public class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private int distanceTravelled;
    private int numberOfVictories;

    @Override
    public void drive() {
        this.distanceTravelled += 10;
    }

    @Override
    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar other) {
        // Compare for descending order (higher victories come first)
        return Integer.compare(other.getNumberOfVictories(), this.numberOfVictories);
    }
}