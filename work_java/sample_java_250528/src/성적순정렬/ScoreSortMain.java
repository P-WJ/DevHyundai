package 성적순정렬;

import java.util.Iterator;
import java.util.TreeSet;

public class ScoreSortMain {
    public static void main(String[] args) {
        TreeSet<StudentInfo> info = new TreeSet<>();
        info.add(new StudentInfo("우영우", 95));
        info.add(new StudentInfo("동그라미", 65));
        info.add(new StudentInfo("이준호", 77));
        info.add(new StudentInfo("최수연", 88));
        info.add(new StudentInfo("정명석", 97));

        Iterator<StudentInfo> iterator = info.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next().name + " ");
        }
    }
}
