package 자동차만들기;

public class Bus extends Car implements Aircon, AutoDrive{
    public Bus() {
        super(150, 5, 100, 20, "고속버스");
    }

    @Override
    public void setMode(boolean isOn) {
        if (isOn) {
            this.fuelSize += 30;
        }
    }

    @Override
    public void AirconisOn(boolean on) {
        if (on) {
            System.out.println(this.name + " : 에어컨 ON");
        }
    }

    @Override
    public void AutoDriveOn(boolean on) {
        if (on) {
            System.out.println(this.name + " : 자율주행 ON");
        }
    }
}
