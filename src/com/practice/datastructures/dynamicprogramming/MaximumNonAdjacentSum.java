package com.practice.datastructures.dynamicprogramming;

import java.util.Arrays;

public class MaximumNonAdjacentSum {
    /**
     * @Example
     * input int [] arr= [1,2,3,4,5,6]
     * output:
     *
     * Approach
     * -recursion
     *  - index
     *  - do ops on that index
     *  - return the best
     *  - f(index) -> max sum 0 .... index
     *    - if (index==0) return arr[index];
     *    - if(index<0) return 0;
     *      - pick = arr[index]+ f(index-2)
     *      - notpick = 0+ f(index)
     *    return Math.max(pick, notpick);
     *
     *    Optimization
     *     - has overlapping sub problems
     *        - 0,1,2,3,
     *        f(3) -> sum -> [0...3]
     *
     *        pick= f(1) => arr[1]{1}+ f(0){0} =>1
     *        notpick= f(0) => arr[0]{0}+ f(0){2}=>2
     *
     *
     *        Memoization
     *        dp[n]
     *        Arrays.fill(dp, -1)
     *        if(dp(index)!=-1) return dp[index];
     *
     *        Time Complexity
     *        O(N)
     *
     *        Space Complexity
     *        O(N)
     *
     *        Tabulation (Bottom up)
     *        int[] dp= new int [n]
     *        dp[0]=0
     *        int neg=0;
     *        for(i <1 i<n; i++){
     *            take= arr[index];
     *            if(i>1) take+=dp[i-2];
     *
     *            nontake= 0 + dp[i-1];
     *
     *            dp[i] = max(take, nottake);
     *        }
     *
     *        Time Complexity
     *        O(N)
     *        Space Complexity
     *        O(N)
     *
     *        Space Optimization
     *        prev, prev2, curi
     *        dp[n-1]
     *        i -1
     *
     *
     *

     * */

    private static int maximumNonAdjacentSum(int [] arr, int[] dp){
        int n= arr.length;
        return f(n-1, arr, dp);

    }

    private static int f(int index, int[] arr, int [] dp) {

        if(index==0)return arr[index];
        if (index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        int pick = arr[index] + f(index-2, arr, dp);
        int notpick=0+ f(index-1, arr, dp);
        return dp[index]= Math.max(pick, notpick);
    }

    public static void main(String[] args) {
        int [] arr={2,1,4,9};
        int[] dp= new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(maximumNonAdjacentSum(arr, dp));
        System.out.println(maximumNonAdjacentSumOpt(arr));

    }
    //space optimization
    private static int maximumNonAdjacentSumOpt(int [] arr){
        int n = arr.length;
        int prev= arr[0];
        int prev2 =0;
        for(int i=1; i<n;i++){
            int take = arr[i];
            if(i>1) take +=prev2;
            int notTake=0+ prev;
            int curi= Math.max(take, notTake);
            prev2 = prev;
            prev= curi;
        }
        return prev;
    }



}
