package 열거클래스;
// 열거 타입 : 한정된 상수 집합을 정의하는 참조 타입
public class EnumMain {
    public static void main(String[] args) {
        Developer developer = new Developer("장원영", DevType.FRONTEND, Career.JUNIOR, Gender.MALE);
        developer.devInfo();
    }
}
