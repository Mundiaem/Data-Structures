package com.practice.datastructures.sort;

import java.util.Arrays;

/*
Working of Quicksort
* 1. select the pivot element
- select the rightmost element of the array as the pivot
2. Rearrange the Array
- the elements of array are arranged so that elements that are smaller
than the pivot are put on the left and the elements greater than the pivot are put on the right
a. a pointer is fixed at the pivot element. the pivot element is compared with the elements beginning from the first index
b. if the element is greater than the pivot element, a second pointer is set for that element.
c. pivot is compared with other elements: if an element smaller than the pivot element is reached the smaller element is swapped with the greater element found earlier
d. the process is repeated to set the next greater element as the second pointer, and , swap it with another smaller element
e. the process goes on until the second last element is reached
f. finally, the pivot element is swapped with the second pointer
3. Divide Subarrays
Pivot elements are again chosen for the left and the right sub-parts separately, and step 2 is repeated
 */
public class Quicksort {
    public static void main(String[] args) {
        int[] arr = {-1, -3, 4, 5, 6, 2, 4, 6, 7, 10, 23, 56, 45, 89, 90, 43};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);

    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);

    }

    //method to find the partition position
    static int partition(int[] arr, int low, int high) {
        int index = low - 1;
        int pivot = arr[high];

        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                index++;
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        index++;
        int temp = arr[index];
        arr[index] = arr[high];
        arr[high] = temp;
        return index;


    }

}