package at.meks.commons.lang;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalExtensionTest {

    @Test
    public void testFirstNotEmptyValueIsReturned() {
        Optional<String> result = OptionalExtension.<String>of(null)
                .ifEmpty(() -> null)
                .ifEmpty(() -> "3rdValue")
                .ifEmpty(() -> "4thLevel")
                .ifEmpty(() -> null)
                .orElseGetEmpty();
        assertThat(result).hasValue("3rdValue");
    }

    @Test
    public void testFirstValueIsReturnedIfNotNull() {
        Optional<String> result = OptionalExtension.of("1stValue")
                .ifEmpty(() -> null)
                .ifEmpty(() -> "3rdLevel")
                .orElseGetEmpty();
        assertThat(result).hasValue("1stValue");
    }

    @Test
    public void testEmptyIsReturnedIfAllAreEmpty() {
        Optional<String> result = OptionalExtension.<String>of(null)
                .ifEmpty(() -> null)
                .ifEmpty(() -> null)
                .orElseGetEmpty();
        assertThat(result).isEmpty();
    }
}
