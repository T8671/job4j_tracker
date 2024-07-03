package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> fullSearch = new HashSet<>();
        for (Task number : list) {
            fullSearch.add(number.getNumber());
        }
        return fullSearch;
    }
}
