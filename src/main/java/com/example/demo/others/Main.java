package com.example.demo.others;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class FloorAndCeil{
    int floor;
    int ceil;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCeil() {
        return ceil;
    }

    public void setCeil(int ceil) {
        this.ceil = ceil;
    }
}

class Pair{
    int first;
    Character second;

    Pair(int first, Character second){
        this.first = first;
        this.second = second;
    }
}

//this class is used to practise problems
public class Main {
    public static final Node EMPTY = new Node();
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static int R = 4;
    static int C = 4;
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

    //find minimum length string which contains all the characters in
    // longest string
    private static String findMinWindow(String str, String ptr){
        int strLength = str.length();
        int ptrLength = ptr.length();
      int ascii_str[] = new int[256];
      int ascii_ptr[] = new int[256];

      for(int i=0; i<ptrLength;i++){
          ascii_ptr[ptr.charAt(i)]++;
      }

      int minLength = Integer.MAX_VALUE, start = 0, startIndex = -1;
      int count  = 0;  //actually maintains no of times it appears in both str and ptr

      for(int j=0;j<strLength;j++){
          ascii_str[str.charAt(j)]++;
          if(ascii_ptr[str.charAt(j)] != 0 && ascii_str[str.charAt(j)] <= ascii_ptr[str.charAt(j)])
              count++;

          //this condition indicates that we found a substring which contains all the characters of ptr
          if(count == ptrLength){

              /*Minimize the window based on following conditions:
              1) any character occur in str more no of times than its occurence in pattern(ptr)
              2) that character not occur in pattern(ptr)
              * */
              while (ascii_str[str.charAt(start)] > ascii_ptr[str.charAt(start)]
                      || ascii_ptr[str.charAt(start)] == 0){
                  if(ascii_str[str.charAt(start)] > ascii_ptr[str.charAt(start)])
                      ascii_str[str.charAt(start)]--;
                  start++;

              }
              int len_window = j-start+1;
              if(minLength>len_window){
                 minLength = len_window;
                 startIndex = start;
              }
          }
      }
        return str.substring(startIndex,startIndex+minLength);
    }

    public static int countPaths(int[][] maze){
        // If the initial cell is blocked,
        // there is no way of moving anywhere
        if (maze[0][0]==-1)
            return 0;

        // Initializing the leftmost column
        for (int i = 0; i < R; i++)
        {
            if (maze[i][0] == 0)
                maze[i][0] = 1;

                // If we encounter a blocked cell
                // in leftmost row, there is no way
                // of visiting any cell directly below it.
            else
                break;
        }

        // Similarly initialize the topmost row
        for (int i =1 ; i< C ; i++)
        {
            if (maze[0][i] == 0)
                maze[0][i] = 1;

                // If we encounter a blocked cell in
                // bottommost row, there is no way of
                // visiting any cell directly below it.
            else
                break;
        }

        // The only difference is that if a cell
        // is -1, simply ignore it else recursively
        // compute count value maze[i][j]
        for (int i = 1; i < R; i++)
        {
            for (int j = 1; j <C ; j++)
            {
                // If blockage is found,
                // ignore this cell
                if (maze[i][j] == -1)
                    continue;

                // If we can reach maze[i][j] from
                // maze[i-1][j] then increment count.
                if (maze[i - 1][j] > 0)
                    maze[i][j] = (maze[i][j] +
                            maze[i - 1][j]);

                // If we can reach maze[i][j] from
                //  maze[i][j-1] then increment count.
                if (maze[i][j - 1] > 0)
                    maze[i][j] = (maze[i][j] +
                            maze[i][j - 1]);
            }
        }

        // If the final cell is blocked,
        // output 0, otherwise the answer
        return Math.max(maze[R - 1][C - 1], 0);
    }

    private static void printMatrix(int mat[][], int m, int n,
                                    int i, int j, int path[], int idx)
    {
        path[idx] = mat[i][j];

        // Reached the bottom of the matrix so we are left with
        // only option to move right
        if (i == m - 1)
        {
            for (int k = j + 1; k < n; k++)
            {
                path[idx + k - j] = mat[i][k];
            }
            for (int l = 0; l < idx + n - j; l++)
            {
                System.out.print(path[l] + " ");
            }
            System.out.println();
            return;
        }

        // Reached the right corner of the matrix we are left with
        // only the downward movement.
        if (j == n - 1)
        {
            for (int k = i + 1; k < m; k++)
            {
                path[idx + k - i] = mat[k][j];
            }
            for (int l = 0; l < idx + m - i; l++)
            {
                System.out.print(path[l] + " ");
            }
            System.out.println();
            return;
        }
        // Print all the paths that are possible after moving down
        printMatrix(mat, m, n, i + 1, j, path, idx + 1);

        // Print all the paths that are possible after moving right
        printMatrix(mat, m, n, i, j + 1, path, idx + 1);
    }

    static int longestUniqueSubsttr(String str)
    {
       int left = 0, right = 0;
       int result = Integer.MIN_VALUE;
       Set<Character> seen = new HashSet<>();
       while(right<str.length()){
           char c = str.charAt(right);
           if(seen.add(c)){
               result = Math.max(result,right-left+1);
               right++;
           }else{
               while(str.charAt(left)!=c){
                   seen.remove(str.charAt(left));
                   left++;
               }
               seen.remove(c);
               left++;
           }
       }
       return result;
    }

    static String removeAdjacentDuplicates(String str){ //not working for all the use cases
        StringBuilder output = new StringBuilder();
        output.append(str.charAt(0));
        int top = 0;
        int i;
        for(i=1;i<str.length();i++){
            if(str.charAt(i) != str.charAt(top)){
                output.append(str.charAt(i));
                top++;
            }else{
                while (i<str.length()){
                    if(str.charAt(i) == str.charAt(top)){
                        output.deleteCharAt(top);
                        top--;
                    }else{
                        output.append(str.charAt(i));
                        top++;
                    }
                    i++;
                }
            }
        }
        return output.toString();
    }

    static void containerUses(){
        Stack<Integer> st = new Stack<>();
        st.push(45);
        st.push(89);
        System.out.println(st.peek());
        st.pop();

    }

    static int findKthSmallest(com.example.demo.datastructure.Node root, AtomicInteger i, int k){
        if(root==null)
            return Integer.MAX_VALUE;
        int left = findKthSmallest(root.getLeft(),i,k);

        if(left != Integer.MAX_VALUE)
            return left;

        if(i.incrementAndGet() == k)
            return root.getData();

        return findKthSmallest(root.getRight(),i,k);

    }

    static void findFloorAndCeil(com.example.demo.datastructure.Node root,FloorAndCeil floorCeil,int key){
        if(root == null)
            return;
        while (root != null){
            if(key == root.getData()){
                floorCeil.setCeil(root.getData());
                floorCeil.setFloor(root.getData());
                break;
            }
            else if(key > root.getData()){
                floorCeil.setFloor(root.getData());
                root = root.getRight();
            }else{
                floorCeil.setCeil(root.getData());
                root = root.getLeft();
            }
        }

    }

   public static void printLexicographicallySmaller(String str,int start,int end){
        int[] freq = new int[26];
        for(int i=start;i<=end;i++){
            freq[str.charAt(i)-'a']++;
        }
        for(int j=25;j>=0;j--){
            if(freq[j]>0){
                int count = freq[j];
                while (count!=0){
                    System.out.print((char)('a'+j));
                    count--;
                }
            }
        }
   }

    private static void printString(int columnNumber)
    {
        // To store result (Excel column name)
        StringBuilder columnName = new StringBuilder();

        while (columnNumber > 0) {
            // Find remainder
            int rem = columnNumber % 26;

            // If remainder is 0, then a
            // 'Z' must be there in output
            if (rem == 0) {
                columnName.append("Z");
                columnNumber = (columnNumber / 26) - 1;
            }
            else // If remainder is non-zero
            {
                columnName.append((char)((rem - 1) + 'A'));
                columnNumber = columnNumber / 26;
            }
        }

        // Reverse the string and print result
        System.out.println(columnName.reverse());
    }

    public static boolean isAnagram(String a, String b){
       if(a.length() != b.length())
           return false;
       Map<Character,Integer> freq = new HashMap<>();
       for(int i=0;i<a.length();i++){
           freq.put(a.charAt(i),freq.getOrDefault(a.charAt(i),0)+1);
       }
       for(char c : b.toCharArray()){
           if(freq.containsKey(c)){
               Integer newVal = freq.get(c)-1;
               freq.put(c,newVal);
           }else{
               return false;
           }

           if(freq.get(c) == 0)
               freq.remove(c);
       }
       return freq.isEmpty();
    }

    public static void checkDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-1);
//        Long millisec = calendar.getTime().getTime();
//        calendar.setTimeInMillis(millisec);
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        Date newDate = new Date(calendar.getTime().getTime());
        System.out.println(newDate);
    }

    static int minDiff(int arr[], int n, int k) {
        int result = Integer.MAX_VALUE;

        // Sorting the array.
        Arrays.sort(arr);

        // Find minimum value among
        // all K size subarray.
        for (int i = 0; i <= n - k; i++)
            result = Math.min(result, arr[i + k - 1] - arr[i]);

        return result;
    }

    public static void findAns(int N) {
        // Base case
        if (N <= 2) {
            System.out.print("-1");
            return;
        }

        // Sum of first numbers upto N
        int value = (N * (N + 1)) / 2;

        // Answer don't exist
        if ((value & 1) == 1) {
            System.out.print("-1");
            return;
        }

        // To store the first set
        Vector<Integer> v1 = new Vector<Integer>();

        // To store the second set
        Vector<Integer> v2 = new Vector<Integer>();

        // When N is even
        if ((N & 1) == 0) {
            int turn = 1;
            int start = 1;
            int last = N;
            while (start < last) {
                if (turn == 1) {
                    v1.add(start);
                    v1.add(last);
                    turn = 0;
                } else {
                    v2.add(start);
                    v2.add(last);
                    turn = 1;
                }

                // Increment start
                start++;

                // Decrement last
                last--;
            }
        }

        // When N is odd
        else {

            // Required sum of the subset
            int rem = value / 2;

            // Boolean array to keep
            // track of used elements
            boolean[] vis = new boolean[N + 1];

            for (int i = 1; i <= N; i++)
                vis[i] = false;

            vis[0] = true;

            // Iterate from N to 1
            for (int i = N; i >= 1; i--) {
                if (rem > i) {
                    v1.add(i);
                    vis[i] = true;
                    rem -= i;
                } else {
                    v1.add(rem);
                    vis[rem] = true;
                    break;
                }
            }

            // Assigning the unused
            // elements to second subset
            for (int i = 1; i <= N; i++) {
                if (!vis[i])
                    v2.add(i);
            }
        }
        // Print the elements of first set
        System.out.print("Size of subset 1 is: ");
        System.out.println(v1.size());
        System.out.print("Elements of the subset are: ");

        for(Integer c : v1)
            System.out.print(c + " ");

        System.out.println();

        // Print the elements of second set
        System.out.print("Size of subset 2 is: ");
        System.out.println(v2.size());
        System.out.print("Elements of the subset are: ");

        for(Integer c : v2)
            System.out.print(c + " ");
    }


    private static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    private static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static Date getStartDate(int daysAgo){
        return createDateTime(0,0,0,0,daysAgo);
    }

    public static Date getEndDate(int daysAgo){
        return createDateTime(23,59,59,999,daysAgo);
    }

    private static Date createDateTime(int hour,int minute,int second,int millisecond,int daysAgo){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-daysAgo);
        //calendar.setTimeInMillis(calendar.getTime().getTime());
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,second);
        calendar.set(Calendar.MILLISECOND,millisecond);
        Date newDate = new Date(calendar.getTime().getTime());
        return newDate;
    }

    private static void localDateTime(){
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date is: " + currentDate);
        LocalDateTime dateTime = currentDate.minusDays(3).atStartOfDay(); //subtract and get start of days
        LocalDateTime endDateTime = currentDate.minusDays(3).atTime(LocalTime.MAX); // get end of day
        //DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Date start = convertLocalDateTimeToDate(dateTime);
        Date end = convertLocalDateTimeToDate(endDateTime);

        //System.out.println("Start DateTime: "+ start + "end dateTime: "+ end);
        setLocalDate();
    }

    private static void setLocalDate(){
        LocalDate date = LocalDate.now().with(ChronoField.DAY_OF_WEEK,5);
        System.out.println(date);
    }

    private static Date convertLocalDateTimeToDate(LocalDateTime dateTime){
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getNthDatefromCurrentDate(String N) {
        Date curDate = Calendar.getInstance().getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(N));
        return new Date(getStartOfDay(cal.getTime().getTime()));
    }

    public static Date getNthDateFromDate(Date date, int N) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, N);
        return cal.getTime();
    }

    public static void setTimeTo0(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
    }

    public static Long getStartOfDay(Long timeInMilliSeconds) {
        Calendar lastAccessDateCal = Calendar.getInstance();
        lastAccessDateCal.setTimeInMillis(timeInMilliSeconds);
        setTimeTo0(lastAccessDateCal);
        return lastAccessDateCal.getTimeInMillis();
    }

    public static void trigger(){
       Date dueDate = getNthDatefromCurrentDate("2");
        System.out.println("Due date is:" + dueDate);
        LocalDateTime date1 = dueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atStartOfDay();
        LocalDateTime date2 = dueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atTime(LocalTime.MAX);

        System.out.println("date1 is:" + date1);
        System.out.println("date2 is:" + date2);

        Date startDate = Date.from(date1.atZone(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(date2.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println("StartDate is: " + startDate);
        System.out.println("EndDate is: " + endDate);
    }

    public static void findLargest(StringBuilder str){
        int len = str.length();
        int loccur[] = new int[26];
        Arrays.fill(loccur,-1);
        char[] charArray = str.toString().toCharArray();
        for(int i=len-1;i>=0;i--){
            int pos = str.charAt(i) - 'a';
            if(loccur[pos] == -1)
                loccur[pos] = i;
        }
        char[] sorted_s = str.toString().toCharArray();
        Arrays.sort(sorted_s);
        reverse(sorted_s);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != sorted_s[i]){
              int lastOccur = loccur[sorted_s[i] - 'a'];
              char temp = str.charAt(i);
              str.setCharAt(i,str.charAt(lastOccur));
              str.setCharAt(lastOccur,temp);
              break;
            }
        }
        System.out.println(str.toString());
    }

    public static void reverse(char a[])
    {
        int i, n = a.length;

        for(i = 0; i < n / 2; i++)
        {
            char t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

    public static Date getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    private static void test1(){
        for(int i = 0;i<50;i++){
            test2(i);
        }
    }

    private static void test2(int i){
        if(i == 10)
            return;
        System.out.println(i);
    }

    public static int minCostClimbingStairs(int[] cost) {
        // The array's length should be 1 longer than the length of cost
        // This is because we can treat the "top floor" as a step to reach
        int minimumCost[] = new int[cost.length + 1];

        // Start iteration from step 2, since the minimum cost of reaching
        // step 0 and step 1 is 0
        for (int i = 2; i < minimumCost.length; i++) {
            int takeOneStep = minimumCost[i - 1] + cost[i - 1];
            int takeTwoSteps = minimumCost[i - 2] + cost[i - 2];
            minimumCost[i] = Math.min(takeOneStep, takeTwoSteps);
        }

        // The final element in minimumCost refers to the top floor
        return minimumCost[minimumCost.length - 1];
    }

    public static void constructMetadata(List<String> metaData,String errorCode,String msg){
      StringBuilder builder = new StringBuilder();
      builder.append(buildString("errorCode",errorCode));
      builder.append(buildString("errorMsg",msg));
      metaData.add(builder.toString());
    }

    private static String buildString(String fieldName,String value){
      return fieldName + ":" + value;
    }

    public static Date endOfDayOfGivenDate(@NotNull Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static HashMap<String, String> parseAdditionalInfo(String additionalInfoString) {
        HashMap<String, String> additionalInfoMap = new HashMap<>();
        // additionalInfoMap = Arrays.stream(additionalInfoString.split("\\|"))
        // .map(s -> s.split(":"))
        // .collect(Collectors.toMap(a -> a[0], a ->a[1]));
        List<String> additionalInfoList = Arrays.asList(additionalInfoString.split("\\|"));
        for (String keyval : additionalInfoList) {
            List<String> keyvallist = Arrays.asList(keyval.split(":", 2));
            additionalInfoMap.put(keyvallist.get(0), keyvallist.get(1));
        }
        return additionalInfoMap;
    }






    public static void main(String[] args) throws ParseException {
        String unmaskedString = "anmol";
//        String str2 = "kumar";
//        StringBuilder newStr = new StringBuilder(str1.substring(0,4)).append(str2.substring(1));
//        int prefixNoLen = 9;
//        int suffixNoLen = 9;
//        if (unmaskedString.length() > prefixNoLen + suffixNoLen) {
//            StringBuilder str = new StringBuilder(unmaskedString);
//            String maskString = StringUtils.repeat("*", str.length() - (prefixNoLen + suffixNoLen));
//            str.replace(prefixNoLen, str.length() - suffixNoLen, maskString);
//            unmaskedString = str.toString();
//        }
//
//        System.out.println(unmaskedString);
//        Pair pair1 = new Pair(15,new Character('d'));
//        Pair pair2 = new Pair(8,new Character('a'));
//        Pair pair3 = new Pair(20,new Character('a'));
//        List<Pair> arr = new ArrayList<>();
//        arr.add(pair1);
//        arr.add(pair2);
//        arr.add(pair3);
//       List<String> errorCode = new ArrayList<>();
//        constructMetadata(errorCode,"Int-678","some error occurred");
//        constructMetadata(errorCode,"Int-900","Exception occurred");
//        System.out.println(errorCode);
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.HOUR,10);
//        Date date = calendar.getTime();
//        System.out.println("Date is" + date);
//        System.out.println(formatter.format(date));

        try {
            for(int i=0;i<20;i++){
               if(i == 2){
                   throw new Exception("Exception occured");
               }
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("In final block");
        }


    }

}
