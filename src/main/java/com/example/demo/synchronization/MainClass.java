package com.example.demo.synchronization;

public class MainClass {
    public static void main(String args[]) {

        PrintTable table = new PrintTable();
        Thread1 thread1 = new Thread1(table,5);
        Thread th1 = new Thread(thread1);
        th1.start();

        thread1.setN(2);
        Thread th2 = new Thread(thread1);

        th2.start();
    }
}
