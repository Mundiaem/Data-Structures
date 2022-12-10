package com.practice.datastructures.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 08/12/2022
 * Time: 21:01
 * ⚡  - Data-Structures
 */
/*
 * Problem Statement: The n-queens is the problem of placing
 * n queens on n × n chessboard such that no two queens can
 * attack each other. Given an integer n, return all distinct
 *  solutions to the n -queens puzzle. Each solution contains
 * a distinct boards configuration of the queen’s placement,
 *  where ‘Q’ and ‘.’ indicate queen and empty space
 * respectively.
 * */
public class NQueenPuzzle {
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(0, board, res);
        return res;
    }

    private static void dfs(int col, char[][] board, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int row=0; row< board.length; row++){
            if (validate(board, row, col)){
                board[row][col]= 'Q';
                dfs(col+1, board, res);
                board[row][col]='.';
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 4;
        List<List<String>> queen = solveNQueens(N);
        int i = 1;
        for (List<String> it : queen) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }

    private static boolean validate(char[][] board, int row, int col) {
        int duprow=row;
        int dupcol=col;
        while (row >= 0 && col >= 0){
               if(board[row][col]=='Q') return false;
               row--;
               col--;
        }
        row= duprow;
        col= dupcol;
        while (col>=0){
            if (board[row][col]== 'Q')  return false;
            col--;
        }
        row=duprow;
        col=dupcol;
        while (col>=0 && row< board.length){
            if (board[row][col]=='Q') return false;
            col--;
            row++;
        }
        return true;
    }
}
