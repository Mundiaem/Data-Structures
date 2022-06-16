package com.practice.datastructures.tree.binarytree;

//class for node implementation
public class Node<T extends Comparable<T>> {
    T data;
    Node<T> right, left;

    public Node(T item) {
        this.data = item;
        left = right = null;
    }


}
