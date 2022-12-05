package com.practice.datastructures.recursion;

import java.util.ArrayList;
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
        System.out.println("Only one subsequence :  " + firstSubsequenceOfSumK(0, ds, 0, sum, arr, n));
        System.out.println("Count the number of subsequences :  " + countSubsequenceOfSumK(0, 0, sum, arr, n));
    }

    private static void subsequenceOfSumK(int index, List<Integer> ds, int s, int sum, int[] arr, int n) {
        if (index == n) {
            if (s == sum) {
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

    private static boolean firstSubsequenceOfSumK(int index, List<Integer> ds, int s, int sum, int[] arr, int n) {
        if (index == n) {
            if (s == sum) {
                System.out.println(ds.toString());
                return true;
            }

            return false;
        }
        ds.add(arr[index]);
        s += arr[index];
        if (firstSubsequenceOfSumK(index + 1, ds, s, sum, arr, n)) return true;
        s -= arr[index];
        ds.remove(ds.size() - 1);
        if (firstSubsequenceOfSumK(index + 1, ds, s, sum, arr, n)) return true;
        return false;


    }

    private static int countSubsequenceOfSumK(int index, int s, int sum, int[] arr, int n) {
        // condition not satisfied
        // strictly if the array contains positive only
        if(s>sum)return 0;
        if (index == n) {
            //condition satisfied
            if (s == sum) return 1;
            // condition not satisfied
            else return 0;


        }
        s += arr[index];
        int l = countSubsequenceOfSumK(index + 1, s, sum, arr, n);
        s -= arr[index];
        // condition not met ? not picked 
        int r = countSubsequenceOfSumK(index + 1, s, sum, arr, n);
        return l + r;

    }
}
