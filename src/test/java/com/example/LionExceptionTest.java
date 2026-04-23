package com.example;

import org.junit.Test;

public class LionExceptionTest {

    @Test(expected = Exception.class)
    public void testLionInvalidSex() throws Exception {
        new Lion("Другое", null);
    }
}
