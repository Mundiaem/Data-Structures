package com.practice.datastructures.graphs;

import java.util.ArrayList;

public class Graph {

    public static ArrayList<ArrayList<Integer>> createGraph(int V) {
        /*
         * 0 -> {}, 1 -> {2,6}, 2-> {1,3,4} , 3-> {2}, 4-> {2,5}, 5-> {4,8}, 6-> {7,9}, 7-> {6,8}, 8->{5,7}, 9->{6}
         *Time Complexity
         * - While (!Q.isEmpty()) > for(all nodes/ 2 edges per node) =>( O(N) + 2(E))
         * Space Complexity
         * O(3N) => O(N)
         * */
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(i, new ArrayList<>());
        }
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 0, 3);
        addEdge(adjList, 1, 2);
        return adjList;

    }

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int s, int d) {
        graph.get(s).add(d);
        graph.get(d).add(s);
    }


}
