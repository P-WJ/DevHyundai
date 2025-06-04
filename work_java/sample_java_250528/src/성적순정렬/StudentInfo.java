package 성적순정렬;


public class StudentInfo implements Comparable<StudentInfo> {
    public String name;
    public int score;

    public StudentInfo(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(StudentInfo o) {
        if(this.score == o.score) {
            return 0;
        } else if (this.score > o.score) {
            return -1;  //정렬 x
        } else {
            return 1;   // 정렬
        }
    }
}
