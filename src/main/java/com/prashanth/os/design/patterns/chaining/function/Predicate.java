package com.prashanth.os.design.patterns.chaining.function;

import java.util.Objects;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        Objects.requireNonNull(other);
        return (T t) -> this.test(t) && other.test(t);
    }
}