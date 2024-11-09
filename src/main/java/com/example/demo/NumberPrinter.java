package com.example.demo;

//write a program using 3 threads such that thread1 prints 1,thread2 prints 1,thread3 prints 1,thread1 prints 2,
//        thread2 prints 2,thread3 prints 2 and so on upto given n in java
public class NumberPrinter {
    private final int n;
    private int currentNumber = 1;
    private int currentThread = 1;

    public NumberPrinter(int n) {
        this.n = n;
    }

    public synchronized void printNumber(int threadNumber) {
        for (int i = 1; i <= n;) {
            while (currentThread != threadNumber) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }

            System.out.println("Thread " + threadNumber + " prints: " + i);
            currentThread = currentThread % 3 + 1; // Move to next thread
            notifyAll();
            i++;
        }
    }

    public static void main(String[] args) {
        int n = 5; // Example value, you can change it to any desired value
        NumberPrinter numberPrinter = new NumberPrinter(n);

        Thread thread1 = new Thread(() -> numberPrinter.printNumber(1));
        Thread thread2 = new Thread(() -> numberPrinter.printNumber(2));
        Thread thread3 = new Thread(() -> numberPrinter.printNumber(3));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
