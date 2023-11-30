package com.designpattern.strategy;

public class StrategyExample {

    // Strategy Interface
    public interface Restaurant {
        void makePizza();
    }

    // Concrete Strategy class for Cheese Pizza
    public static class CheesePizza implements Restaurant {
        @Override
        public void makePizza() {
            System.out.println("Making Margherita Pizza");
        }
    }

    // Concrete Strategy class for Pineapple Pizza
    public static class PineapplePizza implements Restaurant {
        @Override
        public void makePizza() {
            System.out.println("Making Pineapple Pizza");
        }
    }

    // Context class
    public static class PlaceOrder {
        private Restaurant restaurant;

        public PlaceOrder(Restaurant restaurant) {
            this.restaurant = restaurant;
        }

        public void placeOrder() {
            System.out.println("Placing the order");
            restaurant.makePizza();
        }
    }
}
