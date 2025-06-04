package Set인터페이스;

import java.util.HashSet;
import java.util.Objects;

public class SetMain {
    public static void main(String[] args) {
//        HashSet<String> set = new HashSet<>();
//        set.add("곰돌이");
//        set.add("안유진");
//        set.add("정상기");
//        set.add("장원영");
//        set.add(new String("정상기")); // HashCode(), equals() 둘 다 오버라이딩 되어있음
//         객체는 다르지만 String 클래스는 내용이 같으면 hashCode도 같게 나오도록 오버라이딩 되어있음.

//        for (String e : set) {
//            System.out.println(e);
//        }
        HashSet<Member> set = new HashSet<>();
        set.add(new Member(1001, "유나"));
        set.add(new Member(1002, "채원"));
        set.add(new Member(1002, "지수"));
        set.add(new Member(1003, "카리나"));

        for (Member e : set) {
            System.out.println(e);
        }
    }
}

class Member {
    int id;
    String name;

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            Member member = (Member) obj;
            if (this.id == member.id) return true;
            else return false;
        }
        return false;
    }

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "아이디 : " + id + "\n" + "이름 : " + name + "\n";
    }

}