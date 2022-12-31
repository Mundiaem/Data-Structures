package com.practice.datastructures.dynamicprogramming;

/**
 * created with love by mundiaem
 * created on 31/12/2022
 * Time: 16:07
 * ⚡  - Data-Structures
 */

public class FrogJump {
    public static void main(String[] args) {
        int [] heights={4,8,3,10,4,4};
        System.out.println(frogJump(6, heights));
    }
   static int f(int index, int [] heights){
        if(index==0) return 0;
        int left =f(index-1, heights)+Math.abs(heights[index]-heights[index-1]);
                int right= Integer.MAX_VALUE;
        if(index>1) right= f(index-2, heights)+Math.abs(heights[index]-heights[index-2]);
        return Math.min(left, right);
    }
   static int frogJump(int n, int[] heights){
        return f(n-1, heights);
    }
}
