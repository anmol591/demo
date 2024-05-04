package com.example.demo.snakeladder;

import lombok.Getter;

import java.util.Random;

public class Dice {
    @Getter
    private Integer maxValue = 7;

    private static final Random random = new Random();

    public int rollup() {
        int val =  random.nextInt(maxValue-1) + 1;
        System.out.println("value came after rolling " + val);
        return val;
    }

}
