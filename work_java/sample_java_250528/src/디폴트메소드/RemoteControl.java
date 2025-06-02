package 디폴트메소드;
// 필드 : 모든 필드는 자동으로 final static으로 변환
public interface RemoteControl {
    int MAX_VOLUME = 100; // 인터페이스 생성시 한번 생성되고 변경 불가
    int MIN_VOLUME = 0;
    void turnON();  // public abstract 가 자동 추가
    void turnOFF();
    void setVolume(int volume);

    // 디폴트 메서드 : jdk 8 에서 추가
    default void setMute(boolean mute) {
        if (mute) {
            System.out.println("무음 처리 합니다.");
        } else {
            System.out.println("무음 해제 합니다.");
        }
    }
    static void changeBattery() {
        System.out.println("건전지를 교환합니다.");
    }
}
