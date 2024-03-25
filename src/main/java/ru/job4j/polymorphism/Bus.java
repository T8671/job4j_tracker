package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public String drive() {
        return null;
    }

    @Override
    public int passengers(int passengers) {
        return passengers;
    }

    @Override
    public int fillUp(int fuel) {
        return Transport.super.fillUp(fuel);
    }
}
