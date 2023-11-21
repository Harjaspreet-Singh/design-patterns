package com.designpattern.abstractFactory;


public class CarFactory {
    // Abstract Factory Interface
    interface VehicleFactory {
        Car createCar();
        Motorcycle createMotorcycle();
    }

    // Concrete Factory 1: Honda Factory
    public class HondaFactory implements VehicleFactory {
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
    class ToyotaFactory implements VehicleFactory {
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
    interface Car {
        void drive();
    }

    // Abstract Product Interface for Motorcycles
    interface Motorcycle {
        void ride();
    }

    // Concrete Products for Honda Cars
    class HondaCar implements Car {
        @Override
        public void drive() {
            System.out.println("Driving a Honda car");
        }
    }

    // Concrete Products for Honda Motorcycles
    class HondaMotorcycle implements Motorcycle {
        @Override
        public void ride() {
            System.out.println("Riding a Honda motorcycle");
        }
    }

    // Concrete Products for Toyota Cars
    class ToyotaCar implements Car {
        @Override
        public void drive() {
            System.out.println("Driving a Toyota car");
        }
    }

    // Concrete Products for Toyota Motorcycles
    class ToyotaMotorcycle implements Motorcycle {
        @Override
        public void ride() {
            System.out.println("Riding a Toyota motorcycle");
        }
    }

    
}