package org.knit.semestr2.lab2;

public class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public synchronized void pass(TrafficLight trafficLight) {
        trafficLight.waitForGreen();
        System.out.println("Машина " + name + " проехала перекресток");
    }
}
