package Math클래스;

import java.util.Random;

// 클래스 메소드이므로 객체 생성없이 사용
public class MathMain {
    public static void main(String[] args) {
        // random() 메소드 0.0 이상 1.0 미만의 임의의 실수 생성
        // 1 ~ 45 사이의 임의의 정수 값 생성
        for (int i = 0; i < 6; i++) {
            int val = (int) (Math.random() * 45) + 1;
            System.out.println(val);
        }
    }
}
