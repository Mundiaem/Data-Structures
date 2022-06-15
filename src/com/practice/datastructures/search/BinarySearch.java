package com.practice.datastructures.search;

public class BinarySearch {


    public int binarySearch(int[] arr, int x, int l, int h) {

        /* Algorithm
        * - ignore the half of the elements
        * 1. compare x with the mid point
        * 2. if x matches with the middle element, we return the mid index
        * 3. Else if x is greater than the mid point element then the element can only lie
        * in the right half of the subarray after the mid element. So we recur for the right half.
        * 4. Else (x is smaller) recur for the left half
        *  */
        /*Steps
        * 1. find the lowest and highest
        * 2.
        *  */
        if (h >= l) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            // mid index value is greater that x
            if (arr[mid] > x)
                //lies on the left part of the array
                return binarySearch(arr, x, l, mid - 1);
            // mid index value is less that x: lies on the right part of the array x is greater than the mid point
            if (arr[mid] < x)
                return binarySearch(arr, x, mid + 1, h);

        }
        return -1;
    }
}
