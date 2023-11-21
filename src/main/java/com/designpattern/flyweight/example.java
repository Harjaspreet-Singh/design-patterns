package com.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;


interface Pizza {
    void bake();
}


//concrete class1
class MeatPizza implements Pizza {
    private String meat;

    public MeatPizza(String meat) {
        this.meat = meat;
    }

    @Override
    public void bake() {
        System.out.println("Baking Meat pizza with " + meat);
    }
}
//concrete class2
class VeggiePizza implements Pizza {
    private String veggies;

    public VeggiePizza(String veggies) {
        this.veggies = veggies;
    }

    @Override
    public void bake() {
        System.out.println("Baking veggie pizza with " + veggies);
    }
}

class PizzaFactory {
    private static final Map<String, Pizza> pizzaMap = new HashMap<>();

    public static Pizza getPizza(String type, String meat, String veggies) {
        String key = type + meat;
        Pizza pizza = pizzaMap.get(key);

        if (pizza == null) {
            switch (type) {
                case "Meat Pizza":
                    pizza = new MeatPizza(meat);
                    break;
                case "Veggie Pizza":
                    pizza = new VeggiePizza(veggies);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Pizza type: " + type);
            }

            pizzaMap.put(key, pizza);
            System.out.println("Creating a new " + type + " with " + (type.equals("Meat Pizza") ? "meat " + meat : "veggies " + veggies));
        }
        return pizza;
    }
}
