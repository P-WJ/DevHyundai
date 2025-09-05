package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

public class Return10000Test {
    @Mock
    ArrayList<Integer> mock;
    @Test
    void asdf() {
        doReturn(10000).when(mock).size();

        System.out.println("mock.size(): " + mock.size());

        assertEquals(10000, mock.size());
        assertThat(mock.size()).isEqualTo(10000);
    }
}
