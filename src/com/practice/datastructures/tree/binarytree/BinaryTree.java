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

import java.util.LinkedList;
import java.util.Queue;

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

    /*
     * Breadth First Search BFS
     * users
     * 1. inorder
     * 2. preorder
     * 3. post order
     *  The algorithm start from the root node and then explores each branch before backtracking
     * implemented using stack. Takes advantage of the recursion to backtrack because the left and right branches
     * have the properties of a tree*/
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

    /*
     * Depth First Search
     * 1. Level order
     * uses queues
     * The algorithm begin at the root and visit each child level by level.
     * This means that after the root it visits it's direct children, then moves to the children's leave and so on   */

    //level order
    // uses queue to keep track of the visited nodes,
    // After visiting the node, its children are put into the queue
    // to ge the node to transverse with retrieve element from the queue.
    // Algorithm
    // 1. initialize an empty queue
    // 2. start by setting temp as the root
    // 3. Run Loop till the queue is not empty
    //  print the data from the queue
    //  enqueue the element from the left then right
    //  dequeue a node from queue and assign value from to temp.
    public void levelOrderTransversal(Node<T> current) {
        Queue<Node<T>> nodeQueue = new LinkedList<>();
        nodeQueue.add(current);
        while (!nodeQueue.isEmpty()) {
            //pool the root of the current node
            Node<T> tNode = nodeQueue.poll();
            System.out.println("Data: " + tNode.data);
            //add the left child to the queue
            if (tNode.left != null) {
                nodeQueue.add(tNode.left);
            }
            //add the right child to the queue
            if (tNode.right != null) {
                nodeQueue.add(tNode.right);
            }
        }

    }


}
