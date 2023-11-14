package com.practice.datastructures.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 07/12/2022
 * Time: 09:14
 * ⚡  - Data-Structures
 */

public class SubSetSum {
    /*
    * Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.

    Examples:

    Example 1:

    Input: N = 3, arr[] = {5,2,1}

    Output: 0,1,2,3,5,6,7,8

    Explanation: We have to find all the subset’s sum and print them.
    * in this case the generated subsets are [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],so the sums we get will be  0,1,2,3,5,6,7,8


    Input: N=3,arr[]= {3,1,2}

    Output: 0,1,2,3,3,4,5,6

    Explanation: We have to find all the subset’s sum and print them.
    * in this case the generated subsets are [ [], [1], [2], [2,1], [3], [3,1], [3,2]. [3,2,1],so the sums we get will be  0,1,2,3,3,4,5,6
    * */
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        ArrayList<Integer> ans = subSetSums(arr, arr.size());
        Collections.sort(ans);
        System.out.println(" The sum of each subset is ");
            System.out.println(ans + " ");

    }

    private static void subsetSumsHelper(int index, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubset,List<List<Integer>>subset) {
    if (index==N){
        sumSubset.add(sum);
        return;
    }
    // pick the element
        List<List<Integer>>set= new ArrayList<>();
        set.add(new ArrayList<>(arr.get(index)));
        subsetSumsHelper(index+1, sum+arr.get(index), arr,N, sumSubset, set);
    // Do-not pick the element
        subsetSumsHelper(index+1, sum, arr,N, sumSubset, subset);
    }

    private static ArrayList<Integer> subSetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> sumSubSet = new ArrayList<>();
        List<List<Integer>>subset= new ArrayList<>();
        subsetSumsHelper(0, 0, arr, N, sumSubSet, subset);
        System.out.println(subset);
        Collections.sort(sumSubSet);
        return sumSubSet;
    }

}
https://itznihal.medium.com/top-50-dsa-coding-interview-numerical-questions-and-patterns-8d0d9b9625ff