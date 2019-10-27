package com.prashanth.os.design.patterns.consumer.chaining.function;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);

    // Concrete method
    default Consumer<T> andThen(Consumer<T> other) {
        return (T t) -> {
            this.accept(t);
            other.accept(t);
        };
    }
}
