package com.example.demo.others;

import java.util.Arrays;

//unbounded knapsack code
public class UnboundedKnapsack {

    public static int unboundedKnapsack(int[] values, int[] weights, int capacity, int n, int[][] memo) {
        if (n == 0 || capacity == 0) {
            return 0;
        }

        if (memo[n][capacity] != -1) {
            return memo[n][capacity];
        }

        if (weights[n-1] > capacity) {
            return memo[n][capacity] =  unboundedKnapsack(values, weights, capacity, n-1, memo);
        } else {
            memo[n][capacity] = Math.max(unboundedKnapsack(values, weights, capacity, n-1, memo),
                    values[n-1] + unboundedKnapsack(values, weights, capacity-weights[n-1], n, memo));
            return memo[n][capacity];
        }
    }

    public static int unboundedKnapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] memo = new int[n+1][capacity+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return unboundedKnapsack(values, weights, capacity, n, memo);
    }

    public static void main(String[] args) {
        int[] values = {10, 40, 50, 70};
        int[] weights = {1, 3, 4, 5};
        int capacity = 8;

        System.out.println(unboundedKnapsack(values, weights, capacity)); // output: 300
    }
}

