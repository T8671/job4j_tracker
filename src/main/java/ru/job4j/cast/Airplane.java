package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " самолет летает по воздуху");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName()
                + " средняя скорость пассажирского самолета 880–926 км/ч");
    }
}
