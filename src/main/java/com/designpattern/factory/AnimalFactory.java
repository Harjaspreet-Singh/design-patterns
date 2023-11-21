package com.designpattern.factory;

public class AnimalFactory {
    // Product interface
    public interface Animal {
        void speak();
    }

    // Concrete product classes
    class Dog implements Animal {
        @Override
        public void speak() {
            System.out.println("Loyal");
        }
    }

    class Cat implements Animal {
        @Override
        public void speak() {
            System.out.println("Meow");
        }
    }

    // Factory class
    public Animal createAnimal(String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {
            return new Dog();
        } else if ("Cat".equalsIgnoreCase(animalType)) {
            return new Cat();
        } else {
            return null;
        }
    }
}

   
