package ru.job4j.ex;

public class Factorial {
    public static int calc(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number could not be less than 0");
        }
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        calc(-1);
    }
}
