package 어레이리스트2;

import java.util.ArrayList;
import java.util.List;

public class ArrayMain2 {
    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu("Americano", 2000, "Coffee", "그냥 커피", true));
        menuList.add(new Menu("Latte", 4500, "Coffee", "우유 커피", true));
        menuList.add(new Menu("Moca", 5500, "Coffee", "달달한 커피", true));

        for (Menu menu : menuList) {
            System.out.println(menu);
        }
    }
}
