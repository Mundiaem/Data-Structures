package com.practice.datastructures;

import com.practice.datastructures.arrays.ArrayPractice;
import com.practice.datastructures.search.BinarySearch;

import java.util.Arrays;

//https://www.javatpoint.com/collections-in-java
public class Main {

    public static void main(String[] args) {
        // write your code here
        // new SmallestLargestNumber().test();
//        new ArrayPractice().practice();
        int[] arr = {4, 5, 3, 6, 7, 8, 9, 12, 23, 34, 56, 78, 90, 20, 13, 14, 15, 16, 17, 21};

        int x = 3, l = 0, h = arr.length;
        Arrays.sort(arr);
        BinarySearch binarySearch= new BinarySearch();
        System.out.println(binarySearch.binarySearch(arr, x, l, h));
        System.out.println(arr[binarySearch.binarySearch(arr, x, l, h)]);;


    }

    ;
}
