package com.designpattern.proxy;

public class ProxyExample {

    // Static interface
    public static interface Pizza {
        void order();
    }

    // Real Subject
    public static class PizzaPizza implements Pizza {
        private String type;

        public PizzaPizza(String type) {
            this.type = type;
            System.out.println("Creating a " + type + " pizza");
        }

        @Override
        public void order() {
            System.out.println("Serving a " + type + " pizza");
        }
    }

    // Proxy
    public static class PizzaProxy implements Pizza {
        private PizzaPizza pizzaPizza;
        private int customerMoney;

        public PizzaProxy(String type, int customerMoney) {
            this.customerMoney = customerMoney;
            System.out.println("Creating a " + type + " pizza proxy.");
        }

        @Override
        public void order() {
            if (customerMoney > 20) {
                if (pizzaPizza == null) {
                    pizzaPizza = new PizzaPizza("Proxy");
                }

                System.out.println("Proxy is checking for customer eligibility...");
                pizzaPizza.order();
            } else {
                System.out.println("It looks like you don't have enough money in your bank account. Top up and try again.");
            }
        }
    }
}
