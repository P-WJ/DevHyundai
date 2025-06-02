package 싱글톤;

public class SingletonMain {
    public static void main(String[] args) {
    Student student1 = new Student();
    Student student2 = new Student();
    student1.setInfo("안유진", 23);
    student2.viewInfo();
    }
}
