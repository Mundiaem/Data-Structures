package com.practice.datastructures.tree.binarytree;

/*
* TODO
*  1. BFS
*  2. DFS
*  3. Height
*  4. Width
*  5. Delete
*  6. Search
*  7. Size
*  8. Augmenting a BST
* */

public class BinaryTree<T extends Comparable<T>> {
    Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    //insert node
    public void insertItem(T t) {
        root = new Node<T>(t);
    }

    public Node<T> addRecursive(Node<T> current, T t) {
        //adding the root:
        // check if the tree is null
        // true > add item
        // false > add element on the vertices/ leafs
        if (current == null) {
            return new Node<>(t);
        }
        // current data value is greater than value t
        if (current.data.compareTo(t) > 0) {
            current.left = addRecursive(current.left, t);
            // current data value is less than value t
        } else if (current.data.compareTo(t) < 0) {
            current.right = addRecursive(current.right, t);


        } else {
            return current;
        }
        return current;
    }

    public Node<T> constructBST(T[] ts) {
        Node<T> root = null;
        for (T t : ts) {
            root = addRecursive(root, t);

        }
        this.root = root;
        return root;
    }

    //in-order transversal l subtree ->current node > right subtree
//from the lowest to the highest
    public void inorderTransversal(Node<T> root) {
        if (root == null) {
            return;
        }
        // travel to the left subtree first
        inorderTransversal(root.left);
        // print the current node value next
        System.out.println(" data: " + root.data);
        // travel to the right subtree last
        inorderTransversal(root.right);
    }

    public Node<T> getRoot() {
        return root;
    }
//pre-order transversal current node ->left  subtree > right subtree

    public void preOrderTransversal(Node<T> root) {
        if (root == null) {
            return;
        }
        // print the current node value first
        System.out.println(" data: " + root.data);
        //travel to the left subtree next
        preOrderTransversal(root.left);
        //travel to the right subtree last
        preOrderTransversal(root.right);
    }

    //postorder transversal left  subtree > right subtree > current node
    public void postorderTransversal(Node<T> root) {
        if (root == null) {
            return;
        }

        // travel to the left subtree first
        postorderTransversal(root.left);
        // travel to the right subtree next
        postorderTransversal(root.right);
        // print the current node value last
        System.out.println(" data: " + root.data);


    }


}
