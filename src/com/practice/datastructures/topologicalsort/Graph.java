package com.practice.datastructures.topologicalsort;

import java.util.ArrayList;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 16/09/2022
 * Time: 12:19
 * ⚡  - Data-Structures
 */

public class Graph {
List<GraphNode> nodes;
public Graph(){
    this.nodes= new ArrayList<>();
}

public Graph(List<GraphNode> nodes){
    this.nodes=nodes;
}

public void addNode(GraphNode e){
    this.nodes.add(e);
}

public List<GraphNode> getNodes(){
    return nodes;
}


public GraphNode getNode(int searchId){
    for(GraphNode node:this.getNodes()){
        if(node.getId()==searchId){
            return node;
        }
    }
    return null;
}


public int getSize(){
    return this.nodes.size();
}

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                '}';
    }
}
