package com.practice.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 08/12/2022
 * Time: 10:06
 * ⚡  - Data-Structures
 */

public class PrintAllPermutationsII {
    public static void main(String[] args) {
        int [] nums= new int [] {1,2,3};
        System.out.println(permute(nums));
    }
    private static void recurPermute(int index, int[] nums, List<List<Integer>> ans){
        if (index==nums.length){
            //copy the ds to ans
            List<Integer> ds= new ArrayList<>();
            for (int i=0; i<nums.length; i++){
                ds.add(nums[i]);}
            ans.add(new ArrayList<>(ds));
            return;}

        for (int i=index; i<nums.length; i++){
            swap(i, index, nums);
            recurPermute(index+1, nums, ans);
            swap(i, index, nums);
        }

    }
    private static void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] =nums[j];
        nums[j]= t;
    }
    private static List<List<Integer>>permute(int[] nums){
        List<List<Integer>> ans= new ArrayList<>();
        recurPermute(0,nums,ans);
        return ans;
    }
}
