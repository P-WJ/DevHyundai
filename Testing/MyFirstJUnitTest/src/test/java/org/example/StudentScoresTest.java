package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentScoresTest {

    @Test
    void testIsEmpty() {
        StudentScores studentScores = new StudentScores();
        assertTrue(studentScores.isEmpty());
        assertEquals(0, studentScores.getScoreCount());
    }

    @Test
    void testAddScore() {
        StudentScores studentScores = new StudentScores();
        studentScores.addScore(30);

        assertFalse(studentScores.isEmpty()); // 비어있지 않고
        assertEquals(1, studentScores.getScoreCount()); // 개수가 1이 되는
    }

    @Test
    void testEqual() {
        StudentScores studentScores1 = new StudentScores();
        studentScores1.addScore(30);
        studentScores1.addScore(40);

        Integer[] arr = studentScores1.getScoresAsArray();
        assertEquals(2, arr.length);
        assertEquals(30, arr[0]);
        assertEquals(40, arr[1]);
    }

}