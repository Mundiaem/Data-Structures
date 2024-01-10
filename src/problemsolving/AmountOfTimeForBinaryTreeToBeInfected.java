package problemsolving;

import com.practice.datastructures.tree.binarytree.BinaryTree;
import com.practice.datastructures.tree.binarytree.Node;
import org.w3c.dom.ls.LSOutput;

import javax.swing.tree.TreeNode;
import java.util.*;

public class AmountOfTimeForBinaryTreeToBeInfected {


    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree= new BinaryTree<>();
        Integer [] tree= {1,5,3,4,10,6,9,2};
        Node<Integer> node1= binaryTree.constructBST(tree);
        System.out.println(BFS.amountOfTime(node1, 3));
    }


}
class BFS{
    private static void convert(Node<Integer> current, int parent, Map<Integer, Set<Integer>> map){

        if(current==null) return;
        if (!map.containsKey(current.data)){
            map.put(current.data, new HashSet<>());
        }
        Set<Integer> adj= map.get(current.data);
        if(parent!=0) adj.add(parent);
        if(current.left!=null) adj.add(current.left.data);
        if(current.right!=null) adj.add(current.right.data);
        convert(current.left, current.data, map);
        convert(current.right, current.data, map);

    }
    public static int amountOfTime(Node<Integer> root, int start){
        Map<Integer, Set<Integer>> map= new HashMap<>();
        int minutes =0;
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        convert(root, 0, map);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        while (!q.isEmpty()){
            int levelSize= q.size();
            while (levelSize >0){
                int curr= q.poll();
                    for(int num: map.get(curr)){
                        if(!visited.contains(num)){
                            visited.add(num);
                            q.add(num);
                        }

                        }

                levelSize--;
            }
            minutes++;


        }

        return minutes -1;
    }
}

