package 컴페어레이터;

import java.util.TreeSet;

public class CompMain {
    public static void main(String[] args) {
        TreeSet<CarComp> set = new TreeSet<>();
        set.add(new CarComp("코나", 2022, "흰색"));  // add할때 compareTo 동작
        set.add(new CarComp("스포티지", 2022, "흰색"));
        set.add(new CarComp("싼타페", 2018, "회색"));
        set.add(new CarComp("그랜저", 2016, "블랙"));
        set.add(new CarComp("GV80", 2023, "블랙"));
        set.add(new CarComp("GV80", 2023, "흰색"));   // 컬러 조건 설정하지 않아 빠져버림


        for (CarComp car : set) {
            System.out.println(car.name + " : " + car.year + " " + car.color);
        }
    }
}
