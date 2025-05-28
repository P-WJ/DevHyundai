package 회원정보예제;

import java.util.Scanner;

public class Member {
    private final Scanner sc = new Scanner(System.in);
    private String name;
    private int age;
    private char gender;
    private int job;
    // 생성자는 상략하면 기본생성자가 숨어있음

    public void setName() {
        System.out.print("이름 입력 : ");
        name = sc.nextLine(); // name에 this가 숨어있음
    }

    public void setAge() {
        while (true) {
            System.out.print("나이 입력 : ");
            age = sc.nextInt();
            if (age >= 0 && age <= 200) return;
        }
    }

    public void setGender() {
        while (true) {
            System.out.print("성별 입력 : ");
            gender = sc.next().charAt(0);
            switch (gender) {
                case 'M':
                case 'm':
                case 'F':
                case 'f':
                    return;
            }
        }
    }

    public int getGenderType() {
        if (gender == 'm' || gender == 'M') return 1;
        return 2;
    }

    public void setJob() {
        while (true) {
            System.out.print("직업 입력 : ");
            job = sc.nextInt();
            if (job > 0 && job < 5) return;
        }
    }

    public void getMember() {
        final String[] genderStr = {"", "남성", "여성"};
        final String[] jobStr = {"", "학생", "회사원", "주부", "무직"};
        System.out.println("=".repeat(8) + "회원 정보" + "=".repeat(8));
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("성별 : " + genderStr[getGenderType()]);
        System.out.println("직업 : " + jobStr[job]);

    }
}