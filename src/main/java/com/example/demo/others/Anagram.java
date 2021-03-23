package com.example.demo.others;

import lombok.var;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {
    public static void groupAnagrams(String[] words){
        List<String> list = Arrays.stream(words)
                .map(s -> s.toCharArray())
                .map(chars -> { Arrays.sort(chars); return new String(chars); })
                .collect(Collectors.toList());
        //System.out.println(list);

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++)
        {
            map.putIfAbsent(list.get(i), new ArrayList<>());
            map.get(list.get(i)).add(i);
        }
        for (var entry: map.entrySet()) {
            System.out.println(entry.getValue().stream()
                    .map(index -> words[index])
                    .collect(Collectors.toList()));
        }

    }

    public static void main(String args[]){
        String[] words = {
                "cat", "dog", "tac", "got", "act"
        };

       groupAnagrams(words);
    }
}
