package org.example;

public class Main {
    public static void main(String[] args) {
        Cal cal = new Cal();

        // 더하기 테스트
        int resultSum = cal.add(10, 20);
        if(resultSum == 30) {
            System.out.println("더하기 테스트 통과했다!!");
        } else {
            System.out.println("더하기 테스트 실패!! 왜지???");
        }
    }
}
