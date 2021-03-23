package com.example.demo.others;

public class Dog extends AbstractAnimal {

    public Dog(String color, int noOfLegs, String breed){
        super(color,noOfLegs,breed);
    }

    public void getBreedName(){
        super.printBreedName();
    }


}
