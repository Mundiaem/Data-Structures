package com.practice.datastructures.tree.basetree;
//class for node implementation: using generic data types
public class Node<T> {
    T data;
    Node<T> right, left;

    public Node(T key) {
        this.data = key;
        left= right =null;
    }
}
