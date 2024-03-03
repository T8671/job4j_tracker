package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TriangleTest {

    @Test
    public void when15and44andMinus54Then13Dot416() {
        Point a = new Point(1, 5);
        Point b = new Point(4, 4);
        Point c = new Point(-5, 4);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 13.416;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when00and40and04ThenMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

}