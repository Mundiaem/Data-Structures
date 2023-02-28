package com.practice.datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] islands = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] island1= {  {'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println(numIslands(islands));
        System.out.println(numIslands(island1));
    }
        public static int numIslands(char[][] grid) {
            int n= grid.length;
            int m = grid[0].length;
            int [][] visited= new int [n][m];
            int cnt=0;
            for(int row=0; row<n; row++){
                for (int col=0; col<m; col++){
                    if(visited[row][col]==0 && grid[row][col]=='1'){
                        cnt++;
                        bfs(row,  col, visited, grid);

                    }
                }
            }
            return cnt;


        }
        private static void bfs(int row, int col, int[][] visited, char [][] grid){
            visited[row][col]=1;
            int n= grid.length;
            int m= grid[0].length;
            Queue<Pair> q= new LinkedList<>();
            // add starting point to the queue
            q.add(new Pair(row, col));

            while(!q.isEmpty()){
                int _row= q.peek().first;
                int _col= q.peek().second;

                q.remove();
                int [] dRow= {-1,1,0,0};
                int [] dCol = {0,0,1,-1};

                for(int i=0; i<4; i++){
                    int nRow= _row+dRow[i];
                    int nCol= _col+dCol[i];

                    // conditional check
                    if(nRow>=0 && nRow< n && nCol>=0 && nCol< m && grid[nRow][nCol]=='1'
                            && visited[nRow][nCol]==0 ){
                        visited[nRow][nCol]=1;

                        q.add(new Pair(nRow, nCol));

                    }
                }



            }




        }


}

