package org.example.testing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AssertJIntroTest {

    @Test
    public void shouldEndWithA() {

        String name = "Dorota";
        String otherName = "Dorota";

        assertThat(name).endsWith("a");
        assertThat(name)
                .isEqualTo(otherName)
                .endsWith("a")
                .hasSize(6);

        org.junit.jupiter.api.Assertions.assertTrue(name.endsWith("a"), "Nie kończy się na a");
    }
}
