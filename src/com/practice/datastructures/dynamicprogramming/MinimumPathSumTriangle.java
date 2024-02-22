package com.practice.datastructures.dynamicprogramming;

import java.util.Arrays;

public class MinimumPathSumTriangle {

    private static int f(int row, int col, int n, int[][] triangle) {
        if (row == n - 1) return triangle[n - 1][col];
        int down = triangle[row][col] + f(row + 1, col, n, triangle);
        int diagonal = triangle[row][col] + f(row + 1, col + 1, n, triangle);

        return Math.min(down, diagonal);
    }

    private static int fMemoization(int row, int col, int n, int[][] triangle, int[][] dp) {
        if (row == n - 1) return triangle[n - 1][col];
        if (dp[row][col] != -1) return dp[row][col];
        int down = triangle[row][col] + f(row + 1, col, n, triangle);
        int diagonal = triangle[row][col] + f(row + 1, col + 1, n, triangle);

        return dp[row][col] = Math.min(down, diagonal);
    }

    private static int minimumPathSum(int n, int[][] triangle) {
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fMemoization(0, 0, n, triangle, dp);
    }

    private static int minimumPathSumTabulation(int n, int[][] triangle) {
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + dp[i + 1][j];
                int diagonal = triangle[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    }

    private static int minimumPathSumSpaceOptimization(int n, int[][] triangle) {
        int[] front = new int[n];

        for (int i = 0; i < n; i++) {
            front[i] = triangle[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            int [] curr= new int[n];
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + front[j];
                int diagonal = triangle[i][j] + front[j + 1];
                curr[j] = Math.min(down, diagonal);
            }
            front= curr;
        }

        return front[0];
    }

    public static void main(String[] args) {
        int[][] triangle = {{1}, {2, 3}, {4, 5, 6}, {7, 8, 9, 10}};
        int n = 4;
        System.out.println(minimumPathSumSpaceOptimization(n, triangle));

    }
}
