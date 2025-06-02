package 자동차만들기;

import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        String[] regions = {"부산", "대전", "강릉", "광주"};
        int[] distances = {400, 150, 200, 300};

        Scanner sc = new Scanner(System.in);
        System.out.print("이동 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주 : ");
        int regionIdx = sc.nextInt() - 1;
        String region = regions[regionIdx];
        int distance = distances[regionIdx];

        System.out.print("이동할 승객 수 입력 : ");
        int passengers = sc.nextInt();

        System.out.print("이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ");
        int carType = sc.nextInt();

        System.out.print("부가 기능 [1]ON [2]OFF : ");
        int setMode = sc.nextInt();

        System.out.print("날씨 [1]맑음 [2]비 [3]눈 : ");
        int weather = sc.nextInt();
        double tmp = 0;
        if (weather == 1) {
            tmp = 1.0;
        } else if (weather == 2) {
             tmp = 1.2;
        } else if (weather == 3) {
             tmp = 1.4;
        }

        Car car = null;
        if (carType == 1) {
            car = new SportsCar();

            ((SportsCar) car).MusicOn(true);
            ((SportsCar) car).AutoDriveOn(true);


        } else if (carType == 2) {
            car = new Sedan();
            ((Sedan) car).MusicOn(true);
            ((Sedan) car).AirconisOn(true);

        } else if (carType == 3) {
            car = new Bus();
            ((Bus) car).AirconisOn(true);
            ((Bus) car).AutoDriveOn(true);
        }

        if (setMode == 1) {
            car.setMode(true);
        }

        System.out.println("총 비용 : " + car.totalCost(car.totalFuelConsumption(distance, car.totalMoveCount(passengers))) + "원");
        System.out.println("총 주유 횟수 : " + car.totalRefuels(car.totalFuelConsumption(distance, car.totalMoveCount(passengers))) + "회");
        double time = car.totalTime(distance, car.totalMoveCount(passengers), tmp);
        int hour = (int) time;
        int minute = (int) ((time - hour) * 60);
        System.out.println("총 이동 시간 : " + hour + "시간" + minute + "분");
    }
}
