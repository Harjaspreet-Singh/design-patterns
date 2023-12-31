package com.designpattern.mediator;

public class MediatorExample {

    public interface CarManufactureMediator {
        void notify(String event, String data);
    }

    static class Manufacture {
        private final CarManufactureMediator manufacture;

        public Manufacture(CarManufactureMediator manufacture) {
            this.manufacture = manufacture;
        }

        public void prepCar(String car) {
            System.out.println("Preparing " + car + ".....");
            this.manufacture.notify("Car Ready", car);
        }
    }

    static class Fedex {
        public void deliverCar(String car) {
            System.out.println("Delivery " + car + ".....");
        }
    }

    public static class CarManufacture implements CarManufactureMediator {
        private final Manufacture manufacture;
        private final Fedex fedex;

        public CarManufacture() {
            this.manufacture = new Manufacture(this);
            this.fedex = new Fedex();
        }

        public void notify(String event, String data) {
            if (event.equals("Car Ready")) {
                this.fedex.deliverCar(data);
            }
        }

        public void orderCar(String car) {
            this.manufacture.prepCar(car);
        }
    }
}
