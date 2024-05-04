package com.example.demo.factory;

public class SmsNotification implements Notification{
    @Override
    public void sendNotification() {
        System.out.println("sending email notification");
    }
}
