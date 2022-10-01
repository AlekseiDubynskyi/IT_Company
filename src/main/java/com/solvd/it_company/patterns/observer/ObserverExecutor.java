package com.solvd.it_company.patterns.observer;

public class ObserverExecutor {
    public static void main (String[] args) {
        var weather = new Weather();

        weather.addObserver(new Elves());
        weather.addObserver(new Hobbits());

        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
    }
}
