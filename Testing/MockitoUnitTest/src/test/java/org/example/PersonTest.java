package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonTest {
    @Mock
    Dog dog;

//    @Mock
//    Cat cat;

    @InjectMocks
    Person person;

    @Test
    void test() {
        // doReturn
        when(dog.bark()).thenReturn("몽몽!!");
        assertThat(dog.bark()).isEqualTo("몽몽!!");
        verify(dog, times(1)).bark();

    }
}