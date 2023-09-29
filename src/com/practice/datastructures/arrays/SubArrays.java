package com.practice.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubArrays {
    public static void main(String[] args) {
        /*
         * input int [] arr = [1,2,4]
         * output [[], [1], [2], [4], [1,2],[1,2,4], [2,4], [1,4]]
         * f(index, n, sub, subset)-> base condition if(index==n) subset.add(set) return
         * sub.add(arr[index]);
         * f(index+1,n, sub, subset);
         * f(index, n, sub, subset);
         * }
         * */
        int[] arr = {1, 3, 0, 0, 2, 0, 0, 4};
        List<List<Integer>> subsets = subArrays(arr);

        System.out.println(subsets.toString());
        System.out.println(subsets.size());

    }

    private static List<List<Integer>> subArrays(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        List<Integer> set = new ArrayList<>();
        subs(0, arr.length, arr, set, subsets);
        return subsets;

    }

    private static void subs(int index, int N, int[] arr, List<Integer> sub, List<List<Integer>> subSets) {
        if (index == N) {
//            System.out.println(sub.toString());

            subSets.add(sub);


            return;
        }

        //pick
        if (arr[index] == 0) {
            sub.add(arr[index]);
            subs(index + 1, N, arr, new ArrayList<>(sub), subSets);
            sub.remove(sub.size() - 1);

        }else{
            //not pick
            subs(index + 1, N, arr, new ArrayList<>(sub), subSets);
        }


    }
}
