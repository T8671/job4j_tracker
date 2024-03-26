package ru.job4j.polymorphism;

public interface Transport {
    void drive();

    void passengers(int passengers);

     default int fillUp(int fuel) {
        return fuel * 65;
    }
}
