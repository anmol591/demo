package com.example.demo.others;

public abstract class AbstractAnimal {
    private String color;
    private int noOfLegs;
    private String breed;

    public AbstractAnimal(String color, int noOfLegs, String breed) {
        this.color = color;
        this.noOfLegs = noOfLegs;
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNoOfLegs() {
        return noOfLegs;
    }

    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void printBreedName(){
        System.out.println("Breed Name is: " + getBreed());
    }
}
