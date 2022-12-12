package com.example.demo.Practice.penDesign;

public class NonRefillableBehaviour implements Refillable{
    @Override
    public void refill() {
        System.out.println("Non refillable behaviour");
    }
}
