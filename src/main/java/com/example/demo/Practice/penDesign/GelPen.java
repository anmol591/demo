package com.example.demo.Practice.penDesign;

public class GelPen extends Pen{
    private Refillable refillable;

    public GelPen(Refillable refillable){
        this.refillable = refillable;
    }

    public void refill(){
        refillable.refill();
    }
    @Override
    protected void write() {
        System.out.println("Writing using gel pen behaviour");
    }


}
