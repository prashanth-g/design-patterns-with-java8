package com.prashanth.os.design.patterns.consumer.chaining;

import com.prashanth.os.design.patterns.consumer.chaining.function.Consumer;

public class PlayWithConsumers {
    public static void main(String[] args) {
        Consumer<String> consumer1 = s -> System.out.println("consumer1 = " + s);
        Consumer<String> consumer2 = s -> System.out.println("consumer2 = " + s);

        // Default chaining
        Consumer<String> consumer3 = s -> {
            consumer1.accept(s);
            consumer2.accept(s);
        };
        consumer3.accept("Chain - basic");

        Consumer<String> consumer = consumer1.andThen(consumer2);
        consumer.accept("Chain - default method");
    }
}
