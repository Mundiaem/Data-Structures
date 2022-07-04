package com.practice.datastructures;

import com.practice.datastructures.arrays.ArrayPractice;
import com.practice.datastructures.calls.Value;
import com.practice.datastructures.search.BinarySearch;
import com.practice.datastructures.tree.avl.AvlTree;
import com.practice.datastructures.tree.binarytree.BinaryTree;

import java.util.Arrays;

//https://www.javatpoint.com/collections-in-java
//https://www.scaler.com/topics/data-structures/avl-tree/#balance-factor
//https://www.educative.io/courses/data-structures-in-java-an-interview-refresher/JYlwQZmN7V9?aid=5082902844932096&utm_source=google&utm_medium=paid&utm_campaign=dynamic_core&utm_term=&utm_campaign=%5BDynamic%5D+Programming+Verticals&utm_source=adwords&utm_medium=ppc&hsa_acc=5451446008&hsa_cam=16452540641&hsa_grp=132633981983&hsa_ad=585209036155&hsa_src=g&hsa_tgt=dsa-1635638188306&hsa_kw=&hsa_mt=&hsa_net=adwords&hsa_ver=3&gclid=CjwKCAjw_ISWBhBkEiwAdqxb9qp6xiz_p725G05e0QwDIU59eKcOWhxINPJJDdh25g0t7ErVY_g7wxoCmKgQAvD_BwE
//https://www.scaler.com/topics/data-structures/space-complexity-in-data-structure/
//https://www.scaler.com/topics/data-structures/#section-1
//http://www.btechsmartclass.com/data_structures/single-linked-list.html
//https://www.programiz.com/dsa/avl-tree
//https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
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
//        Integer[] arr = {4, 5, 3, 6, 7, 8, 9, 12, 23, 34, 56, 78, 90, 20, 13, 14, 15, 16, 17, 21};
//        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
//        binaryTree.constructBST(arr);
//        System.out.println("-------- Inorder transversal---------");
//        binaryTree.inorderTransversal(binaryTree.getRoot());
//        System.out.println(" --------- PreOrder transversal ------------- ");
//        binaryTree.preOrderTransversal(binaryTree.getRoot());
//        System.out.println(" --------- PostOrder transversal ------------- ");
//        binaryTree.postorderTransversal(binaryTree.getRoot());
//        System.out.println(" --------- LevelOrder transversal ------------- ");
//        binaryTree.levelOrderTransversal(binaryTree.getRoot());


//        int x = 3, l = 0, h = arr.length;
//        Arrays.sort(arr);
//        BinarySearch binarySearch= new BinarySearch();
//        System.out.println(binarySearch.binarySearch(arr, x, l, h));
//        System.out.println(arr[binarySearch.binarySearch(arr, x, l, h)]);;

        AvlTree avlTree = new AvlTree();
        avlTree.node = avlTree.insert(avlTree.node, 10);
        avlTree.node = avlTree.insert(avlTree.node, 20);
        avlTree.node = avlTree.insert(avlTree.node, 30);
        avlTree.node = avlTree.insert(avlTree.node, 50);
        avlTree.node = avlTree.insert(avlTree.node, 40);

     /* The constructed AVL Tree would be
             20
            /  \
          10     40
                 / \
                30  50
        */

        System.out.println("Pre-order Traversal of the AVL Tree is : ");
        avlTree.pre_order(avlTree.node);

        AvlTree tree = new AvlTree();
        System.out.println();
        /* Constructing tree given in the above figure */
        tree.node = tree.insert(tree.node, 10);
        tree.node = tree.insert(tree.node, 20);
        tree.node = tree.insert(tree.node, 30);
        tree.node = tree.insert(tree.node, 40);
        tree.node = tree.insert(tree.node, 50);
        tree.node = tree.insert(tree.node, 25);
           /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" + " of constructed tree is : ");
        tree.pre_order(tree.node);
    }

    ;
}
