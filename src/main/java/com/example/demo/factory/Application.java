package com.example.demo.factory;

public class Application {
    public static void main(String[] args) {
        Database database = new Database.DatabaseBuilder().setHost("dfdfdf").setPassword("dfdfd").setUserName("dffdfd").build();
        System.out.println(database.getHost());
    }


}
