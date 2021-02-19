package com.example.demo.datastructure;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Driver {
    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree();
//        tree.root = new Node(20);
//        tree.root.setLeft(new Node(8));
//        tree.root.setRight(new Node(22));
//        tree.root.getLeft().setRight(new Node(3));
//        tree.root.getRight().setLeft(new Node(4));
//        tree.root.getLeft().setLeft(new Node(5));
//        tree.root.getLeft().getRight().setRight(new Node(14));
//        tree.root.getLeft().getRight().setLeft(new Node(10));
//        tree.root.getRight().setRight(new Node(25));
//        BinaryTree.bottomView(tree.root);
//        Long i = new Long("3456.78");
//        LocalDate endDate = currentDate.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toLocalDate();
//        List<Integer> items= new ArrayList<>();
//        System.out.println();
//        System.out.println(endDate.atStartOfDay());
//        Integer d = checkException();
//        System.out.println("the value is" + d);
//        System.out.println(BigDecimal.valueOf(i));
//        MultivaluedMap<String,Object> entity = new MultivaluedHashMap();
//        entity.add("Authorization", "Basic " + checkFun());
//         boolean flag = new BigDecimal("5000").compareTo(new BigDecimal("1000").divide(new BigDecimal("100"))) < 0;
//        System.out.println(flag);
        Thread thread = new Thread(new NewThread());
        thread.start();
        //thread.interrupt();
        System.out.println("Current thread is: "+Thread.currentThread().getName());



    }

    public static Calendar adjustEndDays(Calendar calendar, int startDays) {
        int renewDays = calendar.get(Calendar.DAY_OF_MONTH);
        int maxDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (renewDays != maxDaysInMonth && renewDays < startDays)
            if (startDays < maxDaysInMonth)
                calendar.set(Calendar.DAY_OF_MONTH, startDays);
            else
                calendar.set(Calendar.DAY_OF_MONTH, maxDaysInMonth);

        return calendar;
    }

    public static Integer checkException(){
        Integer renewNo = 1;
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return renewNo;
    }

    public static String checkFun(){
        return null;
    }

}
