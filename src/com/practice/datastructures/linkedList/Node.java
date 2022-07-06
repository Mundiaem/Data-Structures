package com.practice.datastructures.linkedList;

/**
 * created with love by mundiaem
 * created on 05/07/2022
 * Time: 23:34
 * ⚡  - Data-Structures
 */

public class Node<T> {
    T data;// generic data type
    Node<T> next;// pointer to the next node

    public Node(T val) {
        this.data = val;
        this.next = null;
    }
}
