package com.practice.datastructures.linkedList;

/**
 * created with love by mundiaem
 * created on 05/07/2022
 * Time: 22:54
 * ⚡  - Data-Structures
 */

public class SinglyLinkedList<T extends Comparable<T>> implements LinkedList<T> {
    public Node<T> head;
    public int size;

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public void addFirst(T t) {
        Node<T> newHead = new Node<>(t);
        newHead.next = head;
        head = newHead;
    }

    @Override
    public void addLast(T t) {
        Node<T> newNode = new Node<>(t);
        Node<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = null;
    }

    @Override
    public void add(T t, T target) {
        Node<T> newNode = new Node<>(t);
        Node<T> curr = head;

        while (curr.data.compareTo(target) != 0) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;

    }

    @Override
    public boolean pop() {
        return false;
    }

    @Override
    public boolean popLast() {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void remove(T t) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public T getFist() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void deleteFist() {
        head = head.next;
    }

    // O(N)
    @Override
    public void deleteLast() {
        Node<T> curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
    }

    @Override
    public void delete() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void set(int index, T t) {

    }

    @Override
    public Node<T> search(T target) {
        Node<T> curr = head;
        while (curr != null && curr.data != target) {
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public void display() {
        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
