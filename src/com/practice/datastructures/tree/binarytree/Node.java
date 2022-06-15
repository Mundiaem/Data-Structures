package com.practice.datastructures.tree.binarytree;
//class for node implementation
public class Node<T> {
    T data;
    Node<T> right, left;

    public Node(T key) {
        this.data = key;
        left= right =null;
    }
}
