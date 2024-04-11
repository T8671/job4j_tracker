package ru.job4j.ex;

public class BackArray {
    public String[] turn(String[] names) {
        int middle = names.length / 2;
        for (int i = 0; i < middle; i++) {
            String temp = names[i];
            names[i] = names[names.length - i - 1];
            names[names.length - i - 1] = temp;
        }
        return names;
    }
}