package com.practice.datastructures;

import com.practice.datastructures.arrays.ArrayPractice;
import com.practice.datastructures.calls.Value;
import com.practice.datastructures.search.BinarySearch;
import com.practice.datastructures.tree.binarytree.BinaryTree;

import java.util.Arrays;

//https://www.javatpoint.com/collections-in-java
public class Main {

    public static void main(String[] args) {
        // write your code here
        // new SmallestLargestNumber().test();
//        new ArrayPractice().practice();
        //Cannot Instantiate Generic Types with Primitive Types thus use Integer
        /*
         * A int is a data type that stores 32 bit signed two's compliment integer.
         *  On other hand Integer is a wrapper class which wraps a primitive type int into an object.
         * int helps in storing integer value into memory.
         * Integer helps in converting int into object and to convert an object into int as per requirement.*/
        Integer[] arr = {4, 5, 3, 6, 7, 8, 9, 12, 23, 34, 56, 78, 90, 20, 13, 14, 15, 16, 17, 21};
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
        binaryTree.constructBST(arr);
        System.out.println("-------- Inorder transversal---------");
        binaryTree.inorderTransversal(binaryTree.getRoot());
        System.out.println(" --------- PreOrder transversal ------------- ");
        binaryTree.preOrderTransversal(binaryTree.getRoot());
        System.out.println(" --------- PostOrder transversal ------------- ");
        binaryTree.postorderTransversal(binaryTree.getRoot());
        System.out.println(" --------- LevelOrder transversal ------------- ");
        binaryTree.levelOrderTransversal(binaryTree.getRoot());


//        int x = 3, l = 0, h = arr.length;
//        Arrays.sort(arr);
//        BinarySearch binarySearch= new BinarySearch();
//        System.out.println(binarySearch.binarySearch(arr, x, l, h));
//        System.out.println(arr[binarySearch.binarySearch(arr, x, l, h)]);;


    }

    ;
}
