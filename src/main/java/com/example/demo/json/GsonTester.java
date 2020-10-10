package com.example.demo.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonTester {
    public static void main(String args[]) throws IOException {
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        Gson gson = builder.create();

        String jsonString = "{\"name\": \"anmol\",\"age\":21,\"last\":\"kumar\"}";

        Student student = gson.fromJson(jsonString,Student.class); //from json string to student object
        writeJson(student);
        System.out.println(readJson());

//        jsonString = gson.toJson(student); // from student object to json


    }

    private static void writeJson(Object object) throws IOException {
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        Gson gson = builder.create();
        String jsonString = gson.toJson(object);
        FileWriter writer = new FileWriter("mapping1.json");
        writer.write(jsonString);
        writer.close();
    }

    private static Student readJson() throws FileNotFoundException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("mapping1.json"));
        Student student = gson.fromJson(bufferedReader,Student.class);
        return student;
    }


}
