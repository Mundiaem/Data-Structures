package com.practice.datastructures.backtracking;

/**
 * created with love by mundiaem
 * created on 31/12/2022
 * Time: 13:00
 * ⚡  - Data-Structures
 */

/*
* You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



Example 1:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:


Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.*/
public class UniquePathsIII {
    // Function to find unique paths
    private static int uniquePaths(int[][] grid) {
        int zero = 0, sx = 0, sy = 0; // Variables to count '0' cells and track starting position

        // Iterate through the grid to count '0' cells and locate the starting position '1'
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    zero++; // Count '0' cells
                } else if (grid[r][c] == 1) {
                    sx = r; // Store the row of the starting position
                    sy = c; // Store the column of the starting position
                }
            }
        }
        // Call the DFS (Depth-First Search) function to find unique paths and return the result
        return dfs(grid, sx, sy, zero);
    }

    // DFS function to explore paths and count unique paths
    private static int dfs(int[][] grid, int x, int y, int zero) {
        // Base cases for recursion termination:
        // If the current position is out of bounds or an obstacle, return 0
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        // If reaching the '2' cell with no '0' cells remaining, return 1 (indicating a valid path found)
        if (grid[x][y] == 2)
            return zero == -1 ? 1 : 0;

        grid[x][y] = -1; // Mark the current cell as visited (-1)
        zero--; // Decrement the count of '0' cells as the current cell is visited

        // Recursively explore all four directions (up, down, left, right) from the current cell
        int totalPaths = dfs(grid, x + 1, y, zero)
                + dfs(grid, x, y + 1, zero)
                + dfs(grid, x - 1, y, zero)
                + dfs(grid, x, y - 1, zero);

        grid[x][y] = 0; // Backtrack: Reset the cell to '0' (unvisited) to explore other paths
        zero++; // Increment the count of '0' cells as the current cell is unvisited now

        return totalPaths; // Return the total number of unique paths found
    }

    // Main method to test the uniquePaths function
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}; // Example grid
        System.out.println(uniquePaths(grid)); // Print the result of uniquePaths function
    }
}

