package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> person = new ArrayList<>();

    public void add(Person person) {
        this.person.add(person);
    }

    public ArrayList<Person> find(String key) {

        Predicate<Person> namePredicate = p -> p.getName().contains(key);
        Predicate<Person> surnamePredicate = p -> p.getSurname().contains(key);
        Predicate<Person> phonePredicate = p -> p.getPhone().contains(key);
        Predicate<Person> addressPredicate = p -> p.getAddress().contains(key);

        Predicate<Person> combine = namePredicate
                .or(surnamePredicate)
                .or(phonePredicate)
                .or(addressPredicate);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : person) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
