package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCompareTest {

    private final StringCompare comparator = new StringCompare();

    @Test
    public void whenStringsAreEqualThenZero() {
        int result = comparator.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        int result = comparator.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        int result = comparator.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        int result = comparator.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        int result = comparator.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenDifferentCharacters() {
        assertTrue(comparator.compare("abc", "abd") < 0);
        assertTrue(comparator.compare("abd", "abc") > 0);
    }

    @Test
    public void whenEmptyStrings() {
        assertEquals(0, comparator.compare("", ""));
    }

    @Test
    public void whenOneEmptyString() {
        assertTrue(comparator.compare("", "abc") < 0);
        assertTrue(comparator.compare("abc", "") > 0);
    }

    @Test
    public void whenSpecialCharacters() {
        assertTrue(comparator.compare("abc!", "abc@") < 0);
    }
}