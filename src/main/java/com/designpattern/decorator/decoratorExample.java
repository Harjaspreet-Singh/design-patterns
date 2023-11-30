package com.designpattern.decorator;

public class DecoratorExample {

    // Component Interface
    public interface PizzaOption {
        void assemble();
    }

    public static class BasicPizza implements PizzaOption {
        @Override
        public void assemble() {
            System.out.println("Assembling a simple Pizza");
        }
    }

    public static abstract class PizzaDecorator implements PizzaOption {
        protected PizzaOption decoratedPizza;

        public PizzaDecorator(PizzaOption pizza) {
            this.decoratedPizza = pizza;
        }

        @Override
        public void assemble() {
            decoratedPizza.assemble();
        }
    }

    // Concrete decorator 1
    public static class Pepperoni extends PizzaDecorator {
        public Pepperoni(PizzaOption pizza) {
            super(pizza);
        }

        @Override
        public void assemble() {
            super.assemble();
            System.out.println("Adding pepperoni to the Pizza");
        }
    }

    // Concrete decorator 2
    public static class BaconCrumble extends PizzaDecorator {
        public BaconCrumble(PizzaOption pizza) {
            super(pizza);
        }

        @Override
        public void assemble() {
            super.assemble();
            System.out.println("Adding bacon crumble to the Pizza");
        }
    }

}