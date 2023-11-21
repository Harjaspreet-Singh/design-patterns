package com.designpattern.decorator;

public class decoratorExample{
//Component Interface
interface PizzaOption{
    void assemble();
}

class basicPizza implements PizzaOption{
    @Override
    public void assemble(){
        System.out.println("Assembling a simple Pizza");
    }
}

abstract class PizzaDecorator implements PizzaOption{
    protected PizzaOption decoratedPizza;

    public PizzaDecorator(PizzaOption nonvegpizza){
        this.decoratedPizza = nonvegpizza;
    }

    @Override

    public void assemble(){
        decoratedPizza.assemble();
    }
}



//Concrete decorator 1

class Pepperoni extends PizzaDecorator{
    public Pepperoni(PizzaOption nonvegpizza){
        super(nonvegpizza);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.println("Adding pepperoni to the Pizza");
    }
}


//Concrete decorator 2
class baconCrumble extends PizzaDecorator{
    public baconCrumble(PizzaOption nonvegpizza){
        super(nonvegpizza);

    }

    @Override
    public void assemble(){
    super.assemble();
    System.out.println("Adding bacon crumble to the Pizza");

    }

}
}








