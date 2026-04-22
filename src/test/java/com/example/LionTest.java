package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;  // Импортируем сам Mockito
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Predator predatorMock;

    @Test
    public void lionMaleHasMane() throws Exception {
        Lion lion = new Lion("Самец", predatorMock);
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void lionFemaleNoMane() throws Exception {
        Lion lion = new Lion("Самка", predatorMock);
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void lionGetsFood() throws Exception {
        Mockito.when(predatorMock.getFood("Хищник")).thenReturn(Arrays.asList("Мясо"));

        Lion lion = new Lion("Самец", predatorMock);
        List<String> food = lion.getFood();

        Assert.assertEquals(Arrays.asList("Мясо"), food);

        Mockito.verify(predatorMock).getFood("Хищник");
    }

    @Test
    public void lionGetsKittens() throws Exception {
        Mockito.when(predatorMock.getKittens()).thenReturn(5);

        Lion lion = new Lion("Самец", predatorMock);
        int kittens = lion.getKittens();

        Assert.assertEquals(5, kittens);
        Mockito.verify(predatorMock).getKittens();
    }

    @Test(expected = Exception.class)
    public void lionInvalidSex() throws Exception {
        new Lion("Неизвестно", predatorMock);
    }
}