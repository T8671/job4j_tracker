package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class FunctionCalculatorTest {

    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenQuadraticFunction() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 4, x -> 2 * Math.pow(x, 2) + 3 * x + 1);
        List<Double> expected = Arrays.asList(15D, 28D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenExponentialFunction() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 4, x -> 2 * Math.pow(x, 4));
        List<Double> expected = Arrays.asList(32D, 162D);
        assertThat(result).containsAll(expected);
    }
}