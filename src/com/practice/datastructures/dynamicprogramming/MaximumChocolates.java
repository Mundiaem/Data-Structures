package com.practice.datastructures.dynamicprogramming;

import java.util.Arrays;

public class MaximumChocolates {
    static int memoization(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j1 >= c || j2 < 0 || j2 >= c) return (int) -1e8;
        if (i == r - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        // explore all the paths of alice and bob simultaneously
        int maxi = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= +1; dj1++) {
            for (int dj2 = -1; dj2 <= +1; dj2++) {
                int value = 0;
                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += memoization(i + 1, j1 + dj1, j2 + dj2, r, c, grid, dp);
                maxi = Math.max(maxi, value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    private static int maxChocolateTabulation(int r, int c, int[][] grid) {
        // Write your code here.
        int[][][] dp = new int[r][c][c];

        for (int j1 = 0; j1 < c; j1++) {
            for (int j2 = 0; j2 < c; j2++) {
                if (j1 == j2) {
                    dp[r - 1][j1][j2] = grid[r - 1][j1];

                } else {
                    dp[r - 1][j1][j2] = grid[r - 1][j1] + grid[r - 1][j2];

                }
            }
        }


        for (int i = r - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;
                            if (j1 == j2) {
                                ans = grid[i][j1];
                            } else {
                                ans = grid[i][j1] + grid[i][j2];

                            }
                            if ((j1 + di < 0 || j1 + di >= c) || (j2 + dj < 0 || j2 + dj >= c)) {
                                ans += Math.pow(-10, 9);

                            } else {
                                ans += dp[i + 1][j1 + di][j2 + dj];

                            }

                            maxi = Math.max(maxi, ans);


                        }

                    }
                    dp[i][j1][j2] = maxi;

                }
            }
        }
        return dp[0][0][c - 1];
    }

    private static int maxChocolate(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for (int[][] d : dp) {
            for (int[] row : d) {
                Arrays.fill(row, -1);
            }
        }

        return memoization(0, 0, c - 1, r, c, grid, dp);

    }

    public static void main(String[] args) {
        int matrix[][] = {{2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}};
        int n = matrix.length;
        int m = matrix[0].length;

        // Call the maximumChocolates function and print the result
        System.out.println(maxChocolate(n, m, matrix));
    }
}
