package com.practice.datastructures.dynamicprogramming;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
int [] nums= {1,3,5,9};
        System.out.println(solution(nums));
    }
    private static int solution(int [] nums){
    int n= nums.length;
        int [] dp= new int[n];
        Arrays.fill(dp, -1);

        return func(n-1, nums, dp);
    }

    private static int func(int index, int[] arr, int [] dp){
        if(index==0) return arr[index];
        if (index<0) return 0;
        if(dp[index]!=-1) return dp[index];

        int pick= arr[index] +func(index-2,  arr, dp);
        int notPick= 0+ func(index-1, arr, dp);
         return dp[index]= Math.max(pick, notPick);
    }
}
