package com.practice.datastructures.dynamicprogramming;

/**
 * created with love by mundiaem
 * created on 21/12/2022
 * Time: 17:03
 * ⚡  - Data-Structures
 */

public class ClimbingStairs {
/**
 * How to determine if its is a Dynamic Problem
 * - count min number of ways
 * - count distinct ways
 * - try all possible ways - recursion
 * - try all possible ways then sum it up
 *
 *     Shortcut
 *     - Try to represent the problem in-term of index
 *     - Do all possible stuff on that index according to the problem statement
 *     - If problem say's all-ways -  sum all-staff : count all-ways
 *     min(of all staff) - from min
 *     max(of all steps) - from max
 *
 *
 * */
    public static void main(String[] args) {
        int stairs =3;
        System.out.println(climbingTabulation(stairs));

    }
    private static int climbingDp(int n){
        if(n <=2) return n;
        int [] dp = new int [n+1];
        dp[1]=1;
        dp[0]=1;
        for (int i = 2; i <=n; i++) {
            dp[i]= dp[i-1] + dp[i-2];

        }
        return dp[n];
    }
    private static int climbingTabulation(int n){
        int prev=1, prev1= 1;
        for (int i = 2; i <=n; i++) {
            int curri= prev +prev1;
            prev1= prev;
            prev = curri;
        }
        return prev;
    }
}
