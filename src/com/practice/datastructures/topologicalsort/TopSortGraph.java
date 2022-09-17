package com.practice.datastructures.topologicalsort;

import java.util.*;

/**
 * created with love by mundiaem
 * created on 16/09/2022
 * Time: 12:46
 * ⚡  - Data-Structures
 */

public class TopSortGraph {


    private static void topoSort(Graph g){
        //Fetching the number of nodes in the graph
        int V= g.getSize();

        //List where we'll be sorting the topological order
        List<Integer> order = new ArrayList<>();

        // Map which indicates if a node is visited
        //(has been processed by the algorithm)

        Map<Integer, Boolean> visited = new HashMap<>();
        for(GraphNode tmp: g.getNodes()){
            visited.put(tmp.getId(), false);
        }


        // we go through the nodes using black magic
        for(GraphNode temp: g.getNodes()){
            if(!visited.get(temp.getId())){
                blackMagic(g, temp.getId(), visited,order);
            }
        }
        // we reverse the order we constructed to get the
        // proper toposorting

        Collections.reverse(order);
        System.out.println(order);
    }

    private static void blackMagic(Graph g, int id, Map<Integer, Boolean> visited, List<Integer> order) {

        //Mark the current node as visited
        visited.replace(id, true);

        Integer i;

        // we reuse the algorithm on all adjacent
        //node to the current node

        for(Integer neighborId: g.getNode(id).getNeighbors()){
            if(!visited.get(neighborId))
                blackMagic(g, neighborId, visited, order);
        }

        // Put the current node in the array

        order.add(id);
    }
}
