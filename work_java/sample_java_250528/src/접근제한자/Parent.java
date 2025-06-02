package 접근제한자;

public class Parent {
    protected String name;    // protected : 자신의 패키지나 상속관계가 있으면 접근 가능
    String money;       // defalt : 자신의 패키지 내에서만 접근 가능
    public String addr; // public : 모든 패키지 접근 가능
                        // private : 같은 클래스 내에서 접근 가능
    public Parent() {
        name = "이건희";
        money = "100억";
        addr = "서울시 강남구 삼성동";
    }

    public String getName() {
        return name;
    }
}
