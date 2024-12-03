public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double baseRate = speed * 221;
        double efficiencyRate = switch (speed) {
            case 1, 2, 3, 4 -> 1.0;
            case 5, 6, 7, 8 -> 0.9;
            case 9 -> 0.8;
            case 10 -> 0.77;
            default -> 0.0;
        };

        return baseRate * efficiencyRate;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }
}
