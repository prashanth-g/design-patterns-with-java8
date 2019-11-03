package com.prashanth.os.design.patterns.comparators;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

    int compare(T t1, T t2);

    static <T> Comparator<T> comparing(Function<T, String> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (p1, p2) -> {
            String s1 = keyExtractor.apply(p1);
            String s2 = keyExtractor.apply(p2);
            return s1.compareTo(s2);
        };
    }
}
