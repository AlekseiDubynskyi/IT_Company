package com.solvd.it_company.patterns.observer;

public interface WeatherObserver {
    void update(WeatherType currentWeather);
}