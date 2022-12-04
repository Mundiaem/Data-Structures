package com.practice.datastructures.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 04/12/2022
 * Time: 16:21
 * ⚡  - Data-Structures
 */

public class Patterns {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int n = 3;
        int sum = 2;
        List<Integer> ds = new ArrayList<>();
        subsequenceOfSumK(0, ds, 0, sum, arr, n);
    }

    private static void subsequenceOfSumK(int index, List<Integer> ds, int s, int sum, int[] arr, int n) {
        if (index == n) {
            if(s==sum){
                System.out.println(ds.toString());
            }

            return;
        }
        ds.add(arr[index]);
        s += arr[index];
        subsequenceOfSumK(index + 1, ds, s, sum, arr, n);
        s -= arr[index];
        ds.remove(ds.size() - 1);
        subsequenceOfSumK(index + 1, ds, s, sum, arr, n);


    }
}
