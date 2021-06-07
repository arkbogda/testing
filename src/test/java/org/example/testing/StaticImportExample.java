package org.example.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaticImportExample {

    @Test
    void shouldAdd2To2AndReturn4() {
        Calculator calculator = new Calculator();

        int result = calculator.add(2, 2);

        assertEquals(2, result);
        assertEquals(2, result);
    }
}