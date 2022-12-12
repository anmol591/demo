package com.example.demo.Practice.penDesign;

public class Application {
    public static void main(String[] args){
        BallPen ballPen = new BallPen(new NonRefillableBehaviour());
        ballPen.write();
        ballPen.refill();

        GelPen gelPen = new GelPen(new RefillableBehaviour());
        gelPen.write();
        gelPen.refill();


        FountainPen fountainPen = new FountainPen();
        fountainPen.write();

    }
}
