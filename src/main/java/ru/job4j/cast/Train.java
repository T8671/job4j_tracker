package ru.job4j.cast;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " поезд передвигается по рельсам");

    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName()
                + " средняя скорость пассажирского скорого поезда в среднем 55–60 км/ч");

    }
}
