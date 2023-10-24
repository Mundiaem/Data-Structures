package com.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class courseSchedulingI {
    public static void main(String[] args) {
        int[][] course1 = {{1, 0}};

        int[][] course2 = {{1, 0}, {0, 1}};
        System.out.printf("Is it possible to take the courses? %s%n", canTakeTheCourse(2, course1));
        System.out.printf("Is it possible to take the courses? %s%n", canTakeTheCourse(2, course2));

    }

    private static boolean canTakeTheCourse(int V, int[][] prerequisites) {
        return V== topoLogicalSort(2, prerequisites).size() ;
    }

    private static List<Integer> topoLogicalSort(int V, int[][] prerequisites) {
        // Initialize and create the adjacent list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Create adjacent list front count = V
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        // create an inDegree
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        //Initialize a Queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        List<Integer> topo = new ArrayList<>();
        // loop through the Queue add
        while (!q.isEmpty()) {
            int node = q.remove();
            topo.add(node);

            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) q.add(neighbor);
            }
        }

        return topo;


    }
}
