package com.prashanth.os.design.patterns.chaining.function;

import com.prashanth.os.design.patterns.Meteo;

import java.util.Objects;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);

    default <V> Function<T, V> andThen(Function<R, V> other) {
        Objects.requireNonNull(other);
        return (T t) -> {
            R r = this.apply(t);
            return other.apply(r);
        };
    }

    default <V> Function<V, R> compose(Function<V, T> other) {
        return (V v) -> {
            T t = other.apply(v);
            return this.apply(t);
        };
    }

}
