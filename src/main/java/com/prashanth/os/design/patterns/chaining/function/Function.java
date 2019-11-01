package com.prashanth.os.design.patterns.chaining.function;

import com.prashanth.os.design.patterns.Meteo;

import java.util.Objects;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);

    /**
     *  First apply the first function and apply the second function
     */
    default <V> Function<T, V> andThen(Function<R, V> other) {
        Objects.requireNonNull(other);
        return (T t) -> {
            R r = this.apply(t);
            return other.apply(r);
        };
    }

    /**
     *  Apply the first function to the result of function passed as a parameter
     */
    default <V> Function<V, R> compose(Function<V, T> other) {
        Objects.requireNonNull(other);
        return (V v) -> {
            T t = other.apply(v);
            return this.apply(t);
        };
    }

    static <T> Function<T, T> identity() {
        return t -> t;
    }

}
