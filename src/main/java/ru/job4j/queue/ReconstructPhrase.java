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
        int index = 0;
        for (Character element : evenElements) {
            if (index % 2 == 0) {
                stringBuilder.append(element);
            }
            index++;
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character element : descendingElements) {
            stringBuilder.insert(0, element);
        }
        return stringBuilder.toString();

    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}