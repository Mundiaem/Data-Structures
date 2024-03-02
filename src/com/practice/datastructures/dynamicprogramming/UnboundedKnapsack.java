package com.practice.datastructures.dynamicprogramming;

public class UnboundedKnapsack {
    private static int f(int index, int W, int [] val, int [] wt){
        if(index==0){
            return (W/ wt[0]) * val[0];
        }
        int notTake =0 + f(index-1, W, val, wt);
        int take=0;
        if(wt[index]<= W) take= val[index] + f(index, W - wt[index], val, wt);
        return Math.max(notTake, take);

    }
    private static int unboundedKnapsack(int W, int [] val, int [] wt){
        int n= wt.length;
        return f(n -1, W, val, wt);


    }
    public static void main(String[] args) {
        int [] wt= {2,4,6};
        int [] val ={5,11,13};
        int W= 6;
        System.out.println("Recursion - "+ unboundedKnapsack(W, val, wt));

    }
}
