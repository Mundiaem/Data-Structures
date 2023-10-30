package com.practice.datastructures.arrays;

import java.util.Arrays;

public class RemoveDupInPlace {
    public static void main(String[] args) {
        int[] dup1 = {1, 1, 1, 2, 2, 3};
        int[] dup2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.printf("Duplicate 1 %s \n", Arrays.toString(removeDuplicateArrayInPlace(dup1)));
        System.out.printf("Duplicate 2 %s \n", Arrays.toString(removeDuplicateArrayInPlace(dup2)));

    }

    private static int[] removeDuplicateArrayInPlace(int[] arr) {
        int i = 0;
        int n = arr.length-1;
        int k = 0;
        while (n >= i) {
            arr[k++] = arr[i++];
            if (i <= n && arr[i] == arr[k - 1])
                arr[k++] = arr[i++];
            while (i <= n && arr[i] == arr[k - 1]) i++;
        }
        return Arrays.copyOfRange(arr, 0, k);

    }
}
