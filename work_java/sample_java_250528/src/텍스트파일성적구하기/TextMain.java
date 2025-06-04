package 텍스트파일성적구하기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

// 텍스트 파일의 10명의 정보를 공백 기준으로 미리 입력 (이름 국어 영어 수학)
// 파일을 읽어 총점을 구하고 총점이 높은 사람 순으로 이름과 총점 출력
public class TextMain {
    public static void main(String[] args) {
        FileInputStream fis = null;
        TreeSet<Student> set = new TreeSet<>();
        try {
            fis = new FileInputStream("sample_java_250528/src/텍스트파일성적구하기/score.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        Scanner sc = new Scanner(fis);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            set.add(new Student(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3])));
        }
        for (Student st : set) {
            System.out.println("이름 : " + st.getName());
        }

    }
}

class Student implements Comparable<Student> {
    public String name;
    private int score;
    private int kor;
    private int eng;
    private int mat;

    public Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public int getTotal() {
        return kor + eng + mat;
    }

    @Override
    public int compareTo(Student o) {
        if (this.getTotal() < o.getTotal()) {
            return 1;
        } else if (this.getTotal() > o.getTotal()) {
            return -1;
        } else {
            return this.name.compareTo(o.name);
        }
    }

    public String getName() {
        return name;
    }
}