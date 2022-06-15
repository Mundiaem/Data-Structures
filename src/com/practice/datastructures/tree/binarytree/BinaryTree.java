package com.practice.datastructures.tree.binarytree;

import com.practice.datastructures.calls.Value;

public class BinaryTree<T extends Value> {
    Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public Node<T> addRecursive(Node<T> current, T t) {
        if (current.data == null) {
            return new Node<>(t);
        }
        if (current.data.intValue() > t.intValue()) {
            current.left= addRecursive(current.left, t);

        }else if (t.intValue()>current.data.intValue()){
            current.right= addRecursive(current.right, t);


        }else {
            return current;
        }
        return current;
    }

}
