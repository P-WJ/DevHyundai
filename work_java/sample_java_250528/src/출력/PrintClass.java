package 출력;
// 자바는 표준 입출력 클래스를 사용해서 콘솔의 입력과 출력을 담당
// System.in : 표준 입력
// System.out : 표준 출력
// System.err : 오류 출력
// 서식 지정자 : %d, %ld, %f, %.2f, %2d, %s, %c , %%
// 이스케이프시퀀스 : \n, \r, \t, \b, \\

public class PrintClass {
    public static void main(String[] args) {
        String name = "장원영"; // 리터럴 상수, name->stack, "장원영"->static
        String addr = "서울시 금천구 가산동";
        char gender = 'M';
        int age = 26;
        int kor = 98, eng = 88, mat = 88;
        double avg = 0.0;

        // 자바 스타일 : print(), println()
        System.out.println("=".repeat(8) + "Java Style" + "=".repeat(8));
        System.out.println("이름 : " + name);
        System.out.println("주소 : " + addr );
        System.out.println("성별 : " + (gender == 'M' ? "남성":"여성"));
        System.out.println("나이 : " + age);
        System.out.println("총점 : " + (kor + eng + mat));
        System.out.println("평균 : " + (double)(kor + eng + mat)/3);
        System.out.printf("평균 : %.2f\n", (double)(kor + eng + mat)/3);
    }
}
