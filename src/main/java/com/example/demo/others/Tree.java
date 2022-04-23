package com.example.demo.others;

import com.example.demo.datastructure.QueueObj;
import org.apache.commons.collections.CollectionUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class FindLevel{
    public static int level = 0;
}

class NodeObj{
    int hd;
    Node1 node;

    public NodeObj(int hd,Node1 node){
        this.hd = hd;
        this.node = node;
    }
}

class MaxLevel{
     int maxLevel;
}

public class Tree {
   public static Node1 root = null;



   public static void printTopView(){
      Map<Integer,Integer> map = new TreeMap<>();
      topViewUtil(map);
      for(Map.Entry m : map.entrySet()){
         System.out.println(m.getValue());
      }

   }

   private static void topViewUtil(Map<Integer,Integer> map){
      if(root == null)
         return;

      Queue<QueueObj1> q = new LinkedList<>();
      q.add(new QueueObj1(root,0));

      while(!q.isEmpty()){
         QueueObj1 item = q.poll();
         if(!map.containsKey(item.getHd())){
            map.put(item.getHd(), item.getNode().getData());
         }
         if(null != item.getNode().getLeft()){
            q.add(new QueueObj1(item.getNode().getLeft(),item.getHd()-1));
         }
         if(null != item.getNode().getRight()){
            q.add(new QueueObj1(item.getNode().getRight(),item.getHd() + 1));
         }
      }
   }

   private static int height(Node1 root){
      if(root == null)
          return 0;
      int lheight = height(root.getLeft());
      int rheight = height(root.getRight());
      return (lheight > rheight ? lheight + 1 : rheight+1);
   }

   public static void printSpiral(){
       Deque<Node1> deque = new ArrayDeque<>();

       boolean flag = false;
       deque.addLast(root);
       while (!deque.isEmpty()){
           int size = deque.size();
           if(flag){
               //print left to right
               while (size > 0){
                   Node1 item = deque.pollFirst();
                   System.out.print(item.getData() + " ");
                   if(item.getLeft() != null)
                       deque.addLast(item.getLeft());
                   if(item.getRight() != null)
                       deque.addLast(item.getRight());

                   size--;
               }

           }else{
               while(size > 0){
                   Node1 item = deque.pollLast();
                   System.out.println(item.getData() + " ");
                   if(item.getRight() != null)
                       deque.addFirst(item.getRight());
                   if(item.getRight() != null)
                       deque.addFirst(item.getLeft());
                   size --;
               }

           }
           flag = !flag;
           System.out.println();
       }
   }

   public static int lca(int n1, int n2){
     if(root == null)
         return -1;
       List<Integer>path1 = new ArrayList<>();
       List<Integer>path2 = new ArrayList<>();

     if(!findPath(root,n1,path1) || !findPath(root,n2,path2))
         System.out.println("Either n1 or n2 is absent");

     for(int i = 0; i< path1.size() && i< path2.size(); i++){
         if(path1.get(i) != path2.get(i))
             return path1.get(i-1);
     }
    return -1;
   }

   private static boolean findPath(Node1 root,int key,List<Integer> path){
      if(root == null)
          return false;
      path.add(root.getData());
      if(root.getData() == key)
          return true;
      if(root.getLeft() != null && findPath(root.getLeft(),key,path) || root.getRight() != null && findPath(root.getRight(),key,path))
          return true;

      path.remove(path.size() - 1);
      return false;
   }

   public static void findLevel(Node1 root,Node1 x,int index,FindLevel level){
       if(root == null)
           return;
       if(root.getData() == x.getData()){
          level.level = index;
       }


       findLevel(root.getLeft(),x,index+1,level);

       findLevel(root.getRight(),x,index+1,level);

   }

   public static int findMaxSumPath(Node1 root, AtomicInteger maxSum){
       if(root == null)
           return 0;
       int left = findMaxSumPath(root.getLeft(),maxSum);
       int right = findMaxSumPath(root.getRight(),maxSum);

       if(root.getLeft() == null)
           return root.getData() + right;
       if(root.getRight() == null)
           return root.getData() + left;

       int currSum = left + right + root.getData();
       maxSum.set(Math.max(currSum,maxSum.get()));
       return Math.max(left,right) + root.getData();
   }

   public static int kthSmallest(Node1 root,AtomicInteger i, int k){
       if(root == null)
           return Integer.MAX_VALUE;
       int left = kthSmallest(root.getLeft(),i,k);

       if(left != Integer.MAX_VALUE)
           return left;

       if(i.incrementAndGet() == k)
           return root.getData();
       return kthSmallest(root.getRight(),i,k);
   }

    public static Long getStartOfDay(Long timeInMilliSeconds) {
        Calendar lastAccessDateCal = Calendar.getInstance();
        lastAccessDateCal.setTimeInMillis(timeInMilliSeconds);
        setTimeTo0(lastAccessDateCal);
        return lastAccessDateCal.getTimeInMillis();
    }

    public static void setTimeTo0(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
    }

    public static void getMillisecondsTillStartOfNextDay() {
        long milliscondsInADay = 24l * 60l * 60l * 1000l;
        Long startOfDay = getStartOfDay(System.currentTimeMillis());
        Long endOfDay = getEndOfDay(System.currentTimeMillis());
        long timeInmilli = System.currentTimeMillis() - startOfDay;

        Long diff = endOfDay - startOfDay;
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.MILLISECOND, diff.intValue());


        //calendar.setTime(currentDate);

        System.out.println(cal.getTime());
    }

    public static int findIndexofZero(int[] A)
    {
        int max_count = 0;          // stores maximum number of 1's (including 0)
        int max_index = -1;         // stores index of 0 to be replaced

        int prev_zero_index = -1;   // stores index of previous zero
        int count = 0;              // stores current count of zeros

        // consider each index `i` in the array
        for (int i = 0; i < A.length; i++)
        {
            // if the current element is 1
            if (A[i] == 1) {
                count++;
            }
            // if the current element is 0
            else {
                // reset count to 1 + number of ones to the left of current 0
                count = i - prev_zero_index;

                // update `prev_zero_index` to the current index
                prev_zero_index = i;
            }

            // update maximum count and index of 0 to be replaced if required
            if (count > max_count)
            {
                max_count = count;
                max_index = prev_zero_index;
            }
        }

        // return index of 0 to be replaced or -1 if the array contains all 1's
        return max_index;
    }
    public static Long getEndOfDay(Long timeInMilliSeconds){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMilliSeconds);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
    }

    public static void printVertical(Node1 root){
       if(root == null)
           return;
       Map<Integer,List<Integer>> map = new HashMap<>();
       int hd = 0;
       printVerticalUtil(root,map,hd);
       for(Map.Entry m: map.entrySet()){
           System.out.println(m.getKey() + " " + m.getValue());
       }
    }

    private static void printVerticalUtil(Node1 root,Map<Integer,List<Integer>>map,int hd){
        if(root == null)
            return;
        List<Integer> temp = map.get(hd);
        if(temp == null)
           temp = new ArrayList<>();

            temp.add(root.getData());
            map.put(hd,temp);

        printVerticalUtil(root.getLeft(),map,hd-1);
        printVerticalUtil(root.getRight(),map,hd+1);
    }

    public static void bottomViewUtil(Node1 root,Map<Integer,Integer> map){
        if(root == null)
            return;
        Queue<NodeObj> q = new LinkedList<>();
        q.add(new NodeObj(0,root));

        while(!q.isEmpty()){
            NodeObj temp = q.poll();
            map.put(temp.hd, temp.node.getData());
            if(temp.node.getLeft() != null)
                q.add(new NodeObj(temp.hd-1,temp.node.getLeft()));
            if(temp.node.getRight() != null)
                q.add(new NodeObj(temp.hd+1, temp.node.getRight()));
        }
    }

    private static void bottomView(Node1 root){
       if(root == null)
           return;
        Map<Integer,Integer> map = new HashMap<>();
        bottomViewUtil(root,map);
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    public static void rightView(Node1 root){
       if(root == null)
           return;

       MaxLevel maxLevel = new MaxLevel();
       maxLevel.maxLevel = 0;
       rightViewUtil(root,maxLevel,1);
    }

    private static void rightViewUtil(Node1 root,MaxLevel level,int nextLevel){
       if(root == null)
           return;
       if(nextLevel > level.maxLevel){
           System.out.println(root.getData());
           level.maxLevel = nextLevel;
       }
       rightViewUtil(root.getRight(),level,nextLevel+1);
       rightViewUtil(root.getLeft(),level,nextLevel+1);
    }

    public static void getStartAndEndTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,-30);
        Date endTime = calendar.getTime();
        calendar.add(Calendar.MINUTE,-30);
        Date startTime = calendar.getTime();
        System.out.println(startTime + " " + endTime);

    }

    public static void modifyMatrix(int mat[][]){

        // variables to check if there are any 1
        // in first row and column
        boolean row_flag = false;
        boolean col_flag = false;

        // updating the first row and col if 1
        // is encountered
        for (int i = 0; i < mat.length; i++ ){
            for (int j = 0; j < mat[0].length; j++){
                if (i == 0 && mat[i][j] == 1)
                    row_flag = true;

                if (j == 0 && mat[i][j] == 1)
                    col_flag = true;

                if (mat[i][j] == 1){

                    mat[0][j] = 1;
                    mat[i][0] = 1;
                }

            }
        }

        // Modify the input matrix mat[] using the
        // first row and first column of Matrix mat
        for (int i = 1; i < mat.length; i ++){
            for (int j = 1; j < mat[0].length; j ++){

                if (mat[0][j] == 1 || mat[i][0] == 1){
                    mat[i][j] = 1;
                }
            }
        }

        // modify first row if there was any 1
        if (row_flag == true){
            for (int i = 0; i < mat[0].length; i++){
                mat[0][i] = 1;
            }
        }

        // modify first col if there was any 1
        if (col_flag == true){
            for (int i = 0; i < mat.length; i ++){
                mat[i][0] = 1;
            }
        }
    }

    /* A utility function to print a 2D matrix */
    public static void printMatrix(int mat[][]){
        for (int i = 0; i < mat.length; i ++){
            for (int j = 0; j < mat[0].length; j ++){
                System.out.print( mat[i][j] );
            }
            System.out.println("");
        }
    }

    public static void elementsCompare(){
        List<String> items = new ArrayList<>(Arrays.asList("54","546","548","60"));
        Collections.sort(items, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String xy = o1 + o2;
                String yx = o2 + o1;
                return Integer.valueOf(yx) - Integer.valueOf(xy);
            }
        });
        System.out.println(items);
    }

    public static void checkExecutorService(ExecutorService service){
       int i = 0;
        while(i<10000){
            int finalI = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI + Thread.currentThread().getName());
                }
            });

            i++;
        }
        System.out.println("job ended");

//        service.shutdown();
//        try {
//            if (!service.awaitTermination(800, TimeUnit.MILLISECONDS)) {
//                service.shutdownNow();
//            }
//        } catch (InterruptedException e) {
//            service.shutdownNow();
//        }
    }

    public static void permute(String str, int left, int right)
    {
        if (left == right)
            System.out.println(str);
        else
        {
            for (int i = left; i <= right; i++)
            {
                str = swap(str,left,i);
                permute(str, left+1, right);
                str = swap(str,left,i);
            }
        }
    }

    private static String swap(String str, int left, int i) {
        char[] chars = str.toCharArray();
        char temp = chars[left];
        chars[left] = chars[i];
        chars[i] = temp;
        return String.valueOf(chars);

    }
    public static int countUniquePaths(int mat[][]){
        int R = mat.length;
        int C = mat[0].length;

        int[][] path = new int[R][C];
        if(mat[0][0] == 0)
            path[0][0] = 1;

        for(int i=1;i<R;i++){
            if(mat[i][0] == 0)
                path[i][0] = path[i-1][0];
        }

        for(int j=1;j<C;j++){
            if(mat[0][j] == 0)
                path[0][j] = path[0][j-1];
        }

        for(int i=1;i<R;i++){
            for(int j=1;j<C;j++){
                if(mat[i][j] == 0)
                    path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
        return path[R-1][C-1];
    }

    public static void main(String[] args){
//       root = new Node1(3);
//       //root.setLeft(new Node1(67));
//       root.setRight(new Node1(9));
//       root.setLeft(new Node1(8));
//       root.getRight().setLeft(new Node1(6));
//       root.getRight().setRight(new Node1(5));
////       Node1 x = new Node1(21);
////       FindLevel level = new FindLevel();
//       AtomicInteger maxSum = new AtomicInteger(0);
//       System.out.println(kthSmallest(root,maxSum,2));
       //rightView(root);
       //getStartAndEndTime();
//       int[][] mat = {{1,0,0},{0,0,1},{0,0,0}};
//       modifyMatrix(mat);
       //elementsCompare();
//       ExecutorService executorService = Executors.newFixedThreadPool(1);
//       checkExecutorService(executorService);
//        String str = "abc";
//        permute(str,0,str.length()-1);
        int mat[][] = {{0,1,0},{0,1,0},{0,0,0}};
        int R = mat.length;
        int C = mat[0].length;
        System.out.println(countUniquePaths(mat));




   }

    private static boolean isPathPresent(int[][] mat, int x, int y,int row,int col) {
       if(x == col-1 && y==row-1)
           return true;
       if(isValidPoint(mat,x,y,row,col)){
           if(isPathPresent(mat,x+1,y,row,col))
               return true;
           if(isPathPresent(mat,x,y+1,row,col))
               return true;
           return false;
       }
       return false;
    }

    private static boolean isValidPoint(int mat[][],int x, int y,int row,int col) {
        if(x<col && y < row && mat[x][y] != 1)
            return true;
        return false;
    }


}
