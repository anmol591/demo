package com.example.demo.datastructure;

public class NewThread implements Runnable {

    @Override
    public void run(){
        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            System.out.println("Exception raised...existing");
        }

    }

    /* one way to create thread is
    Thread thread = new Thread(new Runnable() {
              @Override
              public void run() {
                  System.out.println("Current thread is: " + Thread.currentThread().getName());
              }
          });
    * */

    /*second way to create thread is to implement Runnable interface
    class NewThread implements Runnable{
    @Override
    void run(){
    System.out.println("Current thread is: " + Thread.currentThread().getName());
    }
    }
    Thread thread = new Thread(new NewThread());
    thread.start();
    * */
}
