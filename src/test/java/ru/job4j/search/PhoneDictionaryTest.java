package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        var person = new Person(
                "Petr",
                "Arsentev",
                "534872",
                "Bryansk"
        );
        phones.add(person);
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenNothingIsFound() {
        var phones = new PhoneDictionary();
        var person = new Person(
                "Petr",
                "Arsentev",
                "534872",
                "Bryansk"
        );
        phones.add(person);
        var persons = phones.find("Bob");
        assertTrue(persons.isEmpty(), "Expected no person to be found");
    }
}