package com.designpattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class CarFactory {

    // Prototype Interface
    public interface CarStartPrototype {
        CarStartPrototype clone();
        void start();
    }

    // Concrete prototype classes to turn on different car models
    public static class MercedesCar implements CarStartPrototype {
        @Override
        public CarStartPrototype clone() {
            return new MercedesCar();
        }

        @Override
        public void start() {
            System.out.println("Starting Mercedes Car");
        }
    }

    public static class BmwCar implements CarStartPrototype {
        @Override
        public CarStartPrototype clone() {
            return new BmwCar();
        }

        @Override
        public void start() {
            System.out.println("Starting BMW car");
        }
    }

    public static class TeslaCar implements CarStartPrototype {
        @Override
        public CarStartPrototype clone() {
            return new TeslaCar();
        }

        @Override
        public void start() {
            System.out.println("Starting Tesla car");
        }
    }

    // CarCompany class
    public static class CarCompany {
        private static Map<String, CarStartPrototype> carStartPrototypes = new HashMap<>();

        public void addCarStartPrototype(String startButton, CarStartPrototype carStartPrototype) {
            carStartPrototypes.put(startButton, carStartPrototype);
        }

        public CarStartPrototype getCar(String startButton) {
            return carStartPrototypes.get(startButton).clone();
        }
    }

}
