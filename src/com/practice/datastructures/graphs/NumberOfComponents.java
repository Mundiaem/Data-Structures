package com.practice.datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created with love by mundiaem
 * created on 10/01/2023
 * Time: 16:40
 * ⚡  - Data-Structures
 */

public class NumberOfComponents {
    /*
    * - have stating point e.g [0,1]
    * - 2d array to mark as visited same size
    * - push to the queue mark as visited
    * - pick the element to from the queue
    * - visit the neighbors in eight directions  eg [0,2], [1,2], [1,1]
    * - then pick the next element from the queue then repeat
    *
    *  -     Pseudo code
    *       for(now -> (0 > n)){
    *       for(col -> (0 > m)){
    *       if(!visited[i]){
    *       }}
    *NB//
    * *if you're standing at a column it has eight neighbors
    * which can be represented as [row, col], [row+1, col], [row, col+1],[row+1, col+1],
    * [row, col],[row-1, col-1],[row-1, col],[row, col-1],
    * * for(delRow -> -1 to +1){
    * for(delCol -> -1 to +1){
    * neighborRow = row +delRow;
    * neighborCol= col+delCol;
    * }}
    *
    * Space Complexity
    - O(N^2)
    *
    * Time Complexity
    * O(N^2)
    * */
    public static void main(String[] args) {
    /*
    Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
     */
        char[][] islands = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
       char[][] island1= {  {'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println(numberOfIsland(islands));
        System.out.println(numberOfIsland(island1));

    }

    private static void bfs(int row, int col, int[][] visited, char[][] grid) {
        visited[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();
            int [] dRow= {-1,1,0,0};
            int [] dCol = {0,0,1,-1};

            for(int i=0; i<4; i++){
                int nRow= r+dRow[i];
                int nCol= c+dCol[i];
                    //
                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                            && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0) {
                        visited[nRow][nCol] = 1;
                        q.add(new Pair(nRow, nCol));
                    }
                }

            }




    }

    private static int numberOfIsland(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] visited = new int[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (visited[row][col] == 0 && grid[row][col] == '1') {
                    count++;
                    bfs(row, col, visited, grid);
                }
            }
        }
        return count;
    }

}

 class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
