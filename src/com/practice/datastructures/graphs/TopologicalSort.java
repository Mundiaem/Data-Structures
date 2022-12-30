package com.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * created with love by mundiaem
 * created on 30/12/2022
 * Time: 10:12
 * ⚡  - Data-Structures
 */

public class TopologicalSort {

    public static void main(String[] args) {
        /*
        *
        * 3 4
3 0
3 2
0 2
        * */
        System.out.println();
    }
    private static void dfs(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>>adj){
            visited[node]=1;
            for (int it: adj.get(node)){
                if(visited[it]==0){
                    dfs(it, visited, st, adj);
                }
                st.push(node);
}

    }
    // method to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>>adj){
        int[] visited = new int[V];
        Stack<Integer> stack= new Stack<>();
        for(int i=0; i<V; i++){
            if(visited[i]==0){
                dfs(i, visited, stack,adj);
            }
        }
        int [] ans= new int[V];
        int i=0;
        while (!stack.isEmpty()){
            ans[i++]= stack.peek();
            stack.pop();
        }
        return ans;
    }
}
