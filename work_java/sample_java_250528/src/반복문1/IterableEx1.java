package 반복문1;

import java.util.Scanner;

public class IterableEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int num = sc.nextInt();
        int sum = 0;
//        while (num > 0) {
//            sum += num;
//            num--;
//        }
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
