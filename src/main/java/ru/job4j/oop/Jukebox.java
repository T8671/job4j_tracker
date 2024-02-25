package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        switch (position) {
            case 1 -> System.out.println("Пусть бегут неуклюже");
            case 2 -> System.out.println("Спокойной ночи");
            default -> System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox song = new Jukebox();
        int one = 1;
        int two = 2;
        int three = 3;
        song.music(one);
        song.music(two);
        song.music(three);
    }
}
