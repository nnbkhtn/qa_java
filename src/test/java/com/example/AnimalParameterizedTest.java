package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    private final String animalKind;
    private final List<String> expectedFood;
    private final String expectedExceptionMessage;

    public AnimalParameterizedTest(String animalKind, List<String> expectedFood, String expectedExceptionMessage) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
        this.expectedExceptionMessage = expectedExceptionMessage;
    }

    @Parameterized.Parameters(name = "Animal: {0}")
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения"), null},
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), null},
                {"Всеядные", null, "Неизвестный вид животного, используйте значение Травоядное или Хищник"}
        });
    }

    @Test
    public void testGetFood() {
        Animal animal = new Animal();
        try {
            List<String> result = animal.getFood(animalKind);

            if (expectedExceptionMessage != null) {
                fail(expectedExceptionMessage);
            }

            assertEquals(expectedFood, result);

        } catch (Exception e) {
            assertEquals(expectedExceptionMessage, e.getMessage());
        }
    }
}
