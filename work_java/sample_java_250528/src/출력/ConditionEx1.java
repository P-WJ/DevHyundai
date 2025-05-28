package 출력;

import java.util.Scanner;

public class ConditionEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("시간 분 : ");
        int H = sc.nextInt();
        int M = sc.nextInt();
        int calc = H * 60 + M; // 분으로 환산
        if (calc < 45) {
            calc = 24 * 60 + M;
        }
        calc -= 45;
        System.out.println((calc / 60) + " " + (calc % 60));

    }
}