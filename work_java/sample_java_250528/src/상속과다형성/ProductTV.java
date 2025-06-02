package 상속과다형성;
// 상속 : 부모 클래스의 필드 메서드를 자식 클래스가 물려 받는 것
// 자식클래스가 만들어지려면 부모 클래스가 있어야함, 자식의 생성자를 만들기위해, 부모의 생성자가 불려야함
// 부모 클래스에서 생성자가 기본 생성자라면, 자식의 생성자는 숨어있음
// super() -> 부모 호출, this() -> 자식 호출

public class ProductTV extends ProtoType {
    String name;
    boolean isInternet; // 인터넷 기능

    public ProductTV(boolean isPower, int cnl, int vol, boolean isInternet) { // 부모에게 상속된 자식 클래스
        super(isPower, cnl, vol); // 부모 생성자 호출
        this.isInternet = isInternet; // 부모에게서 상속된 것 이외에 추가된 기능
        name = "LG";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int vol) {
        if (vol >= 0 && vol <= 100) {
            volume = vol;
            System.out.println("볼륨을 " + volume + " 으로 변경했습니다.");
        } else {
            System.out.println("볼륨 설정 범위가 아닙니다.");
        }
    }

    @Override   // 오버라이딩 관계 성립 여부를 문법적으로 체크해주는 어노테이션, (없어도 됨)
    public void setChannel(int cnl) {   // (오버라이딩, 동적 바인딩)
        if (cnl > 0 && cnl < 2000) {
            channel = cnl;
            System.out.println("채널을 " + channel + " 으로 변경했습니다.");
        } else {
            System.out.println("채널 설정 범위가 아닙니다.");
        }
    }

    // 메서드 오버로딩 : 매개변수의 개수와 타입으로 구분하는 것
    public void setChannel(int cnl, boolean isInternet) {
        if (isInternet) {
            System.out.println("인터넷 모드 입니다.");
            this.isInternet = true;
        } else {
            this.isInternet = false;
            if (cnl > 0 && cnl < 2000) {
                channel = cnl;
                System.out.println("채널을 " + channel + " 으로 변경했습니다.");
            } else {
                System.out.println("채널 설정 범위가 아닙니다.");
            }
        }
    }

    void viewTV() {
        System.out.println("이름 : " + name);
        System.out.println("전원 : " + isPower);
        System.out.println("채널 : " + channel);
        System.out.println("볼륨 : " + volume);
        System.out.println("인터넷모드 : " + isInternet);
    }
}

