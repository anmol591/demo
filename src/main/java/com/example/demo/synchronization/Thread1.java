package com.example.demo.synchronization;

public class Thread1 implements Runnable{
    PrintTable table;
    int n;
    public Thread1(PrintTable t,int n) {
        this.table = t;
        this.n = n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        table.printTable(this.n);
    }
}
