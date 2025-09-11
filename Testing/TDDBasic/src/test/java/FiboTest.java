import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiboTest {
    @Test
    void testFibo() {
        int [][] cases = {{0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}};

        for (int i = 0; i < cases.length; i++) {
            int order = cases[i][0]; // 입력값
            int expected = cases[i][1]; // 기대 반환값
            assertEquals(expected, new Fibo().fibo(order));
        }
    }

    @Test
    // Todo: 재귀함수 안 쓰고 for문으로 새로운 모듈 TDD로 만들기
    void testFiboWithIteration() {
        // {입력값, 기대 반환값}
        int [][] cases = {{0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}};

        for (int i = 0; i < cases.length; i++) {
            int order = cases[i][0]; // 입력값
            int expected = cases[i][1]; // 기대 반환값
            assertEquals(expected, new Fibo().fiboWithFor(order));
        }
    }
}
