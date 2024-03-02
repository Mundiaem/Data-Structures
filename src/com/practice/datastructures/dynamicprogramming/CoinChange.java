package com.practice.datastructures.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    private static long f(int index, int target, int[] arr, long[][] dp) {
        if (index == 0) {
            return (target % arr[0] == 0) ? 1 : 0;
        }
        if (dp[index][target] != -1) return dp[index][target];
        long notTake = 0 + f(index - 1, target, arr, dp);
        long take = 0;
        if (arr[index] <= target) take =  f(index, target - arr[index], arr, dp);
        return dp[index][target] = (take + notTake);

    }

    private static long coinChange(int[] arr, int target) {
        int n = arr.length;
        long[][] dp = new long[n][target + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, target, arr, dp);
    }

    private static long coinChangeTabulation(int[] arr, int target) {
        int n = arr.length;
        long[][] dp = new long[n][target+1];
        //base case
        for (int T = 0; T <= target; T++) {
            dp[0][T] = (T % arr[0] == 0) ? 1 : 0;
        }

        for (int index = 1; index < n; index++) {
            for (int T = 0; T <= target; T++) {
                long notTake = dp[index - 1][T];
                long take = 0;
                if (arr[index] <= T) take =  dp[index][T - arr[index]];
                dp[index][T] = (take + notTake);
            }
        }

        return dp[n - 1][target];
    }
    private static long coinChangeTabulationSpaceOptimization(int[] arr, int target) {
        int n = arr.length;
        long[] prev = new long[target+1];
        //base case
        for (int T = 0; T <= target; T++) {
            prev[T] = (T % arr[0] == 0) ? 1 : 0;
        }

        for (int index = 1; index < n; index++) {
            long[] curr = new long[target+1];
            for (int T = 0; T <= target; T++) {
                long notTake = prev[T];
                long take = 0;
                if (arr[index] <= T) take = curr[T - arr[index]];
               curr[T] = (take + notTake);
            }
            prev= curr;
        }

        return prev[target];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int target = 4;
        System.out.println( "Memoization = "+ coinChange(arr, target));
        System.out.println( "Tabulation = "+ coinChangeTabulation(arr, target));
        System.out.println( "Space Optimization = "+ coinChangeTabulationSpaceOptimization(arr, target));


    }
}
