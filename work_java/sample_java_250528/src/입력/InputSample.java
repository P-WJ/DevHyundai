package 입력;

import java.util.Scanner;
// 이름, 주소, 성별, 나이를 입력받아 출력하기

public class InputSample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Heap영역에 new로 객체생성, System.in(콘솔입력)
        // new로 만든 객체를 지워야함. 가비지컬렉터가 지워줌(중괄호 끝나면 Scanner가 지워지면서 new객체는 주인이없음, 가비지컬렉터가 주인없는 new객체 분터 지움.
        System.out.print("이름 입력 : ");
        String name = sc.next(); // 공백 기준으로 문자열 입력
        sc.nextLine(); // 입력버퍼 비우기(하지않으면 입력버퍼때문에 주소입력이 넘어가버림)
        System.out.print("주소 입력 : ");
        String addr = sc.nextLine(); // 줄바꿈 문자 기준으로 문자열 입력
        System.out.print("성별 입력 : ");
        char gender = sc.next().charAt(0);
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();

        System.out.println("==== 회원 정보 출력 =====");
        System.out.println("이름 : " + name);
        System.out.println("주소 : " + addr);
        System.out.println("성별 : " + gender);
        System.out.println("나이 : " + age);
    }
}
