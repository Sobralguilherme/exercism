public class ExperimentalRemoteControlCar implements RemoteControlCar {
    private int distanceTravelled;

    @Override
    public void drive() {
        this.distanceTravelled += 20;
    }

    @Override
    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }
}