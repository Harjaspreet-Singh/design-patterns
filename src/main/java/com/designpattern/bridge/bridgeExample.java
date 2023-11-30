package com.designpattern.bridge;

public class bridgeExample {
    // Implementor interface for the pizza toppings
    public static interface Toppings {
        void provideToppings();
    }

    // Concrete implementor classes for different toppings.
    public static class MeatPizza implements Toppings {
        @Override
        public void provideToppings() {
            System.out.println("Pepperoni, Bacon, Cheese");
        }
    }

    public static class VegPizza implements Toppings {
        @Override
        public void provideToppings() {
            System.out.println("Pineapple, Green Peppers, Black Olives");
        }
    }

    // Abstraction interface for Pizza types
    public static interface Pizza {
        void assemble();
    }

    // Re-defined for different Pizza styles.
    public static class Large implements Pizza {
        protected Toppings topped;

        public Large(Toppings topped) {
            this.topped = topped;
        }

        @Override
        public void assemble() {
            System.out.println("Assembling Large Pizza with ");
            topped.provideToppings();
        }
    }

    public static class Small implements Pizza {
        protected Toppings topped;

        public Small(Toppings topped) {
            this.topped = topped;
        }

        @Override
        public void assemble() {
            System.out.println("Assembling Small Pizza with ");
            topped.provideToppings();
        }
    }
}
