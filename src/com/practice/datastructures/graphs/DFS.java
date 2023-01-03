package com.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {
/*
* Space Complexity
* Time Complexity
* recursion > edges 2xE | for loop > O(N) > O(N)+(2xE)
* */

    private static void dfs(int node, boolean[] visited, List<List<Integer>>adj, List<Integer> list){
        //Marking current node as visited
        visited[node]=true;
        list.add(node);
        for (Integer it: adj.get(node)){
            if (!visited[it]){
                dfs(it, visited, adj, list);
            }
        }
    }
    private static List<Integer> dfsOfGraph(int V, List<List<Integer>> adj){
        //boolean array to keep track of visited vertices
        boolean[] visited =new boolean[V+1];
        visited[0]=true;
        ArrayList<Integer> ls= new ArrayList<>();
        dfs(0, visited, adj,ls);
        return ls;
    }
}
