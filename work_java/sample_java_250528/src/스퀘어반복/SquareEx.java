package 스퀘어반복;

import java.util.Scanner;

public class SquareEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num = sc.nextInt();
//        for (int i = 1; i <= num * num; i++) {
//            System.out.printf("%4d", i);
//            if (i % num == 0) {
//                System.out.println();
//        for (int i = 0; i <= num; i++) {
//            if (i % 2 == 0) {
//                continue;
//            }
//            System.out.print(i + " ");
//        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}