package com.practice.datastructures.twoPointer;
/*
* You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104

* */
public class ContainerWithMostWater {
    private static int maxArea(int [] heights){
        int left =0, right = heights.length-1;
        int max_area=0;

        while(left <right){
            int current_area= (right - left) * Math.min(heights[left], heights[right]);
            max_area = Math.max(max_area, current_area);
            if(heights[left]> heights[right]){
                right--;
            }else {
                left++;
            }
        }
         return max_area;

    }
    public static void main(String[] args) {
        int [] arr1={1,8,6,2,5,4,8,3,7};
        int [] arr2={1,1};
        System.out.println("This is the max area for holding water "+ maxArea(arr1));
        System.out.println("This is the max area for holding water "+ maxArea(arr2));



    }
}
