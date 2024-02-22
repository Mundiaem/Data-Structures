package com.practice.datastructures.graphs;

public class FloodFill {
    public static void main(String[] args) {

    }

    private static int[][] floodFill(int [][] image, int sr, int sc, int newColor){
        int iniColor = image[sr][sc];
        int [][] ans = image;
        int[] delRow = {-1,0,1, 0};
        int [] delCol= {0, 1,0,-1};
        dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
        return ans;
    }

    private static void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int[] delRow, int[] delCol, int iniColor) {
    ans[row][col] = newColor;
    int n = image.length;
    int m= image[0].length;
        for (int i = 0; i < 4; i++) {
            int nRow= row+ delRow[i];
            int nCol= col+delCol[i];
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && image[nRow][nCol] == iniColor&& ans[nRow][nCol] != newColor){
                dfs(nRow, nCol, ans, image, newColor, delRow, delCol, iniColor);
            }
        }

    }
}
