package com.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 21/06/2022
 * Time: 22:36
 * ⚡  - DataStructures
 * https://www.softwaretestinghelp.com/java-graph-tutorial/
 */

public class GraphAdjacency {
    // define adjacency list
    List<List<Node>> adj_list = new ArrayList<>();

    //Graph Constructor

    public GraphAdjacency(List<Edge> edges) {
        // adjacency list memory allocation
        for (int i = 0; i < edges.size(); i++) {
            adj_list.add(i, new ArrayList<>());
        }
        // add edges to the graph
        for (Edge e : edges) {
            //allocate new node in adjacency list from src to dest
            adj_list.get(e.src).add(new Node(e.dest, e.weight));

        }
    }

    public static void printGraph(GraphAdjacency graphAdjacency) {
        int src_vertex = 0;
        int list_size = graphAdjacency.adj_list.size();
        System.out.println(" The content of the graph");
        while (src_vertex < list_size) {
            //traverse through the adjacency list and print the edges
            for (Node edge : graphAdjacency.adj_list.get(src_vertex)) {
                System.out.println(" Vertex: " + src_vertex + " ==> " + edge.value + " (" + edge.weight + ")\t");
            }
            System.out.println();
            src_vertex++;
        }
    }
}
