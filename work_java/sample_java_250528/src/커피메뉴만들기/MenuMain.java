package 커피메뉴만들기;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// CRUD


public class MenuMain {
    static Map<String, MenuInfo> map = new HashMap<>();

    public static void main(String[] args) {
        makeMenu(); // 클래스 메서드 이므로 앞에 MenuMain. 이 필요없음
        selectMenu();

    }

    static void makeMenu() { // 객체를 만들지 않아도 됨
        map.put("Americano", new MenuInfo("Americano", 2000, "coffee", "기본커피"));
        map.put("Espresso", new MenuInfo("Espresso", 2000, "coffee", "진한커피"));
        map.put("Latte", new MenuInfo("Latte", 4500, "coffee", "우유커피"));

    }

    static void selectMenu() {
        Scanner sc = new Scanner(System.in);
        String key;
        while (true) {
            System.out.println("메뉴를 선택하세요 : ");
            System.out.println("[1]메뉴 보기 [2]메뉴 조회 [3]메뉴 추가 [4]메뉴 삭제 [5]메뉴 수정 [6]종료");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("=".repeat(10) + "메뉴 보기" + "=".repeat(10));
                    for (String k : map.keySet()) { // 향상된 for문으로 순회를 하기 위해서 key 기준 순회
                        System.out.println("메뉴 : " + map.get(k).getName());
                        System.out.println("가격 : " + map.get(k).getPrice());
                        System.out.println("분류 : " + map.get(k).getCategory());
                        System.out.println("설명 : " + map.get(k).getDesc());
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.print("조회 할 메뉴를 입력하세요 : ");
                    key = sc.next();
                    if (map.containsKey(key)) { // key의 포함 여부 확인
                        System.out.println("메뉴 : " + map.get(key).getName());
                        System.out.println("가격 : " + map.get(key).getPrice());
                        System.out.println("분류 : " + map.get(key).getCategory());
                        System.out.println("설명 : " + map.get(key).getDesc());
                        System.out.println();
                    } else {
                        System.out.println("해당 메뉴가 존재하지 않습니다.");
                    }
                    break;

                case 3:
                    System.out.print("추가 할 메뉴를 입력하세요 : ");
                    key = sc.next();
                    if (!map.containsKey(key)) {
                        System.out.print("가격 입력 : ");
                        int price = sc.nextInt();
                        System.out.print("분류 입력 : ");
                        String cate = sc.next();
                        System.out.print("설명 입력 : ");
                        String desc = sc.next();
                        System.out.println();
                        map.put(key, new MenuInfo(key, price, cate, desc));
                    } else {
                        System.out.println("해당 메뉴가 이미 존재합니다.");
                    }
                    break;

                case 4:  // remove(key)
                    System.out.print("삭제 할 메뉴를 입력하세요 : ");
                    key = sc.next();
                    if (map.containsKey(key)) {
                        map.remove(key);
                        System.out.println(key + "메뉴를 삭제 하였습니다.");
                    } else {
                        System.out.println("삭제 할 메뉴가 없습니다.");
                    }
                    break;

                case 5: // replace() 해당 키가 존재해야 함
                    System.out.print("수정 할 메뉴를 입력하세요 : ");
                    key = sc.next();
                    if(map.containsKey(key)) {
                        System.out.print("가격 입력 : ");
                        int price = sc.nextInt();
                        System.out.print("분류 입력 : ");
                        String cate = sc.next();
                        System.out.print("설명 입력 : ");
                        String desc = sc.next();
                        map.replace(key, new MenuInfo(key, price, cate, desc));
                    } else {
                        System.out.println("수정 할 메뉴가 없습니다.");
                    }
                    break;

                case 6:
                    System.out.println("메뉴를 종료합니다.");
                    return;
            }
        }
    }
}