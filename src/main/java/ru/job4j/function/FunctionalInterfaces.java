package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = map::put;
        biConsumer.accept(1, "one");
        biConsumer.accept(2, "two");
        biConsumer.accept(3, "three");
        biConsumer.accept(4, "four");
        biConsumer.accept(5, "five");
        biConsumer.accept(6, "six");
        biConsumer.accept(7, "seven");

        BiPredicate<Integer, String> biPredicate = (key, value) ->
                (key % 2 != 0 || map.get(key).length() == 4);
        for (Integer key : map.keySet()) {
            if (biPredicate.test(key, map.get(key))) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }

            Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());

            Consumer<String> consumer = System.out::println;
            List<String> strings = supplier.get();
            strings.forEach(consumer);

            Function<String, String> function = String::toUpperCase;
            for (String string : strings) {
                System.out.println(function.apply(string));
            }
        }
    }
}
