package com.example.demo.others;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//this class is used to practise problems
public class Main {
    static void printSubStr(String str,
                            int low, int high)
    {
        System.out.println(
                str.substring(
                        low, high + 1));
    }

    // This function prints the
    // longest palindrome substring
    // (LPS) of str[]. It also
    // returns the length of the
    // longest palindrome
    static int longestPalSubstr(String str)
    {
        // The result (length of LPS)
        int maxLength = 1;

        int start = 0;
        int len = str.length();

        int low, high;

        // One by one consider every
        // character as center
        // point of even and length
        // palindromes
        for (int i = 1; i < len; ++i) {
            // Find the longest even
            // length palindrome with
            // center points as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && str.charAt(low)
                    == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length
            // palindrome with center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str.charAt(low)
                    == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        System.out.print("Longest palindrome substring is: ");
        printSubStr(str, start, start + maxLength - 1);

        return maxLength;
    }

    public static void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int[] rows = new int[R];
        int[] cols = new int[C];


        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }


        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(rows[i]==1 || cols[j]==1)
                    matrix[i][j] = 0;
            }
        }

    }

    public static void printSpiral(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;

        int T = 0,B=rows-1,L=0,R=cols-1;
        int dir = 0;

        while(T<=B && L<=R){
            if(dir==0){
                for(int i=L;i<=R;i++)
                    System.out.print(mat[T][i] + " ");
                T++;
            }else if(dir == 1){
                for(int k = T;k<=B;k++)
                    System.out.print(mat[k][R] + " ");
                R--;
            }else if(dir == 2){
                for(int i=R;i>=L;i--)
                    System.out.print(mat[B][i] + " ");
                B--;
            }else if(dir == 3){
                for(int i=B;i>=T;i--)
                    System.out.print(mat[i][L] + " ");
                L++;
            }
            dir = (dir+1)%4;
        }

    }

    //solve in o(n) complexity
    static float getMedian(int arr[],int start,int end) {
        int size = end - start + 1;
        if(size%2 == 0){
            float m = arr[start+(size/2)];
            float n = arr[start+(size-1)/2];
            return (m+n)/2;
        }
        return arr[start+(size-1)/2];

    }

    static float find(int arr1[],int arr1_s,int arr1_e,int arr2[],int arr2_s,int arr2_e){
      if(arr1_e-arr1_s+1 == 2 && arr2_e-arr2_s+1 == 2){
         float x = Math.max(arr1[arr1_s],arr2[arr2_s]);
         float y = Math.min(arr1[arr1_e],arr2[arr2_e]);
         return (x+y)/2;
      }

      float m1 = getMedian(arr1,arr1_s,arr1_e);
      float m2 = getMedian(arr2,arr2_s,arr2_e);

      int m1Index = (arr1_s+arr1_e)/2;
      int m2Index = (arr2_s+arr2_e)/2;

      if(m1<m2)
          return find(arr1,m1Index,arr1_e,arr2,arr2_s,m2Index);
      return find(arr1,arr1_s,m1Index,arr2,m2Index,arr2_e);


    }

    static void printAnagrams(String[] words){
        if(words.length == 0){
            System.out.println("Array is empty");
        }
        Map<String, ArrayList> map = new HashMap<>();

        for(int i=0;i<words.length;i++){
            String word = words[i];
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newString = new String(letters);
            map.putIfAbsent(newString,new ArrayList());
            map.get(newString).add(words[i]);
        }

        for(Map.Entry m : map.entrySet()){
            System.out.println(m.getKey() + "-->>" + m.getValue());
        }

    }

    static void longestPalindromicSubstring(String str){
        int len = str.length();
        int low,high,start=0;
        int maxLength = 1;

        for(int i=1;i<len;i++){
            low = i-1;
            high = i+1;
            while(low >=0 && high<len && str.charAt(low) == str.charAt(high)){
                if(high-low+1 > maxLength){
                    start = low;
                    maxLength = high-low+1;
                }
                --low;
                ++high;
            }

            low = i-1;
            high = i;
            while(low >=0 && high<len && str.charAt(low) == str.charAt(high)){
                if(high-low+1 > maxLength){
                    start = low;
                    maxLength = high-low+1;
                }
                --low;
                ++high;
            }
        }

        System.out.println("Longest substring is:");
        printSubStr(str,start,start+maxLength-1);
    }

    static int titleToNumber(String s) {
        if (s == null) return -1;
        int sum = 0;
        // for each loop so we don't need to mess with index values.
        for (char c : s.toUpperCase().toCharArray()) {
            sum *= 26;
            int temp = c - 'A' + 1;
            sum += temp;
        }
        System.out.println(sum);
        return 0;
    }

    public static int checkException(){
        try {
            throw new NullPointerException();
            //return 4;
        } catch (NullPointerException e){
            System.out.println("Null pointer");;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 6;
    }

    public static void setOperations(){
        Set<Integer> hashset = new HashSet<>(Arrays.asList(new Integer[]{55,3,4,2}));
        hashset.add(7);
        System.out.println("set created is" + hashset);

        //intersection of two sets
        hashset.retainAll(Arrays.asList(67,8,2));
        System.out.println("Intersection of two sets is" + hashset);

        //union of two sets
        hashset.addAll(Arrays.asList(5,6,7));
        System.out.println("Union of two sets is" + hashset);

        System.out.println(hashset.contains(6));

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(6);
        treeSet.add(9);

    }

    public static void stackOperations(){
        Stack<Integer> st = new Stack<>();
        st.push(45);
        st.push(43);
        System.out.println("Popped element is" + (Integer)st.pop());
        System.out.println("Peek Element is" + st.peek());
        System.out.println("stack is empty" + st.isEmpty());
    }

    public static void getKey(String[] name){
        System.out.println(name.toString());
    }

    private static Node sortedMerge(Node a, Node b){
        Node result = null;
        if(a == null)
            return b;
        if(b == null)
            return a;
        if(a.data <= b.data){
            result = a;
            result.next = sortedMerge(a.next,b);
        }
        else{
            result = b;
            result.next = sortedMerge(a,b.next);
        }
       return result;
    }

    private static Node mergeKLists(Node arr[],int last){

        while (last != 0) {
            int i = 0, j = last;
            while(i<j){
                arr[i] = sortedMerge(arr[i],arr[j]);

                i++;
                j--;
                if(i>=j)
                    last = j;
            }
        }
        return arr[0];
    }


    public static void main(String[] args){
       LRUCache lruCache = new LRUCache(3);
       lruCache.set(1,3);
       lruCache.set(2,8);
       lruCache.set(3,9);
       lruCache.set(4,7);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.LruElement());
        //System.out.println(lruCache.MUsedElement());
    }
    //added comment

}
