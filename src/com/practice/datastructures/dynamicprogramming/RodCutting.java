package com.practice.datastructures.dynamicprogramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RodCutting {
    private static int f(int index, int N, int[] price, int[][] dp) {
        if (index == 0) return (N * price[index]);
        if (dp[index][N] != -1) return dp[index][N];
        int notTake = 0+ f(index -1, N, price, dp);
        int take= Integer.MIN_VALUE;
        int rodLength= index +1;
        if(rodLength<=N) take= price[index] + f(index, N- rodLength, price, dp);
        return dp[index][N]=Math.max(notTake, take);
    }
    //TODO: Tabulation
    //TODO: Space optimization

    private static int rodCutting(int[] price, int N) {
        int n = price.length;
        int [][] dp = new int[n][N+1];
        for (int [] row:dp) {
            Arrays.fill(row, -1);
        }
        return f(n-1, N, price, dp);
    }

    public static void main(String[] args) {
        int[] price = {2, 5, 7, 8, 10};
        int N = 5;
        int[] price1 = {3, 5, 8, 9, 10, 17, 17,20};
        int N1 = 8;
        System.out.println(rodCutting(price, N));
        System.out.println(rodCutting(price1, N1));
    }
}
