package com.prashanth.os.design.patterns;

import com.prashanth.os.design.patterns.chaining.function.Function;

public class PlayWithFunctions {
    public static void main(String[] args) {
        Meteo mateo = new Meteo(20);

        Function<Meteo, Integer> readCelsius = m -> m.getTemperature();
        Function<Integer, Double> convertToFahrenheit = temperature -> (temperature * 9d / 5d) + 32d;

        Function<Meteo, Double> readFahrenheit = readCelsius.andThen(convertToFahrenheit);

        readFahrenheit = convertToFahrenheit.compose(readCelsius);

        System.out.println(readFahrenheit.apply(mateo));
    }
}
