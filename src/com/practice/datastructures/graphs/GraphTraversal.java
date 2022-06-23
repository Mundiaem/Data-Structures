package com.practice.datastructures.graphs;

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
    private LinkedList[] adj_list;

    public GraphTraversal(int v) {
        vertices=v;
        adj_list=new LinkedList[v];
        for (int i=1; i<v; ++i){
            adj_list[i]=new LinkedList<>();
        }
    }
}
