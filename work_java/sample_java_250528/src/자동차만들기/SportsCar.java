package 자동차만들기;

public class SportsCar extends Car implements Music, AutoDrive{
    public SportsCar() {
        super(250, 8, 30, 2, "포르쉐 911");
    }

    @Override
    public void setMode(boolean isOn) {
        if(isOn) {
            this.speed *= 1.2;
        }

    }

    @Override
    public void MusicOn(boolean on) {
        if (on) {
            System.out.println(this.name + "오디오 ON");
        }
    }

    @Override
    public void AutoDriveOn(boolean on) {
        if (on) {
            System.out.println(this.name + "자율주행 ON");
        }
    }
}
