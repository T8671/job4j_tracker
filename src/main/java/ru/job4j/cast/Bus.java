package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " автобус двигается по скоростным трассам");

    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName()
                + " средняя скорость пассажирского междугороднего автобуса 55–60 км/ч");
    }
}
