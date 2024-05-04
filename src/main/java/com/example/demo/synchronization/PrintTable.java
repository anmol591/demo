package com.example.demo.synchronization;

public class PrintTable {
    public synchronized void printTable(int n) {
        for(int i=1;i<=20;i++) {
            System.out.println(i*n);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
