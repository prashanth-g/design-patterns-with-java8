package com.prashanth.os.design.patterns.comparators;

import java.util.function.Function;

public class PlayingWithComparators {
    public static void main(String[] args) {
        Person mougli = Person.of("Mougli", 10);
        Person beem = Person.of("Beem", 5);
        Person tina = Person.of("Tina", 7);

        Function<Person, String> getName = person -> person.getName();

        Comparator<Person> comparator = (person1, person2) ->
                getName.apply(person1).compareTo(getName.apply(person2));

        Comparator<Person> compareName = Comparator.comparing(getName);

        System.out.println("Mougli vs Beem: " + (comparator.compare(mougli, beem) > 0));
        System.out.println("Beem vs Tina: " + (comparator.compare(beem, tina) > 0));
    }


}
