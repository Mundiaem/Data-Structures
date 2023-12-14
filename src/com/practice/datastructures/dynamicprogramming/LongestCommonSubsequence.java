package com.practice.datastructures.dynamicprogramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String S1 = "abcde";
        String S2 = "ace";
        int [][] dp= new int [S1.length()][S2.length()];

        System.out.println(LCS(S1, S2, S1.length()-1, S2.length()-1,dp ));

    }
    private static int LCS(String S1, String S2, int n, int m, int [][] dp){
        if(n<0 || m<0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        if (S1.charAt(n)== S2.charAt(m))  return dp[n][m]=1 + LCS( S1,S2,n-1, m-1, dp);
        return  dp[n][m] = Math.max(LCS( S1, S2,n-1, m,dp),LCS( S1, S2,n, m-1,dp));
    }
}
