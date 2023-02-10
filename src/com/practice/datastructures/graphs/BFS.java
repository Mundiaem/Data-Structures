package com.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.practice.datastructures.graphs.Graph.createGraph;

public class BFS {

    /*
    Approach
    Queue Data structure
    * Queue - FIFO
    - visited[]
    - what is in the queue take it out until the queue is not empty
    -
    * */

    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> adjList=  createGraph(15);

        System.out.println(bfsOfGraph(adjList.size()+1, adjList));
    }

    private static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>>adj){
        ArrayList<Integer> bfs= new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0]=true;

        while (!q.isEmpty()){
            Integer node= q.poll();
            bfs.add(node);
            // Get all adjacent vertices of dequeued
            //If an adjacent has not been visited
            //  and enqueue it
            for (Integer it: adj.get(node)){
                if (!visited[it]){
                    visited[it]=true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}
