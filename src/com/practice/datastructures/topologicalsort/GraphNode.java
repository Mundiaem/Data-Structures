package com.practice.datastructures.topologicalsort;

import java.util.ArrayList;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 16/09/2022
 * Time: 12:26
 * ⚡  - Data-Structures
 */

public class GraphNode {


    private int id;
    private List<Integer> neighbors;


    public GraphNode(int id){
        this.id= id;
        this.neighbors= new ArrayList<>();
    }

    public void addNeighbor(int e){
        this.neighbors.add(e);
    }

    public int getId(){
        return id;
    }

    public List<Integer> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "id=" + id +
                ", neighbors=" + neighbors +
                '}';
    }
}
