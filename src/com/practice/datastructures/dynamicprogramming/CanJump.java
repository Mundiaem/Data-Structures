package com.practice.datastructures.dynamicprogramming;

import java.util.Arrays;

/**
 * created with love by mundiaem
 * created on 26/12/2022
 * Time: 15:05
 * ⚡  - Data-Structures
 */
/*
* You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
* */
public class CanJump {

    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length]; // Create an array to store whether each index is reachable
        Arrays.fill(dp, false); // Initialize the array with 'false' values
        dp[nums.length - 1] = true; // Set the last index to 'true', as it's already the end point

        // Traverse the array backwards to determine reachability for each index
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0)
                dp[i] = false; // If the value at the current index is 0, then it's unreachable
            else {
                if (nums[i] + i >= nums.length) {
                    dp[i] = true; // If jumping from the current index reaches or goes beyond the last index, mark it as reachable
                } else {
                    // Iterate through the jump possibilities from the current index
                    for (int j = 1; j <= nums[i]; j++) {
                        dp[i] = dp[i] || dp[i + j]; // Update reachability based on the maximum jump length
                        j += nums[i + j]; // Move j to the next position based on the value of nums[i+j]
                    }
                }
            }
        }
        return dp[0]; // Return whether the first index is reachable
    }

    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
        int[] nums1 = {3,2,1,0,4};

        System.out.println(canJump(nums));
        System.out.println(canJump(nums1));



    }
}
