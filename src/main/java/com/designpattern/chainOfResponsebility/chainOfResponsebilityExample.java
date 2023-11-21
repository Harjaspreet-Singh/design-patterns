package com.designpattern.chainOfResponsebility;

public class chainOfResponsebilityExample{

interface ExpensivePizzaHandler{
    void handleRequest(double money);
}

class Manager implements ExpensivePizzaHandler{
    private static final double APPROVAL_LIMIT = 1000;

    @Override
    public void handleRequest(double amount){
        if (amount<=APPROVAL_LIMIT){
            System.out.println("Manager appproves the purchase of 50 pizza.");
        }
        else{
            System.out.println("Manager can not approve the request. Asking the Director.");
            new Director().handleRequest(amount);
        }
    }

}

class Director implements ExpensivePizzaHandler{
    private static final double APPROVAL_LIMIT = 4000;

    @Override
    public void handleRequest(double amount){
        if (amount <= APPROVAL_LIMIT){
            System.out.println("Director can approve request for the 1000.");
        }
        else{
            System.out.println("Director can not approve request. Asking the President");
            new President().handleRequest(amount);
        }
    }
}

class President implements ExpensivePizzaHandler{
    private static final double APPROVAL_LIMIT = 100000;

    @Override
    public void handleRequest(double amount){
        if (amount <= APPROVAL_LIMIT){
            System.out.println("The president approves the request for the 1000 pizzas.");
        }
        else{
            System.out.println("The request has been denied by all authorities of the company");
        }
    }
}
}