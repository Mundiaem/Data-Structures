package com.practice.datastructures.dynamicprogramming;


import java.util.*;

public class MinimumPathSum {
    static int f(int row, int col, int[][] grid) {
        if (row == 0 || col == 0) return 0;
        if (row < 0 || col < 0) return Integer.MAX_VALUE;

        int up = grid[row][col] + f(row - 1, col, grid);
        int right = grid[row][col] + f(row - 1, col, grid);
        return Math.min(up, right);
    }

    static int maxi = Integer.MIN_VALUE;

    static int fPath(int row, int col, int[][] grid, List<Integer> ds) {
        if (row == 0 || col == 0) return grid[row][col];
        if (row < 0 || col < 0) return (int) 1e9;
        int up = f(row - 1, col, grid);
        int left = f(row, col - 1, grid);
        System.out.println(up + " " + left);
        ds.add(Math.min(up, left));
        return Math.min(up, left);
    }

    private static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

            }

        }
        return 0;
    }
    public static List<Integer> minPath(int[][] grid) {
        List<Integer> path = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return path;
        }
        int m = grid.length;
        int n = grid[0].length;
        // Create a 2D array to store minimum path sums
        int[][] dp = new int[m][n];
        // Create a 2D array to store the chosen path
        int[][] chosenPath = new int[m][n];
        // Initialize the top-left corner
        dp[0][0] = grid[0][0];
        chosenPath[0][0] = -1; // Indicates the starting point
        // Initialize the first row
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
            chosenPath[0][i] = 0; // Move horizontally
        }
        // Initialize the first column
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
            chosenPath[j][0] = 1; // Move vertically
        }
        // Fill the rest of the dp and chosenPath arrays
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i - 1][j] < dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    chosenPath[i][j] = 1; // Move vertically
                } else {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    chosenPath[i][j] = 0; // Move horizontally
                }
            }
        }

        // Reconstruct the path
        int row = m - 1;
        int col = n - 1;
        while (row >= 0 && col >= 0) {
            path.add(grid[row][col]);
            int direction = chosenPath[row][col];
            if (direction == 0) {
                col--;
            } else {
                row--;
            }
        }



        return path;
    }
    public static void main(String[] args) {
        int[][] grid = {{3, 4, 6}, {6, 5, 4}};
        int[][] grid1=  {{1, 2, 1, 1, 1, 4}, {1, 1, 1, 3, 1, 1}};
        int[][] grid2=   {{-5, -1, -3}, {-5, 5, -2}};
        List<Integer> path = minPath(grid);
        List<Integer> path1 = minPath(grid1);
        List<Integer> path2 = minPath(grid2);

        int maxValue = path.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        int maxValue2 = path1.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        int maxValue3 = path2.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        System.out.println(maxValue); // Output: [3, 4, 5, 4]
        System.out.println(maxValue2); // Output: [3, 4, 5, 4]
        System.out.println(maxValue3); // Output: [3, 4, 5, 4]




    }
}
