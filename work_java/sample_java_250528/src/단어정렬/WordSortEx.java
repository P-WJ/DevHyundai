package 단어정렬;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordSortEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2); // 길이가 같으면 사전 순 정렬
                }
                return o1.length() - o2.length(); // 길이 순으로 정렬
            }
        });
        for (int i = 0; i <n; i++) {
            set.add(sc.nextLine().trim());
        }
        sc.close();

        for (String e : set) System.out.println(e);
    }
}
