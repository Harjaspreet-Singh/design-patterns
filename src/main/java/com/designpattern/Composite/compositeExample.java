package com.designpattern.Composite;
import java.util.ArrayList;
import java.util.List;


public class compositeExample{
interface PizzaAssemble{
    void assemble();
}
 
class PizzaToppings implements PizzaAssemble{
    private String name;

    public PizzaToppings(String name){
        this.name = name;
    }

    @Override
    public void assemble(){
        System.out.println("Assembling " +name);
    }

}

// Composite class representing fully assembled Pizza

class FullyAssembledPizza implements PizzaAssemble{
    private List<PizzaAssemble> toppings = new ArrayList<>();

    public void addPart(PizzaAssemble topping) {
        toppings.add(topping);

    }

    public void removeTopping(PizzaAssemble topping){
        toppings.remove(topping);
    }

    @Override

    public void assemble(){
        System.out.println("Assembling the fully Assembled Pizza");
        for (PizzaAssemble topping : toppings) {
            topping.assemble();
        }
    }
}
}