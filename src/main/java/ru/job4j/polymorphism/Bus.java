package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void drive() {
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Число пассажиров" + passengers);
    }

    @Override
    public int fillUp(int fuel) {
        return Transport.super.fillUp(fuel);
    }
}
