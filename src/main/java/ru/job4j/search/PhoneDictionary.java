package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> person = new ArrayList<>();

    public void add(Person person) {
        this.person.add(person);
    }

    public ArrayList<Person> find(String key) {

        Predicate<Person> namePredicate = p -> p.getName().equals(key);
        Predicate<Person> surnamePredicate = p -> p.getSurname().equals(key);
        Predicate<Person> phonePredicate = p -> p.getPhone().equals(key);
        Predicate<Person> addressPredicate = p -> p.getAddress().equals(key);

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
