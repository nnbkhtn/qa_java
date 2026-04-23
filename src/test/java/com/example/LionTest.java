package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Predator predatorMock;

    @Before
    public void setUp() {
        predatorMock = Mockito.mock(Predator.class);
    }

    @Test
    public void lionGetsFoodReturnsCorrectData() throws Exception {
        Mockito.when(predatorMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", predatorMock);
        List<String> food = lion.getFood();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void lionGetsFoodCallsPredator() throws Exception {
        Mockito.when(predatorMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", predatorMock);
        lion.getFood();

        Mockito.verify(predatorMock).getFood("Хищник");
    }
}