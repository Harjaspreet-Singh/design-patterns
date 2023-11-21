package com.designpattern.template;

// Abstract class which defines the template
abstract class PizzaGuide {

    // This template will define the order/algorithm of how the pizza should be made
    final void preparePizza() {
        prepareDough();
        addSauce();
        addCheese();
        bake();
        addToppings();
        sliceAndServe();
    }

    abstract void prepareDough();
    abstract void addSauce();
    abstract void addCheese();
    abstract void addToppings();
    abstract void sliceAndServe();

    void bake() {
        System.out.println("Baking the pizza");
    }

}

class VeggiePizza extends PizzaGuide {
    @Override
    void prepareDough() {
        System.out.println("Preparing thin crust dough.");
    }

    @Override
    void addSauce() {
        System.out.println("Adding tomato sauce.");
    }

    @Override
    void addCheese() {
        System.out.println("Adding Mozzarella cheese.");
    }

    @Override
    void addToppings() {
        System.out.println("Adding Green Peppers and pineapple.");
    }

    @Override
    void sliceAndServe() {
        System.out.println("Slicing and serving the Veggie Pizza");
    }
}

class MeatPizza extends PizzaGuide {
    @Override
    void prepareDough() {
        System.out.println("Preparing thick crust dough.");
    }

    @Override
    void addSauce() {
        System.out.println("Adding tomato sauce.");
    }

    @Override
    void addCheese() {
        System.out.println("Adding Mozzarella cheese.");
    }

    @Override
    void addToppings() {
        System.out.println("Adding Chicken and bacon crumble.");
    }

    @Override
    void sliceAndServe() {
        System.out.println("Slicing and serving the Meat Pizza");
    }
}
