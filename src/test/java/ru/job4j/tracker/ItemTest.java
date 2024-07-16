package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.collection.ItemAscByName;
import ru.job4j.collection.ItemDescByName;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void whenSortedAscendingOrderByName() {
        List<Item> items = Arrays.asList(
                new Item("One"),
                new Item("Two"),
                new Item("Three"),
                new Item("Four"),
                new Item("Five"));
        items.sort(new ItemAscByName());

        List<Item> expected = Arrays.asList(
                new Item("Five"),
                new Item("Four"),
                new Item("One"),
                new Item("Three"),
                new Item("Two"));

        assertThat(items).containsExactlyElementsOf(expected);
    }

    @Test
    void whenSortedDescendingOrderByName() {
        List<Item> items = Arrays.asList(
                new Item("One"),
                new Item("Two"),
                new Item("Three"),
                new Item("Four"),
                new Item("Five"));
        items.sort(new ItemDescByName());

        List<Item> expected = Arrays.asList(
                new Item("Two"),
                new Item("Three"),
                new Item("One"),
                new Item("Four"),
                new Item("Five"));

        assertThat(items).containsExactlyElementsOf(expected);
    }
}