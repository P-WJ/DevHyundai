package 예외처리;

// try { 예외가 발생할 가능성이 있거나, 반드시 예외처리를 해야하는 부분 }
// catch { 예외 상황에 대한 처리 }
// finally { 예외이던 아니던 모두 수행되는 구문 }

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptMain {
    public static void main(String[] args) {
//        int[] arr = new int[5];
//        try {
//            for (int i = 0; i <= 5; i++) {
//                arr[i] = i;
//                System.out.println(arr[i]);
//            }
//        } catch (ArrayIndexOutOfBoundsException e ) {
//            System.out.println("인덱스 에러");
//        }
//        System.out.println("프로그램 정상 종료");
        try {
            BufferedReader br = new BufferedReader(new FileReader("없는 파일"));
        } catch (FileNotFoundException e) {

        }
    }
}
