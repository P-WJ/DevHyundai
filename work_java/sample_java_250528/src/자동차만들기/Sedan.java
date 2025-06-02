package 자동차만들기;

public class Sedan extends Car implements Music, Aircon{
    public Sedan() {
        super(200, 12, 45, 4, "소나타");
    }

    @Override
    public void setMode(boolean isOn) {
        if (isOn) {
            this.seats += 1;
        }
    }

    @Override
    public void MusicOn(boolean on) {
        if (on) {
            System.out.println(this.name + " : 오디오 ON");
        }
    }

    @Override
    public void AirconisOn(boolean on) {
        if (on) {
            System.out.println(this.name + " : 에어컨 ON");
        }
    }
}
