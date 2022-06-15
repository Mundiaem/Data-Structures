package com.practice.datastructures.sort;

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

    //method to find the partition position
    static int partition(int arr[], int low, int high) {
        //choose the rightmost element as pivot
        int pivot = arr[high];

        // pointer for greater element
        int i = (low - 1);

        // traverse through all elements
        // compare each element with the pivot
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                // if element smaller than the pivot is found
            }
        }
        return 0;

    }

}