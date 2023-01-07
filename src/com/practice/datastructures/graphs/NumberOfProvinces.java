package com.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 07/01/2023
 * Time: 10:56
 * ⚡  - Data-Structures
 */

public class NumberOfProvinces {

    private static void dfs (int node,List<List<Integer>> adjLs, int[] visited){
        visited[node]=1;

        for (Integer it: adjLs.get(node)){
            if (visited[it]==0){
                dfs(it, adjLs, visited);
            }
        }
    }



    private static int numberOfProvinces(List<List<Integer>>adj, int V){
        List<List<Integer>> adjList= new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        //to change adjacency matrix to list
        for (int i=0;i<V; i++){
            for (int j=0; j<V; j++){
                if (adj.get(i).get(j)==1 && i !=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int [] visited = new int[V];
        int cnt=0;
        for (int i = 0; i <V ; i++) {
           if (visited[i]==0){
               cnt++;
               dfs(i, adjList, visited);
           }
        }
        return cnt;
    }
}
