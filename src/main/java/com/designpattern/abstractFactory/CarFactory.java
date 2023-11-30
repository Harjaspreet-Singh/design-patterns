package com.designpattern.abstractFactory;

public class CarFactory {
    // Abstract Factory Interface
    public interface VehicleFactory {
        Car createCar();
        Motorcycle createMotorcycle();
    }

    // Concrete Factory 1: Honda Factory
    public static class HondaFactory implements VehicleFactory {
        @Override
        public Car createCar() {
            return new HondaCar();
        }

        @Override
        public Motorcycle createMotorcycle() {
            return new HondaMotorcycle();
        }
    }

    // Concrete Factory 2: Toyota Factory
    public static class ToyotaFactory implements VehicleFactory {
        @Override
        public Car createCar() {
            return new ToyotaCar();
        }

        @Override
        public Motorcycle createMotorcycle() {
            return new ToyotaMotorcycle();
        }
    }

    // Abstract Product Interface for Cars
    public interface Car {
        void drive();
    }

    // Abstract Product Interface for Motorcycles
    public interface Motorcycle {
        void ride();
    }

    // Concrete Products for Honda Cars
    public static class HondaCar implements Car {
        @Override
        public void drive() {
            System.out.println("Driving a Honda car");
        }
    }

    // Concrete Products for Honda Motorcycles
    public static class HondaMotorcycle implements Motorcycle {
        @Override
        public void ride() {
            System.out.println("Riding a Honda motorcycle");
        }
    }

    // Concrete Products for Toyota Cars
    public static class ToyotaCar implements Car {
        @Override
        public void drive() {
            System.out.println("Driving a Toyota car");
        }
    }

    // Concrete Products for Toyota Motorcycles
    public static class ToyotaMotorcycle implements Motorcycle {
        @Override
        public void ride() {
            System.out.println("Riding a Toyota motorcycle");
        }
    }
}
