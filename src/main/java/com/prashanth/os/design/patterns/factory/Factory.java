package com.prashanth.os.design.patterns.factory;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {

    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        final T singleton = supplier.get(); // Return same object always
        return () -> singleton;
    }

    static <T, R> Factory<R> createFactory(Function<T, R> constructor, T color) {
        return () -> constructor.apply(color);
    }

    default T newInstance() {
        return get();
    }

    default List<T> create5() {
        return IntStream.range(0, 5)
                .mapToObj(index -> newInstance())
                .collect(Collectors.toList());
    }
}
