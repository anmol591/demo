package com.example.demo.others;
import java.util.ArrayList;
import java.util.List;


//
//import java.util.Arrays;
//
////[1,2,5,3,7,4,1,5]
////find minimum no of steps from left to right
//public class Test {
//    public static int findMinimumNoOfPlateforms(int arr[],int dep[]){
//        Arrays.sort(arr);
//        Arrays.sort(dep);
//
//        int result = 1;
//        int plateformCount = 0;
//        int i=0,j=0;
//        while(i<arr.length && j<dep.length){
//            if(arr[i] < dep[j]){
//                plateformCount++;
//                i++;
//            }
//            else{
//                plateformCount--;
//                j++;
//            }
//            if(result<plateformCount)
//                result = plateformCount;
//        }
//       return result;
//    }
//  public static void main(String[] args){
//     int[] arr = {910,915,930,1015,1315};
//     int[] dep = {1015,1030,1045,1200,1100};
//      System.out.println(findMinimumNoOfPlateforms(arr,dep));
//  }
//}
public class Test {
    public static void main(String[] args) {
        List l = new ArrayList();
        addInteger(l);
        addString(l);
        System.out.println(l);
    }
    public static void addInteger(List l){
        l.add(4);
    }

    public static void addString(List l){
        l.add("abc");
    }
}
