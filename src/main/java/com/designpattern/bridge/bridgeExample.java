package com.designpattern.bridge;



public class bridgeExample{
//Implementor interface for the pizza toppings
interface Toppings{
    void provideToppings();
}

//Concrete implementor classes for different toppings.

class MeatPizza implements Toppings {

    @Override
    public void provideToppings(){
        System.out.println("Peperoni, Bacon, cheese");
    }

}

class VegPizza implements Toppings{
    @Override
    public void provideToppings(){
        System.out.println("Pineapple, Green Peppers, black Olives");
    }
}

//Abstraction interface for Pizza types

interface Pizza {
    void assemble();
}

//Re-defined for different Pizza styles.

class large implements Pizza{
    protected Toppings topped;

    public large(Toppings topped){
        this.topped = topped;
    }

    @Override
    public void assemble(){
        System.out.println("Assembling Large Pizza with ");
        topped.provideToppings();
    }
}


class small implements Pizza{
    protected Toppings topped;

    public small(Toppings topped){
    this.topped = topped;
    }
    @Override
    public void assemble(){
        System.out.println("Assembling small Pizza with ");
        topped.provideToppings();
    }

}

}