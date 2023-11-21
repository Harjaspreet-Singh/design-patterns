package com.designpattern.proxy;

public class ProxyExample{
interface Pizza{
    void order();
}



// Real Subject

class PizzaPizza implements Pizza{
    private String type;

    public PizzaPizza(String type) {
        this.type = type;
        System.out.println("Creating a " + type+ "pizza");

    }

    @Override
    public void order(){
        System.out.println("Serving a " +type+ " pizza");
    }

}

class PizzaProxy implements Pizza {
    private PizzaPizza pizzapizza;
    private int costumerMoney;

    public PizzaProxy(String type, int costumerMoney) {
        this.costumerMoney=costumerMoney;

        System.out.println("Creating a " +type+ " pizza proxy.");
    }

    @Override

    public void order(){
        if (costumerMoney > 20){
            if (pizzapizza == null){
                pizzapizza = new PizzaPizza("Proxy");
            }

            System.out.println("Proxy is checking for costumer elegibility...");
            pizzapizza.order();
        }else{
            System.out.println("It looks like you dont have enough money in your Bank account top up and Try again");
        }
    }
}

}