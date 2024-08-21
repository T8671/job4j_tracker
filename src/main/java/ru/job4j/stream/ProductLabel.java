package ru.job4j.stream;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products
                .stream()
                .filter(n -> n.getStandart() - n.getActual() < 4)
                .map(p -> new Label(p.getName(), p.getPrice() / 2))
                .map(Label::toString)
                .collect(Collectors.toList());
    }
}