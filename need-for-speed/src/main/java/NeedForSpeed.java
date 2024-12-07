class NeedForSpeed {
    final int speed;
    final int batteryDrain;
    int battery = 100;
    int totalDistanceDriven = 0;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return this.battery < this.batteryDrain;
    }

    public void drive() {
        if (!batteryDrained()) {
            this.totalDistanceDriven += this.speed;
            this.battery -= this.batteryDrain;
        }
    }

    public int distanceDriven() {
        return this.totalDistanceDriven;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private final int distance;

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        int maxDistance = car.speed * (car.battery / car.batteryDrain);

        return maxDistance >= this.distance;
    }

    /*
        public boolean canFinishRace(NeedForSpeed car) {
        int battery = car.battery;
        int distanceDriven = 0;

        while (battery >= car.batteryDrain) {
            distanceDriven += car.speed;
            battery -= car.batteryDrain;

            if (distanceDriven >= this.distance) {
                return true;
            }
        }

        return false;
     */
}

