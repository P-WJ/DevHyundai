package 자동차만들기;

public abstract class Car {
    public double speed;
    public int fuelEff;
    public int fuelSize;
    public int seats;
    public String name;
    abstract void setMode(boolean isOn);

    public Car(double speed, int fuelEff, int fuelSize, int seats, String name) {
        this.speed = speed;
        this.fuelEff = fuelEff;
        this.fuelSize = fuelSize;
        this.seats = seats;
        this.name = name;
    }

    // 총 이동 횟수 계산 (승객 수 / 좌석 수)
    public int totalMoveCount(int passengers) {
        return (int) Math.ceil((double) passengers / seats);
    }

    public int totalDistance(int distance, int MoveCount) {
        return distance * MoveCount;
    }

    // 총 연료 소모량
    public double totalFuelConsumption(int distance, int count) {
        return (double) distance / fuelEff * count;
    }

    // 총 주유 횟수 계산
    public int totalRefuels(double fuelConsumption) {
        return (int) Math.ceil((Double) fuelConsumption / fuelSize);
    }

    // 총 비용 계산
    public int totalCost(double fuelConsumption ) {
        return (int) fuelConsumption * 2000;
    }

    // 총 시간 계산
    public double totalTime(double distance, int count, double weather) {
        return distance / speed * count * weather;
    }

}
