package com.practice.datastructures.arrays;

public class SmallestLargestNumber {
    public void test() {
        int[] arr = new int[]{0,1, 21, 45, 65,569,982, 78, 97, 23, 4, 65, 41, 90, 91, 43, 56, 71, 81, 82, 73, 74, 75, 76, 83, 84, 85, 86, 87, 92, 93, 94, 95, 96, 97, 98};
        int smallest = arr[0];
        int largest = arr[0];
        for (int i = 0; i <= arr.length-1; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }else if (arr[i]<smallest){
                smallest=arr[i];
            }
        }
        System.out.println(" largest number: "+largest);
        System.out.println(" smallest number: "+smallest);


    }
}
