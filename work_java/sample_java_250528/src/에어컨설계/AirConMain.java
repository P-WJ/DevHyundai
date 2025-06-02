package 에어컨설계;

import java.util.Scanner;

public class AirConMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("에어컨 종류 선택 (1: 기본 / 2: 스마트 / 3: 휴대용): ");
        int type = sc.nextInt();
        AirCon ac = null;  //

        switch (type) {
            case 1:
                ac = new AirCon();
                ac.powerOn();
                System.out.print("설정 온도 입력 : ");
                ac.setTemp(sc.nextInt());
                System.out.print("바람 세기 입력(1~3) : ");
                ac.setWindStep(sc.nextInt());
                break;
            case 2:
                ac = new SmartAirCon();
                ac.powerOn();
                System.out.print("스마트 에어컨 자동 모드 설정 (true / false) : ");
                boolean auto = sc.nextBoolean();
                if(!auto) {
                    System.out.print("설정 온도 입력 : ");
                    ac.setTemp(sc.nextInt());
                    System.out.print("바람 세기 입력(1~3) : ");
                    ac.setWindStep(sc.nextInt());
                }
                break;
            case 3:
                ac = new PortableAirCon();
                ac.powerOn();
                System.out.print("설정 온도 입력: ");
                ac.setTemp(sc.nextInt());
                System.out.print("바람 세기 입력 (1~3): ");
                ac.setWindStep(sc.nextInt());
                break;
        }
        int elapsed = 0;
        boolean changed = false;

        while (ac.isPowerOn()) {
            Thread.sleep(1000);
            elapsed++;

            int threshold = 60;
            switch (ac.getWindStep()) {
                case 1:
                    threshold = 60;
                    break;
                case 2:
                    threshold = 30;
                    break;
                case 3:
                    threshold = 20;
                    break;
                default:
                    System.out.println("잘못된 바람 세기 설정. 기본값 60초 적용");
            }

            if (elapsed >= threshold) {
                changed = true;
                elapsed = 0;
            }

            if (changed) {
                ac.simulateTemperatureChange();
                ac.displayStatus();
                if (ac instanceof PortableAirCon) {
                    ((PortableAirCon) ac).displayBattery();
                }
                changed = false;
            }

            if (ac.getCurrTemp() == ac.getSetTemp()) {
                System.out.println("✅ 설정 온도 도달. 에어컨 종료.");
                ac.powerOff();
            }
        }

    }
}
