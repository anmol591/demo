package com.example.demo.factory;

public class WebNotification implements Notification{
    @Override
    public void sendNotification() {
        System.out.println("sending web notification");
    }
}
