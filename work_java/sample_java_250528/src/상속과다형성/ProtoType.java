package 상속과다형성;

public class ProtoType {
    boolean isPower; // 전원 ON/OFF
    int channel;
    int volume;

    public ProtoType(boolean isPower, int cnl, int vol) {
        this.isPower = isPower; // this로 인스턴스를 가리킴
        channel = cnl; // 변수명이 다르기때문에 this 생략
        volume = vol;
    }

    // setter 역할 : 내부의 인스턴스 값이 정해진 범위에서 설정되도록 해야 함
    public void setChannel(int cnl) {
        if (cnl > 0 && cnl < 1000) { // 1 ~ 999
            channel = cnl;
        } else {
            System.out.println("채널 설정 범위가 아닙니다.");
        }
    }

    public void setPower(boolean power) {
        isPower = power;
    }
}