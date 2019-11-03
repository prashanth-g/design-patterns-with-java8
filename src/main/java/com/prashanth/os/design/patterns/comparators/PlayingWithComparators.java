package com.prashanth.os.design.patterns.comparators;

import java.util.function.Function;

public class PlayingWithComparators {
    public static void main(String[] args) {
        Person mougli = Person.of("Mougli", 10);
        Person mougli2 = Person.of("Mougli", 8);
        Person beem = Person.of("Beem", 5);
        Person tina = Person.of("Tina", 7);

        Function<Person, String> getName = person -> person.getName();
        Function<Person, Integer> getAge = person -> person.getAge();

        Comparator<Person> comparator = (person1, person2) ->
                getName.apply(person1).compareTo(getName.apply(person2));

        Comparator<Person> compareName = Comparator.comparing(getName);
        Comparator<Person> compareAge = Comparator.comparing(getAge);
        Comparator<Person> compareNameReversed = compareName.reversed();

        Comparator<Person> cmp = compareName.thenComparing(compareAge);
        Comparator<Person> cmp2 = Comparator.comparing(Person::getName)
                .thenComparing(Person::getAge);

        System.out.println("1 : Compare -> Mougli > Beem: " + (comparator.compare(mougli, beem) > 0));
        System.out.println("2 : Compare -> Beem > Tina: " + (comparator.compare(beem, tina) > 0));
        System.out.println("3 : Compare Reversed -> Mougli > Beem: " + (compareNameReversed.compare(mougli, beem) > 0));
        System.out.println("4 : Compare Age -> Mougli > Beem: " + (compareAge.compare(mougli, beem) > 0));

        System.out.println("5 : Compare Chained -> Mougli > Mougli2: " + (cmp.compare(mougli, mougli2) > 0));
        System.out.println("6 : Comparator thenComparing as Readable -> Mougli > Mougli2: " + (cmp2.compare(mougli, mougli2) > 0));
    }
}
