class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int distanceDriven = 0;
    private int battery = 100;
    
    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
       return battery < batteryDrain;
    }

    public int distanceDriven() {
       return distanceDriven;
    }

    public void drive() {
        if (!batteryDrained()){
            this.distanceDriven += speed;
            this.battery -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
    public int getSpeed() { return speed; }
    public int getBatteryDrain(){ return batteryDrain; }
}

class RaceTrack {
    private int Distance;
    
    RaceTrack(int Distance) {
        this.Distance = Distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        // Calculation: (100 / drain) gives total charges/drives possible
        // Total distance = charges * speed
        int totalPossibleDrives = 100 / car.getBatteryDrain(); 
        int totalPossibleDistance = totalPossibleDrives * car.getSpeed();

         return totalPossibleDistance >= this.Distance;   
    }
}
