package com.practice.datastructures.graphs;

import java.util.*;

public class BFSShortestReach {
    public static void main(String[] args) {
        // Sample input
        int n = 5; // number of nodes
        int m = 3; // number of edges
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(1, 3));
        edges.add(Arrays.asList(3, 4));
        int s = 1; // starting node

        List<Integer> distances = bfs(n, m, edges, s);
        System.out.println("Distances from node " + s + ": " + distances);
    }

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Create an adjacency list to represent the graph
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        List<Integer> distances = new ArrayList<>(Collections.nCopies(n, -1)); // Initialize distances with -1
        distances.set(s - 1, 0); // Distance to starting node is 0
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS traversal
        queue.offer(s); // Add the starting node to the queue

        // Create adjacency list representation of the graph
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjacencyList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int node = queue.poll(); // Remove the front node from the queue
            List<Integer> neighbors = adjacencyList.getOrDefault(node, new ArrayList<>()); // Get neighbors of the current node
            for (int neighbor : neighbors) {
                if (distances.get(neighbor - 1) == -1) { // Node hasn't been visited
                    distances.set(neighbor - 1, distances.get(node - 1) + 6); // Calculate distance
                    queue.offer(neighbor); // Add the neighbor to the queue for further exploration
                }
            }
        }

        // Prepare the result excluding the starting node's distance
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != s - 1) { // Exclude the distance of the starting node
                result.add(distances.get(i));
            }
        }
        return result; // Return the distances from the starting node to other nodes
    }
}
