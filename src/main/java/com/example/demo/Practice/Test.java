package com.example.demo.Practice;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Test {
    public static int minimumDifference(int[] nums) {
        if(nums.length == 0)
            return 0;
        int sum = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum += Math.abs(nums[i]);
        }
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        findSubsetSum(nums,sum,dp);
        for(int j=sum/2;j>=0;j--){
            if(dp[nums.length][j] == true){
                minDiff = Math.min(minDiff,Math.abs(sum-2*j));
            }
        }
        return minDiff;
    }

    public static void findSubsetSum(int[] nums, int sum, boolean[][] dp){
        if(nums.length == 0)
            return;
        for(int i=0;i<=nums.length;i++){
            for(int j=0;j<=sum;j++){
                if(i==0 && j==0)
                    dp[i][j] = true;
                else if(i==0)
                    dp[i][j] = false;
                else if(j==0)
                    dp[i][j] = true;
                else{
                    dp[i][j] = dp[i-1][j];
                    if(Math.abs(nums[i-1])<= j){
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-Math.abs(nums[i-1])];
                    }
                }
            }
        }
    }


    public static String removeAdjDup(String str)
    {
        // base case
        if (str == null || str.length() == 0) {
            return str;
        }

        char[] chars = str.toCharArray();

        // `k` maintains the index of the next free location in the result,
        // and `i` maintains the current index of the string
        int i, k = 0;

        // start from the second character
        for (i = 1; i < chars.length; i++)
        {
            // if the current character is not the same as the
            // previous character, add it to the result
            if (chars[i - 1] != chars[i]) {
                chars[k++] = chars[i - 1];
            }
            else {
                // remove adjacent duplicates
                while (i < chars.length && chars[i - 1] == chars[i]) {
                    i++;
                }
            }
        }

        // add the last character to the result
        chars[k++] = chars[i - 1];

        // construct a string with the first `k` chars
        String s = new String(chars).substring(0, k);

        // start again if any duplicate is removed
        if (k != chars.length) {
            return removeAdjDup(s);            // Schlemiel painter’s algorithm
        }

        // if the algorithm didn't change the input string, that means
        // all the adjacent duplicates are removed
        return s;
    }

    public static void main(String[] args){
       String str = "DBAABDAB";
        System.out.println(removeAdjDup(str));
    }

}
