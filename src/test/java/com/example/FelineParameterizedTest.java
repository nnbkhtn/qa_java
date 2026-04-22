package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int inputCount;
    private final int expectedCount;

    public FelineParameterizedTest(int inputCount, int expectedCount) {
        this.inputCount = inputCount;
        this.expectedCount = expectedCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {5, 5},
                {100, 100}
        });
    }

    @Test
    public void testGetKittensWithParam() {
        Feline feline = new Feline();

        int result = feline.getKittens(inputCount);

        assertEquals(expectedCount, result);
    }
}
