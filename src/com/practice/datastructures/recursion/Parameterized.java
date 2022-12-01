package com.practice.datastructures.recursion;

/**
 * created with love by mundiaem
 * created on 01/12/2022
 * Time: 21:21
 * ⚡  - Data-Structures
 */

public class Parameterized {

    public static void main(String[] args) {
        int N=10;
        printName(0, N);
        reverseBackTracking(1, N);
        linearBacktracking(N, N);
    }

   static void printName(int i, int n){
        //base case
        if(i>n){
            return;
        }
        System.out.println("Mundia");
        printName(i+1, n);

    }
    static void reverseBackTracking(int i,int N){
        if(i>N){
            return ;
        }
        reverseBackTracking(i+1,N);
        System.out.println(i);
    }

    static void linearBacktracking(int i, int N){
        if(i<1){
            return ;
        }
        linearBacktracking(i-1, N);
        System.out.println(i);
    }
}
