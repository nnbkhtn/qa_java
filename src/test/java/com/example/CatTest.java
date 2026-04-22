package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline felineMock;

    @Test
    public void catGetSound() {
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void catGetFood() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        Cat cat = new Cat(felineMock);
        List<String> food = cat.getFood();

        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), food);

        Mockito.verify(felineMock).eatMeat();
    }
}