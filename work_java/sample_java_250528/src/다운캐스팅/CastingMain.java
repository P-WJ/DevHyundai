package 다운캐스팅;

import java.util.ArrayList;

public class CastingMain {
    ArrayList<Animal> aniList = new ArrayList<>();
    public static void main(String[] args) {
        CastingMain downCasting = new CastingMain();
        downCasting.addAnimal();
        downCasting.testCasting();
    }

    public void addAnimal() {
        aniList.add(new Animal());
        aniList.add(new Human());
        aniList.add(new Tiger());
        aniList.add(new Eagle());

        for (Animal ani: aniList) {
            ani.move();
        }
    }
    public void testCasting() {
        for (int i = 0; i < aniList.size(); i++) {
            Animal ani = aniList.get(i);  // 해당 인덱스의 요소 추출, 업캐스팅
            if (ani instanceof Human) {
                Human h = (Human) ani;
                h.readBook();
            } else if (ani instanceof Tiger) {
                Tiger t = (Tiger) ani;
                t.hunting();
            } else if (ani instanceof Eagle) {
                Eagle e = (Eagle) ani;
                e.flying();
            } else {
                System.out.println("지원되지 않는 형 입니다.");
            }
        }
    }
}
