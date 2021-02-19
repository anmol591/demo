package com.example.demo.datastructure;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class DummyDriver {
    public static void main(String args[]){
     List<Integer> list1 = new LinkedList<>();
     list1.add(23);
     list1.add(12);
     list1.add(3);

     List<Integer> list2 = new LinkedList<>();
     list2.add(14);
     list2.add(89);
     list2.add(22);





    }

    public static Map<String,Object> createHashMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("Name","Anmol");
        map.put("Address","Karhari");
        map.put("occupation","Software");
        map.put("age",34);
        map.put("Timestamp",new Date());
        return map;
    }
}
