package com.prashanth.os.design.patterns;

import com.prashanth.os.design.patterns.chaining.function.Function;

public class PlayWithFunctions {
    public static void main(String[] args) {
        Meteo mateo = new Meteo(20);

        Function<Meteo, Integer> readCelcius = m -> m.getTemperature();
        Function<Integer, Double> convertToFarenheit = temperature -> (temperature * 9d / 5d) + 32d;

        Function<Meteo, Double> readFarenheit = readCelcius.andThen(convertToFarenheit);

        System.out.println(readFarenheit.apply(mateo));
    }
}
