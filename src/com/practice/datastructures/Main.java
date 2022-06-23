package com.practice.datastructures;

import com.practice.datastructures.graphs.Edge;
import com.practice.datastructures.graphs.GraphAdjacency;

import java.util.Arrays;
import java.util.List;

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
        //  Integer[] arr = {4, 5, 3, 6, 7, 8, 9, 12, 23, 34, 56, 78, 90, 20, 13, 14, 15, 16, 17, 21};
//        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
//        binaryTree.constructBST(arr);
//        System.out.println("-------- Inorder transversal---------");
//        binaryTree.inorderTransversal(binaryTree.getRoot());
//        System.out.println(" --------- PreOrder transversal ------------- ");
//        binaryTree.preOrderTransversal(binaryTree.getRoot());
//        System.out.cprintln(" --------- PostOrder transversal ------------- ");
//        binaryTree.postorderTransversal(binaryTree.getRoot());


//        int x = 3, l = 0, h = arr.length;
//        Arrays.sort(arr);
//        BinarySearch binarySearch= new BinarySearch();
//        System.out.println(binarySearch.binarySearch(arr, x, l, h));
//        System.out.println(arr[binarySearch.binarySearch(arr, x, l, h)]);;
        graph();
    }

    private static void graph() {
        // define edges of the graph
        List<Edge> edges = Arrays.asList(new Edge(0, 1, 2), new Edge(0, 2, 4), new Edge(1, 2, 4), new Edge(2, 0, 5),
                new Edge(2, 1, 4), new Edge(3, 1, 3), new Edge(4, 5, 1),
                new Edge(5, 4, 3));
        // call graph class constructor to construct a graph
        GraphAdjacency graphAdjacency = new GraphAdjacency(edges);

        //print the graph as an adjacency list
        GraphAdjacency.printGraph(graphAdjacency);
    }

    ;
}
