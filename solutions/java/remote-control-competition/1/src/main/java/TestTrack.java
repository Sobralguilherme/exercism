import java.util.List;
import java.util.Collections;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }
    
    // Sorts the list of production cars using the Comparable implementation
    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        Collections.sort(cars);
        return cars;
    }
}