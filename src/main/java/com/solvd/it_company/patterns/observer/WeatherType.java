package com.solvd.it_company.patterns.observer;

public enum WeatherType {
    SUNNY("sunny"),
    RAINY("rainy"),
    WINDY("windy"),
    COLD("cold");

    private final String description;

    WeatherType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
