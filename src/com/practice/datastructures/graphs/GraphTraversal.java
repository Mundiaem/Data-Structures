package com.practice.datastructures.graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * created with love by mundiaem
 * created on 23/06/2022
 * Time: 05:38
 * ⚡  - DataStructures
 */
//DFS and BFS
// DFS Technique for undirected graph
public class GraphTraversal {
    private int vertices;
    //adjacency list declaration
    private LinkedList<Integer> adj_list[];

    public GraphTraversal(int v) {
        vertices = v;
        adj_list = new LinkedList[v];
        for (int i = 1; i < v; ++i) {
            adj_list[i] = new LinkedList<>();
        }
    }

    //add an edge to the graph
    public void addEdge(int v, int w) {
        adj_list[v].add(w);// Add w to v's list
    }

    // helper function for DFS technique
    void DFS_helper(int v, boolean visited[]) {
        //current node is visited
        visited[v] = true;
        System.out.print(v + " ");

        // process all adjacent vertices
        Iterator<Integer> i = adj_list[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFS_helper(n, visited);
            }
        }
    }

    public void DFS(int v) {
        //initially none of the vertices are visited
        boolean visited[] = new boolean[vertices];
        DFS_helper(v, visited);
    }
}
