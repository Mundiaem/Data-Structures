package problemsolving;

import com.practice.datastructures.tree.binarytree.BinaryTree;
import com.practice.datastructures.tree.binarytree.Node;
import org.w3c.dom.ls.LSOutput;

import javax.swing.tree.TreeNode;
import java.util.*;

public class AmountOfTimeForBinaryTreeToBeInfected {


    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        Integer[] tree = {1, 5, 3, 4, 10, 6, 9, 2};
        Node<Integer> node1 = binaryTree.constructBST(tree);
        System.out.println(BFS.amountOfTime(node1, 3));
        System.out.println(DFS.amountOfTime(node1, 3));

    }


}

class BFS {
    private static void convert(Node<Integer> current, int parent, Map<Integer, Set<Integer>> map) {

        if (current == null) return;
        if (!map.containsKey(current.data)) {
            map.put(current.data, new HashSet<>());
        }
        Set<Integer> adj = map.get(current.data);
        if (parent != 0) adj.add(parent);
        if (current.left != null) adj.add(current.left.data);
        if (current.right != null) adj.add(current.right.data);
        convert(current.left, current.data, map);
        convert(current.right, current.data, map);

    }

    public static int amountOfTime(Node<Integer> root, int start) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int minutes = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        convert(root, 0, map);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            while (levelSize > 0) {
                int curr = q.poll();
                for (int num : map.get(curr)) {
                    if (!visited.contains(num)) {
                        visited.add(num);
                        q.add(num);
                    }

                }

                levelSize--;
            }
            minutes++;


        }

        return minutes - 1;
    }
}

/**
 * Intuition
 * The above solution passed over each node twice, once to create an undirected graph, and again to complete the breath first search. Is there a way to find the maximum distance from the start node with only one pass?
 * <p>
 * If the the node with the value start happened to be the root, the maximum distance from the start node would be equivalent to the maximum depth of the tree. We can also reason that there are certain test cases where the maximum depth of the start node's sub-tree would be the maximum distance from the start node. An example case where this is true is [1, 2, null, 3, null, 4, null] where the start node is 2. In this case, all nodes have only one child.
 * <p>
 * Is there a way to calculate the maximum distance from the start node using subtree depths, even when the start node is not the root? This would help us solve the problem in just one pass.
 * <p>
 * The first question we need to solve is "Can we determine the max distance of the start node using the depths of sub-trees?" We use the image below to demonstrate a method for determining the max distance using sub-tree depths.
 * <p>
 * Tree with Highlighted Nodes
 * <p>
 * In the image above the start node is the red node, 5.
 * subDepth = 2 // red subtree's depth (Nodes below the start node)
 * depth = 1 // red node's depth (the start node)
 * otherDepth = 2 // green subtree depth (nodes above the start node)
 * distance = depth + other_depth = 3 // distance of any node above the start node from the start node
 * maxDistance = max(distance, sub_depth) = 3
 * <p>
 * Knowing that we can calculate the maximum distance from the start node using subtree depths, we can attempt a one-pass method of solving this problem. We can base our algorithm on a calculation of max depth using a depth-first search.
 * <p>
 * Here is the basic recursive algorithm for finding the maximum depth, which we will adjust to our needs.
 * <p>
 * If root = null return 0.
 * Make a recursive call with root.right and save as rightDepth.
 * Make a recursive call with root.left and save as leftDepth.
 * Return max(rightDepth, leftDepth) + 1.
 * One challenge to this task is identifying whether we have encountered the start node during the traversal. We can return a negative depth when we encounter the start node. This will flag that we have found the start node, and as we traverse the tree, whenever we encounter a negative depth, we know the subtree contains the start node.
 * <p>
 * Additionally, as we traverse the tree, we might find the start node before we have calculated the max depth of each part of the tree. Therefore, we need to be able to save the max distance and continue calculating it while traversing the rest of the tree.
 * <p>
 * There are four main cases:
 * <p>
 * If root is null, return 0.
 * root.val = start. If so, we return depth = -1 to signify this is the start node. In this way, in subsequent recursive calls, the parent node of the start node will know whether its child nodes contain the start node. Here we are also able to calculate the maxDistance of any node in the start node's subtree by finding the max of the left and right depth.
 * The left and right depth are both positive. If they are, we know the start node is not in this subtree, and we can set depth = max(leftDepth, rightDepth) just like with the basic max depth.
 * The final case is when the root is not the start node, but its subtree contains the start node. In this case, we will set depth = min(leftDepth, rightDepth) - 1, which will give us a negative number, the absolute value of which represents the distance of the start node to the root node. To calculate the distance from the start node to the furthest node in the other subtree, we will add the absolute value of the negative depth of the subtree that contains the start node, and the positive depth of the other subtree, for convenience, we can directly take the absolute value of two values. Then, we update maxDistance with distance if it is larger.
 * Algorithm
 * Declare a variable maxDistance to store maximum distance from the start node.
 * Define a function traverse that performs a depth-first search of the tree that returns depth and calculates and saves maxDistance.
 * For each call to traverse, we have a new root and declare a variable depth = 0.
 * If root == null set depth = 0 and return.
 * Recursively call traverse with root.right and save in the variable rightDepth.
 * Recursively call traverse with root.left and save in the variable leftDepth.
 * If root = start the root is the start node:
 * Set maxDistance = max(leftDepth, rightDepth) to calcualte the start node's max depth.
 * Set depth = -1 to signify this is the start node.
 * If the leftDepth and rightDepth are both positive, the start node is not in this subtree:
 * Set depth = max(leftDepth, rightDepth) + 1 to calculate the current root's max depth.
 * Else, the current root's subtree contains the start node:
 * Define a variable distance as the sum of abs(leftDepth) and abs(rightDepth), which is the distance of the furthest node in the other subtree.
 * Set maxDistance = max(maxDistance, distance) to update maxDistance if distance is larger.
 * Set depth = min(leftDepth, rightDepth) - 1 to calculate a negative number that signifies the subtree contains the start node and represents the distance of the start node from the root.
 * return depth.
 * Call traverse(root, start).
 * Return maxDistance.
 * <p>
 * Complexity
 * Let nnn be the number of nodes in the tree.
 * <p>
 * Time complexity: O(n)
 * <p>
 * Traversing the tree with a DFS costs O(n) as we visit each node exactly once.
 * <p>
 * Space complexity: O(n)
 * <p>
 * The space complexity of DFS is determined by the maximum depth of the call stack,
 * which corresponds to the depth of the tree (or the graph in our case).
 * In the worst case, if the tree is completely unbalanced (e.g., a linked list),
 * the call stack can grow as deep as the number of nodes, resulting in a space complexity of O(n).
 */
class DFS {
    static int maxDistance = 0;

    public static int amountOfTime(Node<Integer> root, int start) {
        traverse(root, start);
        return maxDistance;
    }

    private static int traverse(Node<Integer> root, int start) {
        int depth = 0;
        if (root == null) return depth;

        int leftDepth = traverse(root.left, start);
        int rightDepth = traverse(root.right, start);

        if (root.data == start) {
            maxDistance = Math.max(leftDepth, rightDepth);
            depth = -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            depth = Math.max(leftDepth, rightDepth) + 1;
        } else {
            int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
            maxDistance = Math.max(maxDistance, distance);
            depth = Math.min(leftDepth, rightDepth) - 1;
        }
        return depth;


    }
}
