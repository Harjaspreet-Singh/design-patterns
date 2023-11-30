package com.designpattern.mainclass;


import com.designpattern.singelton.PaymentProcessor;
import com.designpattern.factory.AnimalFactory;
import com.designpattern.interpreter.InterpreterExample;
import com.designpattern.interpreter.InterpreterExample.Add;
import com.designpattern.interpreter.InterpreterExample.Number;
import com.designpattern.interpreter.InterpreterExample.Subtract;
import com.designpattern.lazyInitialization.LoadInstance;
import java.beans.Expression;
import javax.swing.plaf.basic.BasicPanelUI;
import com.designpattern.Composite.CompositeExample;
import com.designpattern.abstractFactory.CarFactory;
import com.designpattern.builder.Car;
import com.designpattern.chainOfResponsebility.ChainOfResponsibilityExample;
import com.designpattern.chainOfResponsebility.ChainOfResponsibilityExample.Director;
import com.designpattern.chainOfResponsebility.ChainOfResponsibilityExample.Manager;
import com.designpattern.chainOfResponsebility.ChainOfResponsibilityExample.President;
import com.designpattern.command.CommandPatternDemo.Command;
import com.designpattern.command.CommandPatternDemo.Customer;
import com.designpattern.command.CommandPatternDemo.OrderMeatPizza;
import com.designpattern.command.CommandPatternDemo.OrderVeggiePizza;
import com.designpattern.command.CommandPatternDemo.PizzaKitchen;
import com.designpattern.bridge.bridgeExample;
import com.designpattern.decorator.DecoratorExample;
import com.designpattern.facade.PizzaBacker;
import com.designpattern.interpreter.InterpreterExample;
import com.designpattern.mediator.MediatorExample;
import com.designpattern.memento.PizzaSystem;
import com.designpattern.prototype.CarFactory.BmwCar;
import com.designpattern.prototype.CarFactory.CarStartPrototype;
import com.designpattern.prototype.CarFactory.MercedesCar;
import com.designpattern.prototype.CarFactory.TeslaCar;
import com.designpattern.proxy.ProxyExample;
import com.designpattern.proxy.ProxyExample.Pizza;
import com.designpattern.proxy.ProxyExample.PizzaProxy;
import com.designpattern.state.BrightnessControlSystem;
import com.designpattern.strategy.StrategyExample;
import com.designpattern.visitor.FamilyVisitorClient;
import com.designpattern.flyweight.FlyweightExample;
import com.designpattern.template.PizzaTemplateExample;
import com.designpattern.template.PizzaTemplateExample.VeggiePizza;
import com.designpattern.template.PizzaTemplateExample.MeatPizza;







public class application {
    public static  <CarStartPrototype, Toppings, ExpensivePizzaHandler, OvenSystem> void main(String[] args) {
        
        
        
        System.out.println("SINGELTON PATTERN");
        System.out.println("");
        
        PaymentProcessor paymentProcessor1 = PaymentProcessor.getInstance(); // This will give the first instance.
        PaymentProcessor paymentProcessor2 = PaymentProcessor.getInstance(); // This will give the second instance.

        if (paymentProcessor1 == paymentProcessor2) { // compare instance 1 and instance 2
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("The instances are not the same.");
        }

        paymentProcessor1.process("visa"); // this has the instance for the first one
        
        System.out.println("");
        System.out.println("Factory method");
        System.out.println("");
        // USING THE Factory Method
        AnimalFactory example = new AnimalFactory();

        AnimalFactory.Animal dog = example.createAnimal("Dog");
        dog.speak(); // Outputs "Loyal"

        AnimalFactory.Animal cat = example.createAnimal("Cat");
        cat.speak(); // Outputs "Meow"

        

        System.out.println("");
        System.out.println("Abstract factory");
        System.out.println("");
        //Using the abstract Factory method.
        //create Honda Factory
        
        
        CarFactory factory = new CarFactory();

       // Create Honda Factory
       CarFactory.VehicleFactory hondaFactory = new CarFactory.HondaFactory();

       // Use Honda Factory to create Honda Car
       CarFactory.Car hondaCar = hondaFactory.createCar();
       hondaCar.drive(); // Output: Driving a Honda car

       // Use Honda Factory to create Honda Motorcycle
       CarFactory.Motorcycle hondaMotorcycle = hondaFactory.createMotorcycle();
       hondaMotorcycle.ride(); // Output: Riding a Honda motorcycle

       // Create Toyota Factory
       CarFactory.VehicleFactory toyotaFactory = new CarFactory.ToyotaFactory();

       // Use Toyota Factory to create Toyota Car
       CarFactory.Car toyotaCar = toyotaFactory.createCar();
       toyotaCar.drive(); // Output: Driving a Toyota car

       // Use Toyota Factory to create Toyota Motorcycle
       CarFactory.Motorcycle toyotaMotorcycle = toyotaFactory.createMotorcycle();
       toyotaMotorcycle.ride(); // Output: Riding a Toyota motorcycle

       System.out.println("");
       System.out.println("Builder pattern");
       System.out.println("");
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

        
        System.out.println("");
        System.out.println("Lazy Initialization");
        System.out.println("");
         //using lazy initialization I took the ideas from the singelton pattern.
        LoadInstance instance = LoadInstance.getInstance();

        instance.load();

        

        System.out.println("");
        System.out.println("bridge pattern");
        System.out.println("");

        // Create Concrete Implementor Instances
        bridgeExample.Toppings meatToppings = new bridgeExample.MeatPizza();
        bridgeExample.Toppings vegToppings = new bridgeExample.VegPizza();
        bridgeExample.Pizza largeMeatPizza = new bridgeExample.Large(meatToppings);
        bridgeExample.Pizza smallVegPizza = new bridgeExample.Small(vegToppings);

        largeMeatPizza.assemble();
        smallVegPizza.assemble();

        System.out.println("");
        System.out.println("chain of Responsebility pattern");
        System.out.println("");

        Manager manager = new ChainOfResponsibilityExample.Manager();
        Director director = new ChainOfResponsibilityExample.Director();
        President president = new ChainOfResponsibilityExample.President();

        // Link the handlers to form a chain
        manager.handleRequest(800.0);   // Manager approves the purchase of 50 pizzas.
        manager.handleRequest(2500.0);  // Director can approve the request for 1000 pizzas.
        manager.handleRequest(15000.0); // The president approves the request for 1000 pizzas.
        manager.handleRequest(200000.0);// The request has been denied by all authorities of the company.

        System.out.println("");
        System.out.println("Command pattern");
        System.out.println("");

         PizzaKitchen pizzaKitchen = new PizzaKitchen();
        Command meatPizzaCommand = new OrderMeatPizza(pizzaKitchen);
        Command veggiePizzaCommand = new OrderVeggiePizza(pizzaKitchen);

        // Create a customer
        Customer customer = new Customer();

        // Set orders for the customer
        customer.setOrder(meatPizzaCommand);

        // Place the order
        customer.placeOrder(); // Making Chicken Pizza

        // Set another order for the customer
        customer.setOrder(veggiePizzaCommand);

        // Place the second order
        customer.placeOrder(); // Making Veggie Pizza

        System.out.println("");
        System.out.println("Composite Pattern");
        System.out.println("");

        CompositeExample.PizzaToppings pepperoni = new CompositeExample.PizzaToppings("Pepperoni");
        CompositeExample.PizzaToppings mushrooms = new CompositeExample.PizzaToppings("Mushrooms");

        // Creating FullyAssembledPizza
        CompositeExample.FullyAssembledPizza pizza = new CompositeExample.FullyAssembledPizza();

        // Adding toppings to the fully assembled pizza
        pizza.addPart(pepperoni);
        pizza.addPart(mushrooms);

        // Assembling the fully assembled pizza
        pizza.assemble();


        System.out.println("");
        System.out.println("Decorator pattern");
        System.out.println("");

        // Create a basic pizza
        DecoratorExample.PizzaOption basicPizza = new DecoratorExample.BasicPizza();

        // Add pepperoni to the pizza
        DecoratorExample.PizzaOption pepperoniPizza = new DecoratorExample.Pepperoni(basicPizza);

        // Add bacon crumble to the pizza with pepperoni
        DecoratorExample.PizzaOption baconPepperoniPizza = new DecoratorExample.BaconCrumble(pepperoniPizza);

        // Assemble and print the pizzas
        System.out.println("Basic Pizza:");
        basicPizza.assemble();

        System.out.println("\nPizza with Pepperoni:");
        pepperoniPizza.assemble();

        System.out.println("\nPizza with Bacon Crumble and Pepperoni:");
        baconPepperoniPizza.assemble();


        System.out.println("");
        System.out.println("Facade pattern");
        System.out.println("");

        PizzaBacker.OvenSystem ovenSystem = new PizzaBacker.OvenSystem();
        ovenSystem.bakePizza();
        System.out.println("");
        ovenSystem.turnOffOven();

        System.out.println("");
        System.out.println("Interpreter Example");
        System.out.println("");

         // Creating terminal expressions (numbers)
        Number five = new InterpreterExample.Number(5);
        Number ten = new InterpreterExample.Number(10);

        // Creating non-terminal expressions (addition and subtraction)
        Add addition = new InterpreterExample.Add(five, ten);
        Subtract subtraction = new InterpreterExample.Subtract(ten, five);

        // Evaluating expressions
        System.out.println("Result of addition: " + addition.interpret());        // Output: 15
        System.out.println("Result of subtraction: " + subtraction.interpret());  // Output: 5

        System.out.println("");
        System.out.println("Mediator Pattern");
        System.out.println("");

        // Create an instance of CarManufacture
        MediatorExample.CarManufacture carManufacture = new MediatorExample.CarManufacture();

        // Order a car through the mediator
        carManufacture.orderCar("Sedan");

        System.out.println("");
        System.out.println("Memento Pattern");
        System.out.println("");

         // Create instances of the pizza-related classes
         PizzaSystem.PizzaLife pizzaLife = new PizzaSystem.PizzaLife("Pepperoni", 100);
         PizzaSystem.FreshnessHistory freshnessHistory = new PizzaSystem.FreshnessHistory();
 
         // Save the initial state of the pizza
         PizzaSystem.PizzaName initialState = pizzaLife.save();
         freshnessHistory.save(initialState);
 
         // Simulate pizza decay
         pizzaLife.decay();
 
         // Save the updated state of the pizza
         PizzaSystem.PizzaName updatedState = pizzaLife.save();
         freshnessHistory.save(updatedState);
 
         // Undo to the previous state
         PizzaSystem.PizzaName previousState = freshnessHistory.undo();
         pizzaLife.restore(previousState);
 
         // Display the final state of the pizza
         System.out.println("Final Pizza State:");
         System.out.println("Pizza Name: " + previousState.getPizzaName());
         System.out.println("Freshness Level: " + previousState.getFreshnessLevel());

         System.out.println("");
         System.out.println("Prototype Pattern");
         System.out.println("");
        
         com.designpattern.prototype.CarFactory.CarCompany carCompany = new com.designpattern.prototype.CarFactory.CarCompany();

        carCompany.addCarStartPrototype("Mercedes", new MercedesCar());
        carCompany.addCarStartPrototype("BMW", new BmwCar());
        carCompany.addCarStartPrototype("Tesla", new TeslaCar());

        com.designpattern.prototype.CarFactory.CarStartPrototype mercedesPrototype = carCompany.getCar("Mercedes");
        mercedesPrototype.start();

        com.designpattern.prototype.CarFactory.CarStartPrototype bmwPrototype = carCompany.getCar("BMW");
        bmwPrototype.start();

        com.designpattern.prototype.CarFactory.CarStartPrototype teslaPrototype = carCompany.getCar("Tesla");
        teslaPrototype.start();
        

        System.out.println("");
        System.out.println("Proxy Pattern");
        System.out.println("");

        Pizza newpizza = new PizzaProxy("Pepperoni", 25);
        newpizza.order();

        System.out.println("");
        System.out.println("State Pattern");
        System.out.println("");

        // Create an instance of BrightnessControlSystem.Brightness
        BrightnessControlSystem.Brightness brightness = new BrightnessControlSystem.Brightness();

        // Press the button to change the state
        brightness.pressButton();
        System.out.println("Current State: " + brightness);
    
        // Press the button again to change the state
        brightness.pressButton();
        System.out.println("Current State: " + brightness);
    
        // Press the button once more to change the state
        brightness.pressButton();
        System.out.println("Current State: " + brightness);

        System.out.println("");
        System.out.println("Strategy Pattern");
        System.out.println("");

        StrategyExample.Restaurant cheesePizza = new StrategyExample.CheesePizza();
        StrategyExample.Restaurant pineapplePizza = new StrategyExample.PineapplePizza();

        // Create instances of the context class and set the desired strategy
        StrategyExample.PlaceOrder order1 = new StrategyExample.PlaceOrder(cheesePizza);
        StrategyExample.PlaceOrder order2 = new StrategyExample.PlaceOrder(pineapplePizza);

        // Place orders
        order1.placeOrder(); // Output: Placing the order\nMaking Margherita Pizza
        order2.placeOrder(); // Output: Placing the order\nMaking Pineapple Pizza

        System.out.println("");
        System.out.println("Visitor pattern");
        System.out.println("");

        // Create an instance of the Family
        FamilyVisitorClient.Family family = new FamilyVisitorClient.Family();

        // Create an instance of the FamElementPrintVisitor
        FamilyVisitorClient.FamElementPrintVisitor visitor = new FamilyVisitorClient.FamElementPrintVisitor();
    
        // Accept the visitor to visit each family member
        family.accept(visitor);

        System.out.println("");
        System.out.println("Flyweight Pattern");
        System.out.println("");

         // Use the PizzaFactory to get pizza instances
         FlyweightExample.Pizza meatPizza1 = FlyweightExample.PizzaFactory.getPizza("Meat Pizza", "Chicken", "");
         FlyweightExample.Pizza meatPizza2 = FlyweightExample.PizzaFactory.getPizza("Meat Pizza", "Beef", "");
         FlyweightExample.Pizza veggiePizza1 = FlyweightExample.PizzaFactory.getPizza("Veggie Pizza", "", "Mushrooms");
         FlyweightExample.Pizza veggiePizza2 = FlyweightExample.PizzaFactory.getPizza("Veggie Pizza", "", "Spinach");
 
         // Now, you can bake the pizzas
         meatPizza1.bake();
         meatPizza2.bake();
         veggiePizza1.bake();
         veggiePizza2.bake();

         System.out.println("");
         System.out.println("Template pattern");
         System.out.println("");

         VeggiePizza veggiePizza = new VeggiePizza();
        veggiePizza.preparePizza();
        System.out.println("");
        MeatPizza meatPizza = new MeatPizza();
        meatPizza.preparePizza();





        










        





        






                






        }
    }
    

        
  
 














   







  