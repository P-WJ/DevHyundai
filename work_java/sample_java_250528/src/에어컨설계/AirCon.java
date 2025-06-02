package 에어컨설계;
import java.util.Calendar;

public class AirCon {
    protected boolean isPower;
    protected int setTemp;
    protected int currTemp;
    protected int windStep;

    public AirCon() {
        int[] monthTemp = {-5, 3, 10, 15, 22, 28, 32, 30, 24, 16, 8, 4};
        int month = Calendar.getInstance().get(Calendar.MONTH);
        this.currTemp = monthTemp[month];
        this.setTemp = 24;
        this.windStep = 1;
        this.isPower = false;
    }

    public void powerOn() {
        isPower = true;
        System.out.println("전원이 켜졌습니다.");
    }

    public void powerOff() {
        isPower = false;
        System.out.println("전원이 꺼졌습니다.");
    }

    public void setTemp(int temp) {
        this.setTemp = temp;
    }

    public void setWindStep(int step) {
        if (step >= 1 && step <= 3) this.windStep = step;
    }

    public void displayStatus() {
        System.out.println("==== 에어컨 상태 ====");
        System.out.println("전원: " + (isPower ? "ON" : "OFF"));
        System.out.println("현재 온도: " + currTemp);
        System.out.println("설정 온도: " + setTemp);
        System.out.println("바람 세기: " + windStep + "단계");
    }

    public int getCurrTemp() { return currTemp; }
    public int getSetTemp() { return setTemp; }
    public boolean isPowerOn() { return isPower; }
    public int getWindStep() { return windStep; }

    public void simulateTemperatureChange() {
        if (setTemp < currTemp) currTemp--;
        else if (setTemp > currTemp) currTemp++;
    }
}