package com.designpattern.command;

public class CommandPatternDemo {

    // Command interface
    public static interface Command {
        void execute();
    }

    public static class OrderMeatPizza implements Command {
        private PizzaKitchen pizzaKitchen;

        public OrderMeatPizza(PizzaKitchen pizzaKitchen) {
            this.pizzaKitchen = pizzaKitchen;
        }

        @Override
        public void execute() {
            pizzaKitchen.makeChickenPizza();
        }
    }

    public static class OrderVeggiePizza implements Command {
        private PizzaKitchen pizzaKitchen;

        public OrderVeggiePizza(PizzaKitchen pizzaKitchen) {
            this.pizzaKitchen = pizzaKitchen;
        }

        @Override
        public void execute() {
            pizzaKitchen.makeVeggiePizza();
        }
    }

    public static class PizzaKitchen {
        public void makeChickenPizza() {
            System.out.println("Making Chicken Pizza");
        }

        public void makeVeggiePizza() {
            System.out.println("Making Veggie Pizza");
        }
    }

    public static class Customer {
        private Command command;

        public void setOrder(Command command) {
            this.command = command;
        }

        public void placeOrder() {
            command.execute();
        }
    }

}
