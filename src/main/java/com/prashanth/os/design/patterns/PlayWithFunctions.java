package com.prashanth.os.design.patterns;

import com.prashanth.os.design.patterns.chaining.function.Function;

public class PlayWithFunctions {
    public static void main(String[] args) {
        Meteo mateo = new Meteo(20);

        Function<Meteo, Integer> readCelsius = m -> m.getTemperature();
        Function<Integer, Double> convertToFahrenheit = temperature -> (temperature * 9d / 5d) + 32d;

        /* a.andThen(b).andThen(c).andThen(d);
         *  Here the execution will be a.apply(input) -> b.apply(result of a.apply(input)) -> c.apply(result of b.apply(...))...
         */
        Function<Meteo, Double> readFahrenheit01 = readCelsius
                .andThen(convertToFahrenheit);


        /* a.compose(b).compose(c);
         *  Here the execution will be c.apply(input) -> b.apply(result of c.apply(...)) -> a.apply(result of b.apply(...))...
         */
        Function<Meteo, Double> readFahrenheit02 = convertToFahrenheit
                .compose(readCelsius);

        System.out.println(readFahrenheit01.apply(mateo));
        System.out.println(readFahrenheit02.apply(mateo));

        // Static methods can be used as factory methods
        Function<String, String> identity = Function.identity();
    }
}
