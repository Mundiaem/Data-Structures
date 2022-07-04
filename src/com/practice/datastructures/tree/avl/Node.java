package com.practice.datastructures.tree.avl;

public class Node {
    int height;
    int data;
    Node left_child;
    Node right_child;


    public Node(int val) {
        this.data = val;
        this.height = 0;
    }
}
