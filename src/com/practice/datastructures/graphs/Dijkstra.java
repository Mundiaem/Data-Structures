package com.practice.datastructures.graphs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

class UsingSet {
    /**
     * Set - store everything in ascending order
     * dist= [0,4,4,7,5,10]
     * set = [{#0,0},{#4,2},{#4,1},{*10,5}, {8,5},{7,3},{#5,4},]
     * erasing require - O(logn)
     * There are no super method of either set or PQ each has it own adva
     */
    static int[] dijkstra(int V, List<List<List<Integer>>> adj, int S) {
        Set<PairDijkstra> set = new HashSet<>();
        int[] dist = new int[V];
        set.add(new PairDijkstra(0, S));
        for (int i = 0; i < V; i++) {
            dist[i] = (int) 1e9;
        }
        dist[S] = 0;

        while (!set.isEmpty()) {
            Optional<PairDijkstra> pairDijkstra = set.stream().findFirst();
            int dis = pairDijkstra.get().distance;
            int node = pairDijkstra.get().node;
            //System.out.println("Distance :"+dis+ " node: "+ node);
            set.remove(pairDijkstra.get());// O(logn)
            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (dis + adjWeight < dist[adjNode]) {
                    dist[adjNode] = dis + adjWeight;
                    set.add(new PairDijkstra(dist[adjNode], adjNode));
                }
            }

        }

        return dist;
    }


}

class UsingPriorityQueue {
    /**
     * dist [] = {0,4,4,7,5,10,8}
     * min Heap{ dist, node} =[{0,0},{4,1},{4,2}, {7,3}, {5,4}, {10,5}, {8,5}]
     * Time Complexity
     * O(E log v) where E is the total number of edges and V is the total number of vertices
     * while(!pq.isEmpty()) -> total number of Vertices
     * {
     *          * ds.node = top() -> log(heap size){
     *                   *      * for (iterate adjacent list of nodes) -> number of edges of every node{
     *                   //nodes V-1
     *                       if(condition check){
     *                           update dist
     *                           push in PQ -O log(heap size)
     *                       }
     *                   }
     *          }
     * }
     * O(V x (pop vertex from the heap size+
     * no of edges on each vertex push into pQ)
     * O(V x (log (heap size) +no of edges x log (heap size))
     * O(V x (log (heap size) x (*ne (v-1) +1)
     * O(V*V * log(*heap size))
     * O(V^2 x log(heap size))
     * O(V^2 x log(V^2)) => (V^2 -> E (total number of edges))
     * O(V^2 x 2 log V)
     * O(E x 2 x log V) = O( E log V)
     *

     */


    static int[] dijkstra(int V, List<List<List<Integer>>> adj, int S) {
        //min-heap
        PriorityQueue<PairDijkstra> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = (int) 1e9;
        }
        dist[S] = 0;
        pq.add(new PairDijkstra(0, S));
        while (pq.size() != 0) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new PairDijkstra(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}

class PairDijkstra {
    int node;
    int distance;

    public PairDijkstra(int _distance, int _node) {
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
            System.out.println(" Ans to Dijkstra Algorithm Using Set : " + Arrays.toString(UsingSet.dijkstra(V, adj, 0)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
