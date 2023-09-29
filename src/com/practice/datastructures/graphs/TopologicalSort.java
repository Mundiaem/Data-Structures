package com.practice.datastructures.graphs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * created with love by mundiaem
 * created on 30/12/2022
 * Time: 10:12
 * ⚡  - Data-Structures
 */

public class TopologicalSort {

    public static void main(String[] args) {
        /*
        *
        * 3 4
3 0
3 2
0 2
        * */
        List<List<Integer>> adj = new ArrayList<>();

//        try {
//            Scanner input = new Scanner(new FileReader("src/com/practice/datastructures/graphs/input-topo.txt"));
//            int V = input.nextInt();
//            int E = input.nextInt();
//            for (int i = 0; i <V ; i++) {
//                adj.add(i, new ArrayList<>());
//            }
//
//
//            while (input.hasNextLine()) {
//                String[] ad = input.nextLine().split(" ");
//                if (!ad[0].isEmpty()) {
//
//                        for (int i = 1; i < ad.length; i++) {
//                            adj.get(Integer.parseInt(ad[0])).add(Integer.parseInt(ad[i]));
//
//                    }
//
//
//
//                }
//
//
//            }
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        for (int i = 0; i <2 ; i++) {
                adj.add(i, new ArrayList<>());
            }

        int[][] course = {{1, 0}, {0, 1}};
        for (int [] arr:course) {
            Integer[] nosWrapped = Arrays.stream(arr).boxed()
                    .toArray(Integer[]::new);

            adj.add(new ArrayList<>(List.of(nosWrapped)));

        }

        System.out.println(Arrays.toString(topoSort(2, adj)));
    }

    private static void dfs(int node, int[] visited, Stack<Integer> st, List<List<Integer>> adj) {
        visited[node] = 1;

        for (int it : adj.get(node)) {
            // System.out.println("it : " + it);

            if (visited[it] == 0) {
                dfs(it, visited, st, adj);
            }
            // System.out.println("Node : " + node);
            st.push(node);
        }

    }

    // method to return list containing vertices in Topological order.
    static int[] topoSort(int V, List<List<Integer>> adj) {
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                // System.out.println(" i " + i);
                dfs(i, visited, stack, adj);
            }
        }
        int[] ans = new int[V];
        int i = 0;
        while (!stack.isEmpty()) {

            ans[i++] = stack.peek();
            stack.pop();
        }
        return ans;
    }
}
