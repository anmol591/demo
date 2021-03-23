package com.example.demo.others;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.util.Arrays;

public class Dequeue {
    private static int DEFAULT_SIZE = 5;
    private int front,rear,size;
    private int[] arr;
    private static final Double MONEY_MULTIPLER_CONSTANT = 100.0D;

    public Dequeue(){
     this(DEFAULT_SIZE);
    }

    public Dequeue(int size){
        this.size = size;
        front = rear = -1;
        arr = new int[this.size];
    }

    public void insertFront(int item){
      if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        if(front == -1){
            front = 0;
            rear = 0;
        }
        else if(front == 0)
            front = size - 1;
        else
            front --;

        arr[front] = item;
    }

    public void insertRear(int item){
       if(isFull()){
           System.out.println("Queue is full");
           return;
       }
       if(front == -1){
           front = 0;
           rear = 0;
       }
       else if(rear == size-1)
           rear = 0;
       else
           rear ++;
       arr[rear] = item;

    }

    public int deleteFront(){
       if(isEmpty()){
           System.out.println("Queue is empty");
           return -1;
       }
       int temp = arr[front];
       if(front == rear){
           front = -1;
           rear = -1;
       }
       else if(front == size-1)
           front = 0;
       else
           front ++;
       return temp;
    }

    public int deleteRear(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }

        int temp = arr[rear];

        if(front == rear){
            front = -1;
            rear = -1;
        }
        else if(rear == size -1)
            rear = 0;
        else
            rear --;
        return temp;
    }

    public boolean isFull(){
      return (front == 0 && rear == size-1) || (rear == (front-1)%(size-1));
    }

    public boolean isEmpty(){
      return front == -1;
    }

    public void display(){
        for(int i=0;i<size;i++){
            System.out.println(arr[i]);
        }
    }

    public static void getTransactionAmountInRupee() {
       String amt = "145699.99";
       //Long value = ((Float)Float.parseFloat(amt)).longValue();
        System.out.println(new BigDecimal(amt));
       //System.out.println(BigDecimal.valueOf(value)); //provide string object
        //to fix issue in subscription code
        //convert amount in rupee from request amount and then convert it to bigdecimal
        //also fix in initiateRenewSubscriptionContract method
        //also fix in activateRenewSubscriptionContract
    }

    public static void main(String args[]){
//        Dequeue d1 = new Dequeue();
//        d1.insertFront(34);
//        d1.insertFront(22);
//
//
//
//
//
//        Dequeue d2 = new Dequeue();
//        d2.insertFront(23);
//        d1.insertFront(26);
//        d1.display();
//        System.out.println("Next object");
//        d2.display();
//        getTransactionAmountInRupee();
        String str = "Geeksforgeeks";
        char[] count = new char[256];
        for(int i=0;i<str.length();i++){
            System.out.println("character value is "+ count[str.charAt(i)]);
            count[str.charAt(i)]++;
        }
        System.out.println(Arrays.asList(count));

    }
}
