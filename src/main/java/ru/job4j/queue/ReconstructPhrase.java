package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] array = evenElements.toArray();

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                stringBuilder.append(array[i]);
            }
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements() {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] array = descendingElements.toArray();

        for (int i = array.length - 1; i >= 0; i--) {
            stringBuilder.append(array[i]);
        }
        return stringBuilder.toString();

    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}