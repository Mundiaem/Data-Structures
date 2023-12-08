package com.practice.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlippingMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<List<Integer>> matrix_ = new ArrayList<>();
        int result = flippingMatrix(matrix_);
        System.out.println("Maximal sum in the upper-left quadrant: " + result);

    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int maxSum = 0;
        int n = matrix.size() / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int element = matrix.get(i).get(j);
                int element1 = matrix.get(i).get(2 * n - 1 - j);
                int element2 = matrix.get(2 * n - 1 - i).get(j);
                int element3 = matrix.get(2 * n - 1 - i).get(2 * n - 1 - j);

                maxSum += Math.max(element, Math.max(element1, Math.max(element2, element3)));

            }
        }
        int [] arr= new int [10];
        Arrays.copyOf(arr, 9);
        return maxSum;


    }


}
