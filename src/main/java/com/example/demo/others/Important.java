package com.example.demo.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Important {
    //stream api examples
    //https://www.geeksforgeeks.org/stream-in-java/
    //Intermediate operations,terminal operations
    static void print(String[] words){
        Map<String, ArrayList> map = new HashMap<>();
        List<String> items = Arrays.stream(words)
                .map(x->x.toCharArray()).
                        map(y->{Arrays.sort(y); return new String(y); }).collect(Collectors.toList());
        List<String> capitalWords = Arrays.stream(words).map(String::toUpperCase).collect(Collectors.toList());
        List<String> t1 = Arrays.stream(words).filter(x->x.startsWith("a")).collect(Collectors.toList());
        List<String> t2 = Arrays.stream(words).sorted().collect(Collectors.toList());
        Stream.of(1,2,4,7).map(x->x*2).forEach(System.out::println);
        Set<Integer> t3 = Stream.of(7,8,2,7,6,8,2,9,0,8).collect(Collectors.toSet());
    }
}
