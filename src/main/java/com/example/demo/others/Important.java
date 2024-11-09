package com.example.demo.others;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Important {
    static class Pair {
        private int first;
        private int second;

        public Pair(int f,int s){
            this.first = f;
            this.second = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
    //stream api examples
    //https://www.geeksforgeeks.org/stream-in-java/
    //Intermediate operations,terminal operations
    static void print(String[] words){
//        Map<String, ArrayList> map = new HashMap<>();
//        List<String> items = Arrays.stream(words)
//                .map(x->x.toCharArray()).
//                        map(y->{Arrays.sort(y); return new String(y); }).collect(Collectors.toList());
//        List<String> capitalWords = Arrays.stream(words).map(String::toUpperCase).collect(Collectors.toList());
//        List<String> t1 = Arrays.stream(words).filter(x->x.startsWith("a")).collect(Collectors.toList());
//        List<String> t2 = Arrays.stream(words).sorted().collect(Collectors.toList());
//        Stream.of(1,2,4,7).map(x->x*2).forEach(System.out::println);
//        Set<Integer> t3 = Stream.of(7,8,2,7,6,8,2,9,0,8).collect(Collectors.toSet());
        //boolean anyMatch(predicate) -> predicate is the condition which will return true/false
        //boolean allMatch(predicate)
        //boolean nonMatch(predicate)
        //stream filter(predicate)
        //map -> to convert an element after applying any operation
        List<Integer> nums = Arrays.asList(2,3,4,5,1);
        nums = nums.stream().sorted().collect(Collectors.toList());
        nums.stream().map(x->x+2).forEach(System.out::println);
        String str = "raghav";

        Function<String, Integer> function = (str1)->str.length();
        Supplier<Integer> function2 = str::length;
        Supplier<String> function3 = str::toUpperCase;

        Integer[] arr = new Integer[]{4,5,7,4,5,7,8};
        Map<Integer,Long> freMap = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Set<Integer> uniqueElement = freMap.entrySet().stream().filter(entry->entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toSet());
        System.out.println(uniqueElement);

        //split and then count frequency below using stream api
        List<String> list = Arrays.asList("101-djfdjf","901-klijkj","304-klkkk","101-fdkf","901-fdfc","901-klkdf kll");
        Map<Integer,Long> freq = list.stream().map(s->{String[] arr1 = s.split("-");return Integer.parseInt(arr1[0]);}).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Integer it = freq.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
        System.out.println(it);

        //convert into character stream and find frequency
        String str2 = "jkjfdf";
        Map<Character,Long> freqMap = str2.chars().mapToObj(x->(char) x).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        //find sum of age
//        int a = list.stream().map(Employee::getAge).reduce(0,Integer::sum);
        //find product
        //int c = Arrays.stream(arr).flatMap(Arrays::stream).reduce(1,(a,b)->a*b);

        //Q->How do you handle null values in streams?
        //Ans-Use Optional, filter out null values (filter(Objects::nonNull)), or handle them with default values using orElse or orElseGet

        //Q-Explain the difference between findFirst and findAny
        //Ans-findFirst returns the first element of the stream, whereas findAny may return any element
        // especially useful in parallel processing where any match suffices

        //Q-What is the difference between reduce and collect in Streams?
        //ans- reduce is for aggregating elements into a single result, while collect is more flexible and often used for mutable reduction
        // such as grouping or collecting elements into a collection

        //Q-How does parallel stream processing work in Java?
        //ans- Parallel streams divide the source into multiple parts and process them in parallel
        // utilizing multiple cores to improve performance on large datasets

        //Q-What are Collectors and how do they work with Streams?
        //Ans- Collectors are utilities for aggregating Stream elements,
        // such as Collectors.toList(), Collectors.joining(), or Collectors.groupingBy()

        //Q-find the longest string in a list using Streams?
        //Ans- Optional<String> longestString = list.stream().max(Comparator.comparingInt(String::length));

        //Q-concatenate a list of strings into a single comma-separated string using Streams?
        //Ans - String result = list.stream().collect(Collectors.joining(", "));

        //Q-find the average salary of employees using the Stream API?
        //Ans- double averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);

        //Q-4th largest element using java stream
        //Ans - Optional<Integer> fourthLargest = numbers.stream()
        //            .sorted((a, b) -> b - a)    // Sort in descending order
        //            .skip(3)                    // Skip the first 3 elements
        //            .findFirst();  
    }

    public static void findAllPair(int[] arr,int target){
        Set<Integer> set = new HashSet<>();
        Set<Pair> output = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(target-arr[i])) {
                Pair item = new Pair(arr[i],target-arr[i]);
                if(!output.contains(item))
                    output.add(item);
            }
            set.add(arr[i]);
        }
        for(Pair it : output){
            System.out.println(it.first + "," + it.second);
        }
    }

    public static void countPair(int[] arr,int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] count = {0};
        Arrays.stream(arr).forEach(num->{
            if(map.containsKey(target-num)){
                count[0] += map.get(target-num);
            }
            map.put(num,map.getOrDefault(num,0)+1);
        });
        System.out.println(count[0]);
    }

    public static void findPair2(int[] arr,int target){
        Set<Integer> set = new HashSet<>();
        Set<Pair> output = new HashSet<>();
        Arrays.stream(arr).forEach(num->{
            if(set.contains(target-num)){
                Pair item = new Pair(num,target-num);
                if(!output.contains(item)){
                    output.add(item);
                }
            }
            set.add(num);
        });

        output.stream().forEach((Pair x)-> System.out.println(x.first + "," + x.second));
    }

    public static void createMapUsingLambdaHandlingDuplicateValues() {
//        List<Employee> list = new ArrayList<>();
//        list.add(new Employee("anmol",33));
//        list.add(new Employee("raghav",33));
//        list.add(new Employee("suman",30));
//        list.add(new Employee("vibhav",30));
//        list.add(new Employee("radha",29));
//
        //create map of age as key and List<Employee> as value
//        Map<Integer,List<Employee>> map = list.stream().collect(Collectors.groupingBy(Employee::getAge));
//        map.entrySet().stream().forEach(System.out::println);
    }

    public static void groupAnagrams() {
//        List<List<String>> strList = new ArrayList<>();
//        strList.add(Arrays.asList("silent","dog"));
//        strList.add(Arrays.asList("cat"));
//        strList.add(Arrays.asList("act","god"));
//
//        Map<String,List<String>> map = strList.stream().flatMap(Collection::stream).collect(Collectors.groupingBy(x->{char[] arr = x.toCharArray();Arrays.sort(arr);return new String(arr);}));
//        map.entrySet().forEach(x-> System.out.println(x.getKey() + " " + x.getValue()));
    }

    //sort map based upon the employee age and return map in response
//    public static void main(String[] args) {
//        Map<Integer,Employee> map = new HashMap<>();
//        map.put(22,new Employee("anmol",33));
//        map.put(25,new Employee("raghav",20));
//        map.put(26,new Employee("aman",12));
//        map.put(27,new Employee("dipika",45));
//
//
//
//        List<Map.Entry<Integer,Employee>> list = new ArrayList<>(map.entrySet());
//        Collections.sort(list,new Comparator<Map.Entry<Integer,Employee>>(){
//            @Override
//            public int compare(Map.Entry<Integer,Employee> o1, Map.Entry<Integer,Employee> o2) {
//                return Integer.compare(o2.getValue().age,o1.getValue().age);
//            }
//        });
//
//        Map<Integer,Employee> sortedMap = new LinkedHashMap<>();
//        for(Map.Entry<Integer,Employee> it : list) {
//            sortedMap.put(it.getKey(),it.getValue());
//        }
//
//        System.out.println(sortedMap.entrySet());
//
//
//    }

    //solve above problem using lambda
//    public static void main(String[] args) {
//        // Map of Employee objects
//        Map<Integer, Employee> map = new HashMap<>();
//        map.put(23, new Employee("anmol", 55));
//        map.put(23, new Employee("pyasa", 35));
//        map.put(23, new Employee("vaibhav", 15));
//        map.put(23, new Employee("Raghav", 10));
//
//        // Sorting the map based on employee age
//        Map<Integer, Employee> sortedMap = map.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getAge)))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (oldValue, newValue) -> newValue, // Merge function for handling duplicate keys
//                        LinkedHashMap::new // Keep the order of sorted entries
//                ));
//
//        // Print the sorted map
//        sortedMap.forEach((key, employee) ->
//                System.out.println("Key: " + key + ", Name: " + employee.getName() + ", Age: " + employee.getAge())
//        );
//    }


//    public static void main(String[] args) {
//        List<List<String>> list = new ArrayList<>();
//        list.add(Arrays.asList("dog","cat","rat"));
//        list.add(Arrays.asList("tac","god","art"));
//        list.add(null);
//        list.add(Arrays.asList("tar",null));
//
//
//        Map<String,List<String>> map = list.stream().filter(Objects::nonNull).flatMap(x->x.stream().filter(Objects::nonNull)).collect(Collectors.groupingBy(y->{char[] chars = y.toCharArray();Arrays.sort(chars);return new String(chars);}));
//        map.entrySet().stream().forEach(x-> System.out.println(x.getKey() + " " + x.getValue()));
//    }

    public static void main(String[] args) {
        print(new String[]{});
    }
}
