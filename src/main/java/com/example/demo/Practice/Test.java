package com.example.demo.Practice;

public class Test {
    public static void main(String[] args){

     Database.DatabaseBuilder builder = new Database.DatabaseBuilder().withHost("dfdfd").withUser("dfdfd");
     Database database = new Database.DatabaseBuilder().build(builder);
        System.out.println(database.getHost());
        System.out.println(database.getUser());
        System.out.println(database.getPort());

    }
}
