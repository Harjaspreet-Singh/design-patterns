package com.designpattern.singelton;


public class PaymentProcessor {

    private static PaymentProcessor object;  // private static instance variable.


    private PaymentProcessor(){      // private constructor 

    }


    public static PaymentProcessor getInstance(){//get instance to create a Singleton object

        if (object==null) // check if there is instance.
        object = new PaymentProcessor();// there was no instance, so we create new instance.
    return object;//return the instance.

    }


    public void process(String paymentdetails) {
        System.out.println("Processing payment: " + paymentdetails);
  
    }

}