package org.example.testing;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnit5MultipleAssertions {

    //rekomendowana opcja
    @Test
    public void multipleAssertionsTogetherWithAssertJ() {
        String name = "Dorota";
        String otherName = "Dorota";

        Assertions.assertAll(
                () -> assertThat(name).endsWith("a"),
                () -> assertThat(name)
                .isEqualTo(otherName)
                .endsWith("a")
                .hasSize(6)
        );

    }

    @Test
    void multipleAssertioinsTogetherWithJUnit() {
        String name = "Dorota";
        String otherName = "Dorota";

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(name.endsWith("a"));
        softAssertions.assertThat(name).isEqualTo("Dorota");
        softAssertions.assertAll();
    }
}
