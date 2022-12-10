package com.practice.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 07/12/2022
 * Time: 17:04
 * ⚡  - Data-Structures
 */

public class PrintAllPermutations {
    public static void main(String[] args) {
        int [] nums= new int [] {1,2,3};
        System.out.println(permute(nums).toString());
        System.out.println("Number of Permutation: "+permute(nums).size());  ;
        ;
    }

    private static void recurPermute(int [] nums, List<Integer> ds, List<List<Integer>> ans, boolean [] freq){
        if (ds.size()== nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                recurPermute(nums, ds, ans, freq);
                ds.remove(ds.size()-1);
                freq[i]= false;
            }
        }
    }
    private static List<List<Integer>> permute(int [] nums){
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recurPermute(nums, ds, ans,freq);
        return ans;
    }
}
