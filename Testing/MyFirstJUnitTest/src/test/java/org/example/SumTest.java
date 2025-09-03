package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @Test
    void getSum() {
        Sum sum = new Sum();
        int ret = sum.getSum(10, 20);
        assertEquals(30, ret);
    }

    @Test
    void getSum_return_0() {
        Sum sum = new Sum();
        int ret = sum.getSum(-50, 50);
        assertEquals(0, ret);
    }

    @Test
    void getSum_with_minus_ints() {
        // given: 테스트 대상이 "주어지고"
        Sum sum = new Sum();

        // when: 결과를 수행했을 "때"
        int ret = sum.getSum(-50, 50);

        // then: "그렇다면" 어떤 결과가 나와야 하는가.
        assertEquals(0, ret);

        // GWT: Good With Test

    }

    @Test
    @Disabled
    void 에러메세지출력() {
        int actual = 1; // 실제값
        int expected = 2; // 기대값(예상값)
        String message = "기대값과 실제값이 다릅니다."; // 실패 메세지
        assertEquals(expected, actual, message);
    }

    @Test
    void true_test() {
        int ret = 10;
//        assertTrue(ret == 10);
        assertEquals(10, ret); // 같은 값인지 볼 때는 assertEquals()가 가독성이 좋다.
    }

    @Test
    void false_test() {
        int ret = 10;
        assertFalse(ret == 20); // 조건식 또는 결과값이 false 일 때 테스트 통과
    }

    @Test
    void ArrayList_비교() {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr1.add(1);
        arr1.add(2);
        arr2.add(1);
        arr2.add(2);

        assertEquals(arr1, arr2);
    }

    @Test
    void List_비교() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4};

        assertArrayEquals(arr1, arr2);
    }

    @Test
    void loop_test() {
        assertNull(null); // actual이 null일 때만 통과
//        assertNotNull(null); // actual이 null이 아닐 ㄸ만 통과
    }

    @Test
    @Disabled
    void failTest() {
        fail("이 테스트 케이스는 무조건 통과 못 합니다.");
    }

    @Test
    void nullPointException() {
        assertThrows(NullPointerException.class, () -> {
            ArrayList<Integer> arr = null;
            int ret = arr.get(0);
        });
    }

    @Test
    void nullPointExceptionNotThrow() {
        assertDoesNotThrow(() -> {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("아무거나");
            String a = arr.get(0);
            System.out.println("a = " + a);
        });
    }

//    @Test
//    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
//    void long_loop() {
//        int sum = 0;
//        for (int i = 0; i < 10000000; i++) {
//            sum = sum % 10 + i;
//        }
//
//        assertEquals(sum, 10000000);
//    }

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }
}