package com.designpattern.builder;

public class Car {
    private String id;
    private String brand;
    private String model;
    private String engine;

    public Car(String id, String brand, String model, String engine) { //public constructor
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.engine = engine;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getEngine() {
        return engine;
    }

    public static class CarBuilder {
        private String id;
        private String brand;
        private String model;
        private String engine;

        public CarBuilder setID(String id) {
            this.id = id;
            return this;
        }

        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Car build() {
            return new Car(id, brand, model, engine);
        }
    }
}

