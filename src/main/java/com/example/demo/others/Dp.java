package com.example.demo.others;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Lis{
    private int max;
    private int index;

    Lis(int max,int index){
        this.max = max;
        this.index = index;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
class Job{
    private int startTime;
    private int endTime;
    private int profit;

    public Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
}

public class Dp {

    //https://www.youtube.com/watch?v=jH_5ypQggWg&t=1428s&ab_channel=VivekanandKhyade-AlgorithmEveryDay
    private static int minimumJumps(int arr[],int n){
        // if first element is 0,
        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;
        // end cannot be reached

        int[] jumpPath = new int[n];
        int[] minJump = new int[n];

        for(int s=0; s<n; s++)
            jumpPath[s] = -1;


        minJump[0] = 0;

      for(int i=1;i<n;i++){
          minJump[i] = Integer.MAX_VALUE;
          for(int j=0; j<i; j++){
              if(i <= j + arr[j] && minJump[j] != Integer.MAX_VALUE){
                  minJump[i] = Math.min(minJump[i],minJump[j] + 1);
                  jumpPath[i] = j;
                  break;
              }
          }
      }


      //print path
        int temp = n-1;
       while(true){
           if(temp == -1){
               System.out.println(-1);
               break;
           }
           System.out.print(temp + "-->");
           temp = jumpPath[temp];
       }

      return minJump[n-1];
    }

    //https://www.youtube.com/watch?v=b6AGUjqIPsA&t=1446s&ab_channel=VivekanandKhyade-AlgorithmEveryDay
//    https://www.techiedelight.com/levenshtein-distance-edit-distance-problem/
    private static int minEditDistance(String x, String y){
        int m = x.length();
        int n = y.length();

        int[][] t = new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 && j==0)
                    t[i][j] = 0;
                else if(i==0)
                    t[i][j] = t[i][j-1] + 1;
                else if(j==0)
                    t[i][j] = t[i-1][j] + 1;
                else{
                    if(x.charAt(i-1) == y.charAt(j-1))
                        t[i][j] = t[i-1][j-1];      //if r == c then copy the diagonal element
                    else             //find min(insert,remove,replace) + 1
                        t[i][j] = 1 + min(t[i-1][j-1],t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }

    //https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/

    private static void findLIS(int arr[],int n, Lis lis){
        int[] temp = new int[n];
        int[] LIS = new int[n];

        for(int i=0;i<n;i++)
            LIS[i] = -1;

        //initially every character is a subsequence of itself
        for(int i=0;i<n;i++)
            temp[i] = 1;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j] && temp[i] < temp[j] + 1){
                    temp[i] = temp[j] + 1;
                    lis.setMax(Math.max(lis.getMax(),temp[i]));
                    lis.setIndex(j);
                    LIS[i] = j;
                }

            }
        }

//        for(int j=0;j<n;j++)
//            if(temp[j] > max)
//                max = temp[j];

//           printLis(LIS,n,lis); //wrong solution need to amend
//    Time complexity- o(n2)
    }

    //https://youtu.be/43P0xZp3FU4
    //T(n) = O(m*n)
    public static int longestCommonSubseq(String X, String Y){
        int m = X.length(), n = Y.length();

        // lookup table stores solution to already computed subproblems,
        // i.e., `T[i][j]` stores the length of LCS of substring
        // `X[0…i-1]` and `Y[0…j-1]`
        int[][] T = new int[m + 1][n + 1];

        // fill the lookup table in a bottom-up manner
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // if the current character of `X` and `Y` matches
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                }
                // otherwise, if the current character of `X` and `Y` don't match
                else {
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }

        // LCS will be the last entry in the lookup table
        return T[m][n];
    }

    // Returns true if there is a subset
    // of set[] with sum equal to given sum - recursive solution exponential time complexity
   public static boolean isSubsetSum(int set[],
                               int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        // If last element is greater than
        // sum, then ignore it
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);

        /* else, check if sum can be obtained
        by any of the following
            (a) excluding the last element
            (b) including the last element */
        return isSubsetSum(set, n - 1, sum)
                || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    public static boolean subsetsumExistv2(int set[],int sum,int n,int currIndex){
        if(sum == 0)
            return true;
        if(currIndex > n-1)
            return false;
        if(set[currIndex] > sum)
            return subsetsumExistv2(set,sum,n,currIndex+1);

        return subsetsumExistv2(set,sum,n,currIndex+1) || subsetsumExistv2(set,sum-set[currIndex],n,currIndex+1);

    }

    public static boolean isSubsetSumExist(int set[],
                               int n, int sum)
    {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[n+1][sum+1];

        subset[0][0] = true;
        for (int i = 1; i <= sum; i++)
            subset[0][i] = false;


        for (int i = 1; i <= n; i++)
            subset[i][0] = true;

        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                subset[i][j] = subset[i-1][j];
                if(set[i-1] <= j)
                  subset[i][j] = subset[i-1][j] || subset[i-1][j-set[i-1]];
            }
        }

//        // uncomment this code to print table
//        for (int i = 0; i <= n; i++)
//        {
//        for (int j = 0; j <= sum; j++)
//            System.out.println (subset[i][j]);
//        }

        return subset[n][sum];
    }

    private static void printLis(int[] LIS, int n, Lis lis) {
        int temp = lis.getIndex();
        while (temp != -1) {
            System.out.print(temp + "-->");
            temp = LIS[temp];
        }
    }

    private static int min(int x, int y, int z)
    {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    private static long printFactorial(int n){
        if(n == 0 || n == 1)
            return 1;
        long fact = printFactorial(n-1);
        return n * fact;

    }

    //find smallest prime factor of each no till N
    private static void findSpf(int n){
        if(n<=0)
            return;

      int[] spf = new int[n+1];
      spf[1] = 1;
      for(int i=2; i<=n; i++){
          spf[i] = i;
      }

      for(int i=2;i*i<=n;i++){
             if(spf[i] == i){
                 for(int j=i*i;j<=n;j+=i){
                     if(spf[j] == j)
                         spf[j] = i;
                 }
             }
      }

      //print smallest prime factors
        for(int i=1;i<=n;i++){
            System.out.println(spf[i]);
        }

    }

    //weighted-job-scheduling problem using dynamic programming
    //https://www.youtube.com/watch?v=cr6Ip0J9izc
    public static int maximumProfitAfterSchedulingJob(Job[] jobs){
        if(!Objects.isNull(jobs)) {
            Arrays.sort(jobs, new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o1.getEndTime() - o2.getEndTime();
                }
            });
        }
      int[] t = new int[jobs.length];
      int maxValue = Integer.MIN_VALUE;
      for(int i=0;i< jobs.length;i++){
          t[i] = jobs[i].getProfit();
      }

      for(int i=1;i<jobs.length;i++){
          for(int j=0;j<i;j++){
              if(jobs[j].getEndTime()<=jobs[i].getStartTime()){
                  t[i] = Math.max(t[i],jobs[i].getProfit()+t[j]);
              }
          }
      }
      for(int val : t){
          maxValue = Math.max(val,maxValue);
      }
      return maxValue;
    }


    //print all subsets of the given array
    public static void printAllSubset(List<Integer>currList,int currIndex,int[] arr,List<List<Integer>>output){
        if(currIndex == arr.length){
            output.add(new ArrayList<>(currList));
            return;
        }

        currList.add(arr[currIndex]);
        printAllSubset(currList,currIndex+1,arr,output);
        currList.remove(currList.size()-1);
        printAllSubset(currList,currIndex+1,arr,output);

    }

    public static void display(StringBuilder s){
        return;

    }

    public static void main(String[] args){
//        Job[] jobs = new Job[6];
//        jobs[0] = new Job(1,3,5);
//        jobs[1] = new Job(2,5,6);
//        jobs[2] = new Job(7,9,2);
//        jobs[3] = new Job(4,6,5);
//        jobs[4] = new Job(6,7,4);
//        jobs[5] = new Job(5,8,11);
//        System.out.println(maximumProfitAfterSchedulingJob(jobs));
        //Main List for storing all subsets
//        List<List<Integer>> subset = new ArrayList<>();
//
//        int[] arr = {1,2,3};
//
//        printAllSubset(new ArrayList<>(),0,arr,subset);
//        System.out.println(subset);
//        int[] set = {3,4,5};
//        int sum = 11;
//        System.out.println(subsetsumExistv2(set,sum,3,0));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        System.out.println(calendar.getTime());
    }
}
