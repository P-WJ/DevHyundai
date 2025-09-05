package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // <- 모키토 사용
class MockitoUnitTestTest {
    @Mock
    ArrayList<String> listMock2;

    @Test
    void getTest() {
        ArrayList<String> listMock = mock(ArrayList.class);
        listMock.add("불금입니다!");

        verify(listMock).add("불금입니다!");
    }

    @Test
    void setTest() {
        listMock2.add("불금입니다!");

        verify(listMock2).add("불금입니다!");
    }

    // Mocking 할 떄 제일 많이 사용되는 두 가지
    // - Stub, Stubbing, 스텁 건다. 행동 정의
    // - Verify, 검증

    @Test
    void 목은실제역할하지않음() {
        listMock2.add("일이삼");

        // 목은 실제 역할 하지 않음
//        System.out.println("listMock2.get(0): " + listMock2.get(0));
    }

    @Test
    void 스터빙테스트() {
        listMock2.add("오육칠");

        // listMock2.get(0) 를 해당 테케에서 행동 정의 이후 호출하지 않으면 fail 난다. (정확히는 익셉션)
        doReturn("안녕하세요.").when(listMock2).get(0); // stubbing, 행동정의

        // lenient: 허술한
        // 행동정의를 허술하게 한다. 그러므로 검증하지 않을 수도 있다.
//        lenient().doReturn("안녕하세요.").when(listMock2).get(0);

        // doReturn(): 내부적으로 정의한 수행문을 호출하지 않는다.
        // thenReturn(): 내부적으로 정의한 수행문을 호출한다.
        when(listMock2.get(2)).thenReturn("반갑습니다.");

        System.out.println("listMock2.get(0): " + listMock2.get(0));
        System.out.println("listMock2.get(2): " + listMock2.get(2));
    }

    @Test
    void 비어있는테스트() {
        // 통과
    }

    @Test
    void 목은어떻게동작될까() {
        listMock2.add("일");
        listMock2.add("이");
        listMock2.add("삼");

        System.out.println(listMock2.get(0));
        System.out.println(listMock2.get(1));
        System.out.println(listMock2.get(2));
        System.out.println(listMock2.size());
    }

    @Test
    void timesTest() {
        listMock2.add("일");
        listMock2.add("이");
        listMock2.add("삼");

        int size1 = listMock2.size();
        int size2 = listMock2.size();
        int size3 = listMock2.size();

        verify(listMock2, times(3)).size();
    }

    @Test
    void 순서확인() { // 단순 순서대로 호출이 되었는지 검증
        listMock2.add("일");
        listMock2.add("이");
        listMock2.add("삼");

        InOrder order = inOrder(listMock2);
        order.verify(listMock2).add("이");
        order.verify(listMock2).add("일");
        order.verify(listMock2).add("삼");
    }

    @Test
    void 순차검사() { // 스텁을 하는데 호출할 때마다 다른 반환값을 셋팅하고 싶을 때
        when(listMock2.add("안녕?"))
                .thenReturn(false)
                .thenReturn(true)
                .thenReturn(false);

        assertThat(listMock2.add("안녕?")).isEqualTo(false);
        assertThat(listMock2.add("안녕?")).isEqualTo(true);
        assertThat(listMock2.add("안녕?")).isEqualTo(false);
    }

    @Test
    void throwTest() {
        doThrow(IllegalStateException.class).when(listMock2).add("일이삼");
//        when(listMock2.add("일이삼")).thenThrow(IllegalStateException.class);

        // JUnit 5
        assertThrows(IllegalStateException.class, () -> {
            listMock2.add("일이삼");
        });

        // AssertJ
        assertThatThrownBy(() -> listMock2.add("일이삼"))
                .isInstanceOf(IllegalStateException.class);
    }

    // Junit 4 방식
//    @Test(expected = IllegalStateException.class) // -> PASS 하도록 셋팅
//    void throwTest2() {
//        doThrow(IllegalStateException.class).when(listMock2).add("일이삼");
//        listMock2.add("일이삼");
//    }

}