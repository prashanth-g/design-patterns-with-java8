package com.prashanth.os.design.patterns.registry.model;

import com.prashanth.os.design.patterns.factory.Factory;

public class PlayWithSwitchRegistry {
    public static void main(String[] args) {
        SwitchRegistry switchRegistry = new SwitchRegistry();

        Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) switchRegistry.buildShapeFactory("rectangle");
        System.out.println("Rectangle shape" + rectangleFactory.newInstance());
    }
}
