package com.practice.datastructures.tree.avl;

public class AvlTree {

   public Node node;

    //This method will return the height of the Node object
    int get_height(Node root) {
        if (root == null) {
            return -1;

        }
        return root.height;
    }

    // This method is used to calculate the balance factor of the specified
    // Node object
    int get_balance_factor(Node root) {
        if (root == null) {
            return 0;
        }
        return (get_height(root.left_child) - get_height(root.right_child));
    }

    // This method is used to print the elements of the AVL tree
    // using the pre-order traversal technique.
    public void pre_order(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            pre_order(root.left_child);
            pre_order(root.right_child);
        }
    }

    // This method is used to perform LL rotation on the specified
    // imbalanced node.
    Node LL_rotation(Node root) {
        Node child = root.left_child;
        root.left_child = child.right_child;
        child.right_child = root;
        root.height = Math.max(get_height(root.left_child), get_height(root.right_child)) + 1;
        child.height = Math.max(get_height(child.left_child), get_height(child.right_child)) + 1;
        return child;
    }

    //This method is used to perform RR rotation on
    // the specified imbalanced node
    Node RR_rotation(Node root) {
        Node child = root.right_child;
        root.right_child = child.left_child;
        child.left_child = root;
        root.height = Math.max(get_height(root.left_child), get_height(root.right_child)) + 1;
        child.height = Math.max(get_height(child.left_child), get_height(child.right_child)) + 1;
        return child;
    }

    // It is a recursive function that is used to insert
    // a node in the AVL tree
    public Node insert(Node root, int value) {
// BST Insertion Logic
        if (root == null) return (new Node(value));
        if (value < root.data) root.left_child = insert(root.left_child, value);
        else if (value > root.data) root.right_child = insert(root.right_child, value);
        else return root;
        // Balance Factor check

        root.height = Math.max(get_height(root.left_child), get_height(root.right_child)) + 1;
        int b = get_balance_factor(root);

        // Checking if the node insertion results in Left heavy or Right heavy nodes.
        if (b > 1) {
            //LL Rotation Case | Clockwise
            if (get_balance_factor(root.left_child) == 1) {
                root = LL_rotation(root);
            }
            // LR Rotation Case
            else {
                root.left_child = RR_rotation(root.left_child);
                root = LL_rotation(root);
            }
        } else if (b < -1) {
            //RR Rotation Case | anti-clockwise rotation
            if (get_balance_factor(root.right_child) == -1) {
                root = RR_rotation(root);
            }
            // RL Rotation Case
            else {
                root.right_child = LL_rotation(root.right_child);
                root = RR_rotation(root);
            }
        }
        return root;
    }

}
