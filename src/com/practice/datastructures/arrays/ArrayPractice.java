package com.practice.datastructures.arrays;

import java.util.Arrays;

public class ArrayPractice {
    public void practice() {
        int[] array1;
        int[] array2 = new int[4];
        int[] array3 = {4, 6, 6, 2, 4, 2};
        String[] shoppingList = {"banana", "apples", "pears"};
        array2[0] = 10;
        array2[1] = 8;
        array2[2] = 5;
        array2[3] = 10;
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array2));
        for (String s : shoppingList) {
            System.out.println(s);
        }

    }
}
