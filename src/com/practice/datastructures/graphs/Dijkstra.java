package com.practice.datastructures.graphs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

class UsingPriorityQueue {
    /**
     * dist [] = {0,4,4,7,5,10,8}
     * min Heap{ dist, node} =[{0,0},{4,1},{4,2}, {7,3}, {5,4}, {10,5}, {8,5}]
     * Time Complexity
     * O(E log v)
     */


    static int[] dijkstra(int V, List<List<List<Integer>>> adj, int S) {
        //min-heap
        PriorityQueue<PairPQ> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = (int) 1e9;
        }
        dist[S] = 0;
        pq.add(new PairPQ(0, 5));
        while (pq.size() != 0) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new PairPQ(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}

class PairPQ {
    int node;
    int distance;

    public PairPQ(int _distance, int _node) {
        this.distance = _distance;
        this.node = _node;
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        List<List<List<Integer>>> adj;
        try {
            Scanner in = new Scanner(new FileReader("src/com/practice/datastructures/graphs/input_pq.txt"));
            int V = in.nextInt();
            System.out.println(V);
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(i, new ArrayList<>());
            }


            while (in.hasNextInt()) {
                List<Integer> list = new ArrayList<>();

                list.add(in.nextInt());
                list.add(in.nextInt());
                list.add(in.nextInt());
                adj.get(list.get(0)).add(list.subList(1, 3));


            }
            System.out.println(adj.toString() + " ");
            System.out.println(" Ans to Dijkstra Algorithm Using Priority Queue : " + Arrays.toString(UsingPriorityQueue.dijkstra(V, adj, 0)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
