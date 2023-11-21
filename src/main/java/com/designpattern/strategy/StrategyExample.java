package com.designpattern.strategy;


public class StrategyExample{

interface Restaurant{
    void makePizza();
   
}


class CheesePizza implements Restaurant {
    @Override
    public void makePizza() {
        System.out.println("Making Margherita Pizza");
    }
}

class PineapplePizza implements Restaurant{
    @Override
    public void makePizza(){
        System.out.println("Making Pineapple Pizza");
    }
}


class PlaceOrder{
    private Restaurant restaurant;

    public PlaceOrder(Restaurant restaurant){
        this.restaurant= restaurant;
    }

    public void PlaceOrder(){
        System.out.println("Placing the order");
        restaurant.makePizza();
    }
}

}