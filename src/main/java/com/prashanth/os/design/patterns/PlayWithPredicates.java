package com.prashanth.os.design.patterns;

import com.prashanth.os.design.patterns.chaining.function.Predicate;

public class PlayWithPredicates {
    public static void main(String[] args) {
        Predicate<String> predicate1 = s -> s != null;
        Predicate<String> predicate2 = s -> s.isEmpty();

        Predicate<String> negatedP2 = predicate2.negate();

        Predicate<String> predicate3 = predicate1.and(negatedP2);

        System.out.println(predicate3.test("Basic"));
    }
}
