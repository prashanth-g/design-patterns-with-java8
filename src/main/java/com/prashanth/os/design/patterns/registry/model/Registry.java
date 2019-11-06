package com.prashanth.os.design.patterns.registry.model;

import com.prashanth.os.design.patterns.basic.Consumer;
import com.prashanth.os.design.patterns.factory.Factory;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    Factory<Shape> buildShapeFactory(Shape shape) {
        return null;
    }

    public static Registry createRegistry(Consumer<Builder<Rectangle>> consumer) {
        Map<String, Factory<Rectangle>>  map = new HashMap<>();
        Builder<Rectangle> builder = (label, factory) -> map.put(label, factory);
        consumer.accept(builder);

        return null;
    }
}
