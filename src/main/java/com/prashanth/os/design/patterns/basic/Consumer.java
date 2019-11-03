package com.prashanth.os.design.patterns.basic;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);

    // Concrete method
    default Consumer<T> andThen(Consumer<T> other) {
        Objects.requireNonNull(other);
        return (T t) -> {
            this.accept(t);
            other.accept(t);
        };
    }
}
