package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minString = Math.min(left.length(), right.length());
        for (int i = 0; i < minString; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.charAt(i) - right.charAt(i);
            }
        }
        return left.length() - right.length();
    }
}