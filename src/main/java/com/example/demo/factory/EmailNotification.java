package com.example.demo.factory;

public class EmailNotification implements Notification {
    @Override
    public void sendNotification() {
        System.out.println("sending email notification");
    }
}
