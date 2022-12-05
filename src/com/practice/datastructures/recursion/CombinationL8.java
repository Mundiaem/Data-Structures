package com.practice.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 05/12/2022
 * Time: 09:07
 * ⚡  - Data-Structures
 */


/*
*
*
* 39. Combination Sum
Medium

14285

288

Add to List

Share
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []


Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40*/
public class CombinationL8 {

    public static void main(String[] args) {
        int [] candidates = new  int[]{2,3,6,7};
        int  target = 7;
        System.out.println(combinationSum(candidates, target).toString());
    }
    private static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans= new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private static void findCombinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer>ds){
        if (index==arr.length){
            if (target==0){
                ans.add(new ArrayList<>(ds));
                System.out.println("Target is 0: "+ ds);
            }
            return;
        }
        if (arr[index]<=target){
            ds.add(arr[index]);
            findCombinations(index, arr, target-arr[index], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(index+1, arr, target, ans, ds);

    }


}
