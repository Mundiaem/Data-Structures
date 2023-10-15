package com.practice.datastructures.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 16/12/2022
 * Time: 10:20
 * ⚡  - Data-Structures
 */

public class Fibonacci {
    public static void main(String[] args) {
        int n=1;

        int [] dp= new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(implFib(n,dp ));
    }
    private static int implFib(int n, int[]  dp){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1)return dp[n];

        return dp[n]=implFib(n-1, dp)+implFib(n-2, dp);
    }


}
