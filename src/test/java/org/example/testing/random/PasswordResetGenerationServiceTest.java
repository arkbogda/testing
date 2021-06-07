package org.example.testing.random;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PasswordResetGenerationServiceTest {

    @Test
    public void shouldReturnPasswordResetMessage() {
        RandomTextGenerator randomTextGenerator = mock(RandomTextGenerator.class);
        when(randomTextGenerator.getRandomText()).thenReturn("abc123");

        PasswordResetGenerationService passwordResetGenerationService = new PasswordResetGenerationService(randomTextGenerator);

        String message = passwordResetGenerationService.preparePasswordResetMessage();

        Assertions.assertThat(message).isEqualTo("Cześć, aby przejść do resetowania hasła naciśnij " +
                "<a href=\"https://example.com/reset?key=abc123\">ten link</a>");

    }

}