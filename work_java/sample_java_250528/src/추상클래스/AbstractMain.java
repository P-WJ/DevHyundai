package 추상클래스;

public class AbstractMain {
    public static void main(String[] args) {
        // 부모 클래스의 참조 변수에 자식 객체를 대입
        Phone smartPhone = new SmartPhone("iPhone 16 Pro");
        smartPhone.setPower(true);
        smartPhone.call();
        ((SmartPhone)smartPhone).internet();
        }
}
