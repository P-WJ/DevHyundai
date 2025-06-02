package Wrapper클래스;

public class WrapperMain {
    public static void main(String[] args) {
        Age age = new Age();
        Age.age = 100;
    }

    static class Age {
        static int age;
    }
}
