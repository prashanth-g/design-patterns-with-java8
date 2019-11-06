package com.prashanth.os.design.patterns.registry.model;

import com.prashanth.os.design.patterns.basic.Consumer;

public class PlayWithRegistryBuilder {
    public static void main(String[] args) {
        Consumer<Builder<Rectangle>> consumer =
                builder -> builder.register("rectangle", Rectangle::new);

        Registry registry = Registry.createRegistry(consumer);
    }
}
