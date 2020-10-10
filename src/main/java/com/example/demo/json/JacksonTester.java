package com.example.demo.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonTester {
    public static void main(String args[]) throws IOException {
        //deserialize equivalent to parse
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
//        String jsonString = "{\"Name\": \"anmol\",\"Age\":21,\"last\":\"kumar\"}";
//
//        Student student = objectMapper.readValue(jsonString,Student.class);  //to read json string
//        System.out.println(student);




        Student student = new Student();
        student.setName("anmol");
        student.setAge(23);
        student.setAddress("karhari");

        int arr[] = {1,2,3};

        Map<String,Object> mapping = new HashMap<>();
        mapping.put("student",student);
        mapping.put("isRecord",Boolean.TRUE);
        mapping.put("values",arr);
        //data binding from map object to json string
        objectMapper.writeValue(new File("mapping.json"),mapping);
        //data binding from json file to map
        Map<String,Object> obj = objectMapper.readValue(new File("mapping.json"),Map.class);

        System.out.println(obj.get("student"));
//
//        jsonString = objectWriter.writeValueAsString(student); //to convert into json string
//        System.out.println(jsonString);
    }
}
