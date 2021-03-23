package com.example.demo.others;

public class Cat extends AbstractAnimal{
    private boolean canmeow;

    public Cat(String color,int noOfLegs,boolean canmeow,String breed){
         super(color,noOfLegs,breed);
         this.canmeow = canmeow;
     }

    public void printBreed(){
        super.printBreedName();
    }
}
