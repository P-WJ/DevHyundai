package 오브젝트클래스;
// java.lang.Object : 모든 클래스의 최상위 부모 클래스

public class ObjectMain {
    public static void main(String[] args) {
        Student student1 = new Student();
        // 클래스명@16진수 해시코드, 오버라이딩 후 사용하는 경우가 많음
        System.out.println(student1.toString());
        System.out.println(student1);
        
        Student student2 = new Student();
        // equals() : 두 객체가 같은지 비교
        System.out.println(student1.equals(student2));
        student1 = student2;
        System.out.println(student1.equals(student2));
    }
}

class Student extends Object {

}