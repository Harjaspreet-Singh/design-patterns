package com.designpattern.memento;

import java.util.ArrayList;
import java.util.List;

// Public class representing a pizza system that uses the Memento pattern.
public class PizzaSystem {

    // Memento class representing the state of a pizza.
    public static class PizzaName {
        private String pizzaName;
        private int freshnessLevel;

        public PizzaName(String pizzaName, int freshnessLevel) {
            this.pizzaName = pizzaName;
            this.freshnessLevel = freshnessLevel;
        }

        public String getPizzaName() {
            return pizzaName;
        }

        public int getFreshnessLevel() {
            return freshnessLevel;
        }
    }

    // Originator class representing the life of a pizza.
    public static class PizzaLife {
        private String pizzaName;
        private int freshnessLevel;

        public PizzaLife(String pizzaName, int freshnessLevel) {
            this.pizzaName = pizzaName;
            this.freshnessLevel = freshnessLevel;
        }

        public void decay() {
            freshnessLevel -= 10;
            if (freshnessLevel < 0) {
                freshnessLevel = 0;
            }
        }

        public PizzaName save() {
            return new PizzaName(pizzaName, freshnessLevel);
        }

        public void restore(PizzaName pizza) {
            this.pizzaName = pizza.getPizzaName();
            this.freshnessLevel = pizza.getFreshnessLevel();
        }
    }

    // Caretaker class managing the history of pizza states.
    public static class FreshnessHistory {
        private static List<PizzaName> pizzaNames = new ArrayList<>();

        public static void save(PizzaName name) {
            pizzaNames.add(name);
        }

        public static PizzaName undo() {
            if (pizzaNames.isEmpty()) {
                return null;
            }
            return pizzaNames.remove(pizzaNames.size() - 1);
        }
    }
}
