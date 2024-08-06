package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {

        String[] parts1 = o1.split("/");
        String[] parts2 = o2.split("/");

        int firstPartComparison = parts2[0].compareTo(parts1[0]);

        if (firstPartComparison != 0) {
            return firstPartComparison;
        }
        return o1.compareTo(o2);
    }
}

