package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class SpyTest {
    @Spy
    ArrayList<String> listSpy = new ArrayList<>();

    @Test
    void 테스트1() {
        listSpy.add("일");
        listSpy.add("이");
        listSpy.add("삼");

        System.out.println("listSpy.get(0): " + listSpy.get(0));
        System.out.println("listSpy.size(): " + listSpy.size());
    }
}
