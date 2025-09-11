import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalTest {
    @Test
    void testMinusBigToSmall() {
        assertEquals(2, new Cal().cal_minus(4, 2));
        assertEquals(3, new Cal().cal_minus(5, 2));
    }

    @Test
    void testMinusSmallToBig() {
        assertEquals(2, new Cal().cal_minus(2, 4));
        assertEquals(3, new Cal().cal_minus(2, 5));
    }
    @Test
    // 메서드_when_then() {}
    void sum_twoValues_returnMinus() {
    }

    @Test
    // 영어 읽히는대로
    void shouldTwoValuesReturnZero() {
    }
}
