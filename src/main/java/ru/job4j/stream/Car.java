package ru.job4j.stream;

import java.time.LocalDate;

public class Car {

    private String brand;
    private String model;
    private LocalDate create;
    private double volume;
    private String color;

    static class Builder {

        private String brand;
        private String model;
        private LocalDate create;
        private double volume;
        private String color;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreate(LocalDate create) {
            this.create = create;
            return this;
        }

        Builder buildVolume(Double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.color = color;
            car.create = create;
            car.volume = volume;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", create=" + create
                + ", volume=" + volume
                + ", color='" + color + '\''
                + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Tayota")
                .buildModel("Camry")
                .buildCreate(LocalDate.of(2021, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .build();
        System.out.println(car);

        Car car1 = new Builder()
                .buildBrand("Volkswagen")
                .buildModel("Teramont")
                .buildColor("Blue")
                .build();
        System.out.println(car1);
    }
}
