package com.designpattern.facade;
public class PizzaBacker{
// Subsystem 1: Oven Temperature
class TemperatureCheck {
    public void setHigh() {
        System.out.println("Oven temperature set to high heat");
    }

    public void setLow() {
        System.out.println("Oven temperature set to low heat");
    }
}

// Subsystem 2: Pizza In/Out
class PizzaInOut {
    public void putInOven() {
        System.out.println("Pizza is put into the oven.");
    }

    public void takeOutOfOven() {
        System.out.println("Pizza is taken out of the oven.");
    }
}

// Subsystem 3: Oven On/Off
class OvenOnOff {
    public void turnOn() {
        System.out.println("Oven is turned ON");
    }

    public void turnOff() {
        System.out.println("Oven is turned OFF");
    }
}

// Facade: Oven System
class OvenSystem {
    private TemperatureCheck temperatureCheck;
    private PizzaInOut pizzaInOut;
    private OvenOnOff ovenOnOff;

    public OvenSystem() {
        this.temperatureCheck = new TemperatureCheck();
        this.pizzaInOut = new PizzaInOut();
        this.ovenOnOff = new OvenOnOff();
    }

    public void bakePizza() {
        System.out.println("Baking the pizza...");
        temperatureCheck.setHigh();
        pizzaInOut.putInOven();
        ovenOnOff.turnOn();
        System.out.println("Pizza is successfully baked");
    }

    public void turnOffOven() {
        System.out.println("Turning off the oven");
        temperatureCheck.setLow();
        pizzaInOut.takeOutOfOven();
        ovenOnOff.turnOff();
    }
}

}