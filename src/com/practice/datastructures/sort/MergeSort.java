package com.practice.datastructures.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr= {3,6,9,1,5,2,4,7,8,12,32,56,43,78,89};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    private static void mergeSort(int [] arr){
        int n= arr.length;
        if(n<=1) return;
        int leftSize = n /2;
        int rightSize= n- leftSize;
        int [] leftArray  =  new int[leftSize];
        int [] rightArray = new int[rightSize];

        int i=0, j=0;
        for (; i<n; i++){
            if(i<leftSize){
                leftArray[i]=arr[i];
            }else{
                rightArray[j]= arr[i];
                j++;
            }
        }



        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, arr);

    }
    private static void merge(int [] leftArray, int [] rightArray, int [] arr){
        int l=0, r=0, leftSize=leftArray.length, rightSize= rightArray.length, i=0;
        while (l<leftSize && r<rightSize){
            if(leftArray[l] < rightArray[r]){
                arr[i]=leftArray[l];
                i++;
                l++;
            }else{
                arr[i]=rightArray[r];
                i++;
                r++;
            }
        }
        while(l<leftSize){
            arr[i]=leftArray[l];
            i++;
            l++;
        }
        while (r<rightSize){
            arr[i]=rightArray[r];
            i++;
            r++;
        }


    }
}
