package Arrays클래스;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// 배열을 다루기 위한 다양한 메소드 포함
public class ArraysMain {
    // 과일의 이름의 길이 순으로 정렬하고 길이가 같은 경우 사전순으로 정렬하기
    public static void main(String[] args) {
        String[] fruits = {"Kiwi", "Orange", "Apple", "Banana", "Melon",
                "Mango", "Watermelon", "Cherry", "Plum", "Peach"};
        Arrays.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) return 1; // 양수는 정렬 조건이 됨
                else {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2); // 사전순 정렬
                    }
                    return -1; // 음수면 현 상태 유지
                }
            }
        });
        System.out.println(Arrays.toString(fruits));
    }
}