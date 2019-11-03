package com.prashanth.os.design.patterns.factory;

import java.awt.Color;
import java.util.List;

public class PlayWithFactory {
    public static void main(String[] args) {
        Factory<Circle> factory1 = Factory.createFactory(Circle::new, Color.RED);
        Factory<Circle> factory2 = Factory.createFactory(Circle::new);

        Circle circle1 = factory2.newInstance();
        Circle circle2 = factory2.newInstance();

        System.out.println("Circle " + circle1.hashCode());
        System.out.println("Circle " + circle2.hashCode());

        List<Circle> circles = factory1.create5();
        System.out.println("5 Circles" + circles);
    }
}
