package com.designpattern.command;

public class commandPatternDemo{

// Command interface
interface Command {
    void execute();
}

class OrderMeatPizza implements Command {
    private PizzaKitchen pizzaKitchen;

    public OrderMeatPizza(PizzaKitchen pizzaKitchen) {
        this.pizzaKitchen = pizzaKitchen;
    }

    @Override
    public void execute() {
        pizzaKitchen.makeChickenPizza();
    }
}

class OrderVeggiePizza implements Command {
    private PizzaKitchen pizzaKitchen;

    public OrderVeggiePizza(PizzaKitchen pizzaKitchen) {
        this.pizzaKitchen = pizzaKitchen;
    }

    @Override
    public void execute() {
        pizzaKitchen.makeVeggiePizza();
    }
}

class PizzaKitchen {
    public void makeChickenPizza() {
        System.out.println("Making Chicken Pizza");
    }

    public void makeVeggiePizza() {
        System.out.println("Making Veggie Pizza");
    }
}

class Customer {
    private Command command;

    public void setOrder(Command command) {
        this.command = command;
    }

    public void placeOrder() {
        command.execute();
    }
}
}