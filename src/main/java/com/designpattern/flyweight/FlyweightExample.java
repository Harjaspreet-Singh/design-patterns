package com.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightExample {

    public interface Pizza {
        void bake();
    }

    // Concrete class1
    static class MeatPizza implements Pizza {
        private String meat;

        public MeatPizza(String meat) {
            this.meat = meat;
        }

        @Override
        public void bake() {
            System.out.println("Baking Meat pizza with " + meat);
        }
    }

    // Concrete class2
    static class VeggiePizza implements Pizza {
        private String veggies;

        public VeggiePizza(String veggies) {
            this.veggies = veggies;
        }

        @Override
        public void bake() {
            System.out.println("Baking veggie pizza with " + veggies);
        }
    }

    // PizzaFactory is now a public class
    public static class PizzaFactory {
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
}
