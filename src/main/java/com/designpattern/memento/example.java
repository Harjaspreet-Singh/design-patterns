package com.designpattern.memento;

import java.util.ArrayList;
import java.util.List;

class PizzaName {
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

class PizzaLife {
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

class FreshnessHistory {
    private List<PizzaName> pizzaNames = new ArrayList<>();

    public void save(PizzaName name) {
        pizzaNames.add(name);
    }

    public PizzaName undo() {
        if (pizzaNames.isEmpty()) {
            return null;
        }
        PizzaName lastMemento = pizzaNames.remove(pizzaNames.size() - 1);
        return lastMemento;
    }
}
