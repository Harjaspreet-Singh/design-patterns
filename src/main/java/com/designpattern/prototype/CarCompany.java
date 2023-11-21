package com.designpattern.prototype;

import java.util.HashMap;
import java.util.Map;

//prototype Interface
interface CarStartPrototype{
    CarStartPrototype clone();
    void start();
   
   
}

//Concrete prototype classes to turn on different car models
//this line declares a class Mercedes class that implements CarStartPrototype Interface 
class MercedesCar implements CarStartPrototype{
    //This is an annotation that shows that the following method is intended to Override a method from the interface. In this case its used for clone method.
    @Override
    //This line defines the clone method. 
    public CarStartPrototype clone(){
        //A new instance is created with the clone method using the constructor, making a good copy of the MercedesCar object.
        return new MercedesCar();
    }
    //This Override means that the following method start() is to Override a method from the Interface.
    @Override
    //This line is responsible for starting the car.
    public void start() {
        //This line is the implentation of the start() with the output message indicating that the car has been started.
        System.out.println("Starting Mercedes Car");
    }


}
class BmwCar implements CarStartPrototype{
    @Override
    public CarStartPrototype clone(){
        return new BmwCar();
    }

    @Override
    public void start(){
        System.out.println("Starting BMW car");
    }

}
class TeslaCar implements CarStartPrototype{
    @Override
    public CarStartPrototype clone(){
        return new TeslaCar();

    }
    @Override
    public void start(){
        System.out.println("Starting Tesla car");
    }
}

//class name is CarCompany
public class CarCompany {
    //Here a private variable carStartPrototypes is declared. It is initialized as an empty hashmap when the CarCompany Object is created. 
    private Map<String , CarStartPrototype> carStartPrototyopes = new HashMap<>();
    //Public method addCarStartPrototype, which is used to add car prototypes to the carStartPrototypes map. This method takes two parameters (STRING,OBJECT)
    public void addCarStartProtype(String StartButton, CarStartPrototype carStartPrototype){
        //This line adds a new entry to the carStartProtypes map. The StartButton is used as the key and the carStartProtype is stored as associated value.
        carStartPrototyopes.put(StartButton, carStartPrototype);

    }

    //This line is public and is used to retrive a car prototype from the carStartPrototypes map based on StartButton. This method takes a single parameter which is a STRING in this case.
    public CarStartPrototype getCar(String StartButton) {
        // with the .get it will retrieve the StartButton from the carStartPrototypes map and then with the clone method, which he has retrieved prototype to create a copy oof the car prototype.
        return carStartPrototyopes.get(StartButton).clone();
    }
}