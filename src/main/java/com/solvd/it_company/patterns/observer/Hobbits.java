package com.solvd.it_company.patterns.observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hobbits implements WeatherObserver {
    private static final Logger LOGGER = LogManager.getLogger(Hobbits.class);

    @Override
    public void update(WeatherType currentWeather) {
        LOGGER.info("The hobbits are facing " + currentWeather.getDescription() + " weather now");
    }
}
