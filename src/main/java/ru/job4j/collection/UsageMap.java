package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev Sergeevich");
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("parsentev1@yandex.ru", "Petr Velikiy");
        map.put("parsentev2@yandex.ru", "Petr 1");
        map.put("parsentev3@yandex.ru", "Petr Ivanovich");

        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
