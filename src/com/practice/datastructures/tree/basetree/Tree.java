package com.practice.datastructures.tree.basetree;

import com.practice.datastructures.calls.Value;
import com.practice.datastructures.tree.binarytree.Node;

public class Tree<T extends Value> {
    Node<T> root;

    public Tree() {
        this.root = null;
    }

    public Node<T> addRecursive(Node<T> current, T t) {

        return current;
    }
}
