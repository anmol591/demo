package com.example.demo;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Driver {


    public static void main(String[] args) {
        try {
            //get input data
            //key_name -> p1:v1,p2:v2,p3:v3
//            KeyStoreManagerImpl keyStoreManager = new KeyStoreManagerImpl();
//            List<ImmutablePair<String,String>> pairs = new ArrayList<>();
//            pairs.add(new ImmutablePair<>("name","anmol"));
//            pairs.add(new ImmutablePair<>("age","20"));
//
//            List<ImmutablePair<String,String>> pairs2 = new ArrayList<>();
//            pairs2.add(new ImmutablePair<>("BatchNo","67"));
//            pairs2.add(new ImmutablePair<>("cellNo","890"));
//
//            List<ImmutablePair<String,String>> pairs3 = new ArrayList<>();
//            pairs3.add(new ImmutablePair<>("RowNo","67"));
//            pairs3.add(new ImmutablePair<>("age","8"));
//
//            keyStoreManager.put("StrBNo1",pairs);
//            keyStoreManager.put("StrBNo2",pairs2);
//            keyStoreManager.put("serialNo",pairs3);
//
//            System.out.println(keyStoreManager.get("StrBNo2"));
              BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
              int n = Integer.parseInt(bufferedReader.readLine());
              while(n > 0){
                  System.out.println("Enter input");
                  String input = bufferedReader.readLine();
                  String[] input1 = input.split(" ");
                  String key = input1[0];
                  String val = input1[1];
                  System.out.println("value is: " + key + "and" + val);
                  n--;
              }

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    int value = 0;
//    // reads to the end of the stream
//            while((value = bufferedReader.read()) != -1) {
//
//        // converts int to character
//        char c = (char)value;
//
//        // prints character
//        System.out.println(c);
//    }
}
