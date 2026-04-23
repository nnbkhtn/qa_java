package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedHasMane;
    private final String expectedExceptionMessage;

    public LionParameterizedTest(String sex, boolean expectedHasMane, String expectedExceptionMessage) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.expectedExceptionMessage = expectedExceptionMessage;
    }

    @Parameterized.Parameters(name = "Пол льва: {0}")
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {"Самец", true, null},
                {"Самка", false, null},
                {"Другое", false, "Используйте допустимые значения пола животного - самец или самка"}
        });
    }

    @Test
    public void testLionSexInitialization() {
        try {
            Lion lion = new Lion(sex, null);

            assertEquals(expectedHasMane, lion.doesHaveMane());

        } catch (Exception e) {
            assertEquals(expectedExceptionMessage, e.getMessage());
        }
    }
}
