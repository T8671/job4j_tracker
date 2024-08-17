package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -4, -5, 0, 5, 4, 3, 2, 1);
        List<Integer> positive = numbers.stream().filter(num -> num > 0).toList();
        positive.forEach(System.out::println);
    }

}
