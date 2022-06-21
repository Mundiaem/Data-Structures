package com.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 21/06/2022
 * Time: 22:36
 * ⚡  - DataStructures
 */

public class GraphAdjacency {
    // define adjacency list
    List<List<Node>> adj_list = new ArrayList<>();

    //Graph Constructor

    public GraphAdjacency(List<Edge> edges) {
        // adjacency list memory allocation
        for (int i=0; i<edges.size(); i++){
            adj_list.add(i, new ArrayList<>());
        }
        // add edges to the graph
        for (Edge e: edges){
            adj_list.get(e.src).add(new Node(e.dest, e.weight));

        }
    }
}
