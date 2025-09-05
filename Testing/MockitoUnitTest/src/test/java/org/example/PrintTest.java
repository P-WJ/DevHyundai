package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PrintTest {
    @Spy
    Print print = new Print();

    @Test
    void return9999() {
        System.out.println(print.getX());
        when(print.getX()).thenReturn(9999);
        assertThat(print.getX()).isEqualTo(9999);
    }
}