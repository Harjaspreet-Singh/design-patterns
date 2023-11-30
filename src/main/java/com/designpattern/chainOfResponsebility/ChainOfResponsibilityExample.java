package com.designpattern.chainOfResponsebility;

public class ChainOfResponsibilityExample {

    interface ExpensivePizzaHandler {
        void handleRequest(double money);
    }

    public static class Manager implements ExpensivePizzaHandler {
        private static final double APPROVAL_LIMIT = 1000;

        @Override
        public void handleRequest(double amount) {
            if (amount <= APPROVAL_LIMIT) {
                System.out.println("Manager approves the purchase of 50 pizzas.");
            } else {
                System.out.println("Manager cannot approve the request. Asking the Director.");
                new Director().handleRequest(amount);
            }
        }
    }

    public static class Director implements ExpensivePizzaHandler {
        private static final double APPROVAL_LIMIT = 4000;

        @Override
        public void handleRequest(double amount) {
            if (amount <= APPROVAL_LIMIT) {
                System.out.println("Director can approve the request for 1000 pizzas.");
            } else {
                System.out.println("Director cannot approve the request. Asking the President.");
                new President().handleRequest(amount);
            }
        }
    }

    public static class President implements ExpensivePizzaHandler {
        private static final double APPROVAL_LIMIT = 100000;

        @Override
        public void handleRequest(double amount) {
            if (amount <= APPROVAL_LIMIT) {
                System.out.println("The president approves the request for 1000 pizzas.");
            } else {
                System.out.println("The request has been denied by all authorities of the company.");
            }
        }
    }
}
