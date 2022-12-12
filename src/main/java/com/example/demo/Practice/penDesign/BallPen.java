package com.example.demo.Practice.penDesign;

public class BallPen extends Pen{
    private Refillable refillable;

    public BallPen(Refillable refillable){
        this.refillable = refillable;
    }

    public void refill(){
        refillable.refill();
    }

    @Override
    protected void write() {
        System.out.println("writing using ball pen behaviour");
    }
}
