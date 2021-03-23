package com.example.demo.others;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    private static final int DEFAULT_SIZE = 5;
    private static int front,rear,capacity;
    private static ArrayList<Integer> arr;

    public MyQueue(){
        this(DEFAULT_SIZE); //constructor chaining
    }

    public MyQueue(int size){
        capacity = size;
        front = rear = 0;
        arr = new ArrayList<>(capacity);

    }

    public void enqueue(int item) throws Exception {
        if(rear == capacity){
            throw new Exception("Queue overflow");

        }
        arr.add(rear, item);
        rear++;
    }

    public int dequeue() throws Exception {
        if(front == rear){
            throw new Exception("Queue underflow");
        }
        int item = arr.get(front);
        for(int i = 0;i<rear-1;i++){
            arr.add(i, arr.get(i + 1));
        }
        rear -- ;
        return item;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public void display(){
        for(int i=front;i<rear;i++){
            System.out.println(arr.get(i));
        }
    }

    public static void main(String args[]){
        MyQueue q = new MyQueue();
        try {
            q.enqueue(45);
            q.enqueue(75);
            q.enqueue(12);
            q.enqueue(90);
            q.enqueue(34);
            q.display();
            System.out.println("Deleted element is: " + q.dequeue());
            q.display();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
