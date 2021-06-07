package org.example.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JUnit5AssertionsTest {

    JUnit5Assertions sut = new JUnit5Assertions();

    @Test
    public void shouldBePrimeFor1() {
        boolean result = sut.isPrimeNumber(1);

        Assertions.assertTrue(result);
    }

    @Test
    public void shouldBePrimeFor2() {
        boolean result = sut.isPrimeNumber(2);

        Assertions.assertTrue(result);
    }

    @Test
    public void shouldBePrimeFor10() {
        boolean result = sut.isPrimeNumber(10);

        Assertions.assertFalse(result);
    }

    @Test
    public void shouldBePrimeFor11() {
        boolean result = sut.isPrimeNumber(11);

        Assertions.assertTrue(result);
    }

    @Test
    public void shouldBePrimeFor13() {
        boolean result = sut.isPrimeNumber(13);

        Assertions.assertTrue(result);
    }

    @Test
    public void shouldReturnValidCode() {
        JUnit5Assertions.Code code = sut.getCode("a");

        Assertions.assertEquals("a", code.getKey());
        Assertions.assertNotNull(code.getCreatedAtTimestamp());
        Assertions.assertNotNull(code.getCode());
    }

    @Test
    public void shouldReturnSameObjects() {
        JUnit5Assertions.Code code = sut.getCode("a");
        JUnit5Assertions.Code code2 = sut.getCode("a");

        Assertions.assertSame(code, code2);
    }
}