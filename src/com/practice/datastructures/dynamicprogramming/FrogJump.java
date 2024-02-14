package com.practice.datastructures.dynamicprogramming;

import java.util.Arrays;

/**
 * created with love by mundiaem
 * created on 31/12/2022
 * Time: 16:07
 * ⚡  - Data-Structures
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
 * Adjacent
 */

public class FrogJump {
    public static void main(String[] args) {
        int[] heights = {4, 8, 3, 10, 4, 4};
        System.out.println(frogJump(6, heights));
    }

    static int f(int index, int[] heights, int[] dp) {
        if (index == 0) return 0;
        if (dp[index] != -1) return dp[index];
        int left = f(index - 1, heights, dp) + Math.abs(heights[index] - heights[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1) right = f(index - 2, heights, dp) + Math.abs(heights[index] - heights[index - 2]);
        return dp[index] = Math.min(left, right);
    }

    static int frogJump(int n, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
//        return f(n - 1, heights, dp);
        for (int i = 1; i < n; i++) {
            int fs = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) ss = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(fs, ss);
        }
        return dp[n - 1];
    }

    static int frogTabulatedJump(int n, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
//        return f(n - 1, heights, dp);
        for (int i = 1; i < n; i++) {
            int fs = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) ss = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(fs, ss);
        }
        return dp[n - 1];
    }

    static int frogJumpWithKDistance(int n, int[] distance) {

    }

}
