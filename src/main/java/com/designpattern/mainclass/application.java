package com.designpattern.mainclass;


import com.designpattern.singelton.PaymentProcessor;
import com.designpattern.factory.AnimalFactory;
import com.designpattern.lazyInitialization.LoadInstance;
import com.designpattern.prototype.CarCompany;
import com.designpattern.abstractFactory.CarFactory;
import com.designpattern.builder.Car;







public class application {
    public static  void main(String[] args) {
        PaymentProcessor paymentProcessor1 = PaymentProcessor.getInstance(); // This will give the first instance.
        PaymentProcessor paymentProcessor2 = PaymentProcessor.getInstance(); // This will give the second instance.

        if (paymentProcessor1 == paymentProcessor2) { // compare instance 1 and instance 2
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("The instances are not the same.");
        }

        paymentProcessor1.process("visa"); // this has the instance for the first one
        

        // USING THE Factory Method
        AnimalFactory example = new AnimalFactory();

        AnimalFactory.Animal dog = example.createAnimal("Dog");
        dog.speak(); // Outputs "Loyal"

        AnimalFactory.Animal cat = example.createAnimal("Cat");
        cat.speak(); // Outputs "Meow"

        
        //Using the abstract Factory method.
        //create Honda Factory
        
        
        CarFactory factory = new CarFactory();

        // Create a HondaFactory and use it to create vehicles
        CarFactory hondaFactory = factory.new HondaFactory();
        Car hondaCar = hondaFactory.createCar();
        Motorcycle hondaMotorcycle = hondaFactory.createMotorcycle();

        // Create a ToyotaFactory and use it to create vehicles
        CarFactory.ToyotaFactory toyotaFactory = factory.new ToyotaFactory();
        Car toyotaCar = toyotaFactory.createCar();
        Motorcycle toyotaMotorcycle = toyotaFactory.createMotorcycle();

        // Use the vehicles
        hondaCar.drive();
        hondaMotorcycle.ride();

        toyotaCar.drive();
        toyotaMotorcycle.ride();


        // Using the Builder Pattern

        Car car = new Car.CarBuilder()
                .setBrand("BMW")
                .setEngine("V6")
                .setID("1445")
                .setModel("Sports")
                .build();

                //Accessing car properties
                System.out.println("Brand: " + car.getBrand());
                System.out.println("Model: " + car.getModel());
                System.out.println("Engine: " + car.getEngine());
                System.out.println("Id: " +car.getId());



        // Using the Prototype pattern
         // Create car prototypes
         CarStartPrototype mercedes = new MercedesCar();
         CarStartPrototype bmw = new BmwCar();
         CarStartPrototype tesla = new TeslaCar();
 
         // Create a CarCompany instance
         CarCompany carCompany = new CarCompany();
 
         // Add car prototypes to the CarCompany
         carCompany.addCarStartProtype("Mercedes", mercedes);
         carCompany.addCarStartProtype("BMW", bmw);
         carCompany.addCarStartProtype("Tesla", tesla);
 
         // Get and start cars
         CarStartPrototype clonedMercedes = carCompany.getCar("Mercedes");
         clonedMercedes.start();
 
         CarStartPrototype clonedBmw = carCompany.getCar("BMW");
         clonedBmw.start();
 
         CarStartPrototype clonedTesla = carCompany.getCar("Tesla");
         clonedTesla.start();

         //using lazy initialization I took the ideas from the singelton pattern.
        LoadInstance instance = LoadInstance.getInstance();

        instance.load();


        }
    }
    

        
  
 














   







  