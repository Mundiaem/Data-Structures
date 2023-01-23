package com.practice.datastructures.dynamicprogramming;

public class PalindromePartitionII {
    /**
    * Writing a recurrence
    * 1. Express everything in terms of index
    * 2. Express all partitions
    * 3. Take the min of all partitions
    * 4. Write the Base Case
    *
    * Give the main cuts to make all  substring palindrome
    * f(i){ if(i==n){
     *      return 0;
     * }
     * temp="";
     * if(dp[i]!=-1) return;
     * int minCost = Integer.MAX_VALUE;
     * for(j=i; j<n; j++){
     * temp += s[j];
     * if(isPalindrome(partition)){
     * cost =1+ f(j+1);
     * minCost= min(minCost, cost);
     * return dp[i]=minCost;
     * }
     * }
     * }
     * @Time Complexity
     * - Memoization
     *   > dp[i]=minCost;
     *   if(dp[i]!=-1) return;
     *
    * */
}
