package com.practice.datastructures.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 05/12/2022
 * Time: 12:47
 * ⚡  - Data-Structures
 */
/*
*
* 40. Combination Sum II
Add to List

Share
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]


Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
* */
public class CombinationSumIIL9 {


    public static void main(String[] args) {
        int[] candidates = new int[] {10,1,2,7,6,1,5};
                int target = 8;
        System.out.println(combination2Sum(candidates, target));
    }

    private static List<List<Integer>> combination2Sum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination2Sum(0, candidates, target, ans, new ArrayList<>());

        return ans;
    }

    private static void findCombination2Sum(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;
            ds.add(arr[i]);
            findCombination2Sum(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }

    }
}
