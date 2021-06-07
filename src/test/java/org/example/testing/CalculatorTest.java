package org.example.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    public void shouldAdd5To2AndResult7() {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 2;

        int result = calculator.add(a, b);

        Assertions.assertEquals(7, result);
    }

    @Test
    public void shouldAdd1To1AndResult2() {
        Calculator calculator = new Calculator();
        int a = 1;
        int b = 1;

        int result = calculator.add(a, b);

        Assertions.assertEquals(2, result);
        Assertions.assertTrue(result == 2);
        Assertions.assertFalse(result == 3);
    }
}