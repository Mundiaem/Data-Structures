package com.practice.datastructures.dynamicprogramming;

import java.util.Arrays;

public class Dp25LCS {
    private static int f(int index1, String s1, int index2, String s2) {
        if (index1 < 0 || index2 < 0) return 0;

        if (s1.charAt(index1) == s2.charAt(index2)) return 1 + f(index1 - 1, s1, index2 - 1, s2);
        return 0 + Math.max(f(index1 - 1, s1, index2, s2), f(index1, s1, index2 - 1, s2));

    }

    private static int fMemoization(int index1, String s1, int index2, String s2, int[][] dp) {
        if (index1 < 0 || index2 < 0) return 0;
        if (dp[index1][index2] != -1) return dp[index1][index2];

        if (s1.charAt(index1) == s2.charAt(index2)) return dp[index1][index2] = 1 + f(index1 - 1, s1, index2 - 1, s2);
        return dp[index1][index2] = 0 + Math.max(f(index1 - 1, s1, index2, s2), f(index1, s1, index2 - 1, s2));

    }

    private static int fTabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        // Base case;
        for (int index1 = 0; index1 <= n; index1++) {
            dp[index1][0] = 0;
        }
        for (int index2 = 0; index2 <= m; index2++) {
            dp[0][index2] = 0;
        }
        for (int index1 = 1; index1 <= n; index1++) {
            for (int index2 = 1; index2 <= m; index2++) {
                if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                else dp[index1][index2] = 0 + Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
            }
        }

        return dp[n][m];
    }

    private static int fSpaceOptimization(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[n + 1];
        // Base case;
        for (int index1 = 0; index1 <= n; index1++) {
            prev[index1] = 0;
        }

        for (int index1 = 1; index1 <= n; index1++) {
            int[] curr = new int[m + 1];
            for (int index2 = 1; index2 <= m; index2++) {
                if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) curr[index2] = 1 + prev[index2 - 1];
                else curr[index2] = 0 + Math.max(prev[index2], curr[index2-1]);
            }
            prev=curr;
        }

        return prev[n];
    }

    private static int longestCommonSubsequence(String s1, String s2) {
//        int n= s1.length();
//        int m = s2.length();
//        int [][] dp= new int[n][m];
//        for (int [] row: dp){
//            Arrays.fill(row, -1);
//        }
//        return fMemoization(n-1, s1, m-1, s2, dp);
        return fSpaceOptimization(s1, s2);
    }

    public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadb";
        System.out.println(longestCommonSubsequence(s1, s2));
    }
}
