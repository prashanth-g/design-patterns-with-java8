package com.prashanth.os.design.patterns;

public class Meteo {
    private int temperature;

    public Meteo(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}