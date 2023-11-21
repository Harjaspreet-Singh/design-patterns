package com.designpattern.lazyInitialization;

public class LoadInstance{
    
    private static LoadInstance object;

    private LoadInstance(){

    }

    public static LoadInstance getInstance(){
        if(object == null){
            object = new LoadInstance();
        }
        return object;
    }


public void load(){
    System.out.println("Loading...");
}

}