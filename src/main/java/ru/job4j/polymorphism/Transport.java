package ru.job4j.polymorphism;

public interface Transport {
    String drive();

    int passengers(int passengers);

    default int fillUp(int fuel) {
        return fuel * 65;
    }
}
