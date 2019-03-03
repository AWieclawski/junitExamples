package com.infoshareacademy.junit.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    public void shouldReturnTrueIfNumberInRange() {

        // given
        Range range = new Range(10, 20);
        // when
        boolean result = range.isInRange(15);
        // then
        assertTrue(result, "Number is outside range");
    }

    @Test
    public void shouldReturnTrueiFNumberOutOfRange() {

        Range range = new Range(10, 20);
        boolean result = !(range.isInRange(152));
        assertTrue(result, "Number is in range");
    }

    @Test
    public void shoulReturnRangeEdges() {

        int lowerBound = 10;
        int upperBound = 20;
        Range range = new Range(lowerBound, upperBound);
        boolean result1 = range.isInRange(lowerBound);
        boolean result2 = range.isInRange(upperBound);
        boolean result = (result1||result2);
        assertTrue(result,"edges does not comply method");
    }

}