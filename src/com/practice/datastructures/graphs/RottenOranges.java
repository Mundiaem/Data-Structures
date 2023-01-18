package com.practice.datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;

class PairOranges{
    int row;
    int col;
    int tm;
    PairOranges(int _row, int _col, int _tm){
        this.row=_row;
        this.col=_col;
        this.tm=_tm;
    }
}
public class RottenOranges {
    public static void main(String[] args) {

    }
    /*
    @BFS Algorithm
    -use Queue
    - create a visited [][]
    -
    * **/

public static int orangesRotting(int[][] grid){
    int row= grid.length;
    int col= grid[0].length;

    Queue<PairOranges> q= new LinkedList<>();
    int [][] visited = new int[row][col];
    int cntFresh= 0;
    for (int i=0; i<row; i++){
        for (int j=0; j<col; j++){
           if(grid[i][j]==2){
               q.add(new PairOranges(i, j,0));
               visited[i][j]=2;
           }else {
               visited[i][j]=0;
           }
           if(grid[i][j]==1) cntFresh++;
        }
    }

    int tm= 0;
    int [] drow= {-1,0,+1,0};
    int [] dcol={0,1,0,-1};
    int cnt=0;
    while (!q.isEmpty()){
        int r= q.peek().row;
        int c= q.peek().col;
        int t= q.peek().tm;

        tm= Math.max(tm, t);
        q.remove();
        for (int i=0; i<4; i++){
            int nRow= r+drow[i];
            int nCol= c+dcol[i];
            if(nRow>=0 && nRow<row && nCol>=0 && nCol<col &&
            visited[nRow][nCol]==0 && grid[nRow][nCol]==1){
                q.add(new PairOranges(nRow,nCol, t+1));
                visited[nRow][nCol]=2;
                cnt++;
            }
        }
    }
    if(cnt!=cntFresh) return -1;
    return tm;
}
}
