package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> person = new ArrayList<>();

    public void add(Person person) {
        this.person.add(person);
    }

    public ArrayList<Person> find(String key) {

        var namePredicate = (Predicate<Person>) p -> p.getName().contains(key);
        var surnamePredicate = (Predicate<Person>) p -> p.getSurname().contains(key);
        var phonePredicate = (Predicate<Person>) p -> p.getPhone().contains(key);
        var addressPredicate = (Predicate<Person>) p -> p.getAddress().contains(key);

        var combine = namePredicate
                .or(surnamePredicate)
                .or(phonePredicate)
                .or(addressPredicate);

        var result = new ArrayList<Person>();
        for (var person : person) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
