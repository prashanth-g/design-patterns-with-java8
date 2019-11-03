package com.prashanth.os.design.patterns.factory;

import java.util.List;
import java.util.function.Supplier;

public class PlayWithFactory {
    public static void main(String[] args) {
        Factory<Circle> factory = () -> new Circle();
        Circle circle = factory.newInstance();

        System.out.println("Circle " + circle);

        List<Circle> circles = factory.create5();
        System.out.println("5 Circles" + circles);
    }
}
