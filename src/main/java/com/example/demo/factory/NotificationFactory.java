package com.example.demo.factory;

public class NotificationFactory {
    private Notification notification;

    public NotificationFactory(String obj){
        if(obj == "web"){
            notification = new WebNotification();
        } else if(obj == "sms"){
            notification = new SmsNotification();
        } else if(obj == "email"){
            notification = new EmailNotification();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void sendnotify(){
        notification.sendNotification();
    }
}
