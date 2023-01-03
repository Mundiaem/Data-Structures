package com.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public static List<List<Integer>> createGraph(){
       /*
       * 0 -> {}, 1 -> {2,6}, 2-> {1,3,4} , 3-> {2}, 4-> {2,5}, 5-> {4,8}, 6-> {7,9}, 7-> {6,8}, 8->{5,7}, 9->{6}
       *Time Complexity
       * - While (!Q.isEmpty()) > for(all nodes/ 2 edges per node) =>( O(N) + 2(E))
       * Space Complexity
       * O(3N) => O(N)
       * */
        List<List<Integer>>adjList= new ArrayList<>();



        //edge 1
        adjList.get(1).add(2);
        adjList.get(1).add(6);

        //edge 2
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(2).add(4);

        //edge 3
        adjList.get(3).add(2);

        //edge 4
        adjList.get(4).add(2);
        adjList.get(4).add(5);

        //edge 5
        adjList.get(5).add(4);
        adjList.get(5).add(8);

        //edge 6
        adjList.get(6).add(7);
        adjList.get(6).add(9);

        //edge 7
        adjList.get(7).add(6);
        adjList.get(7).add(8);

        //edge 8
        adjList.get(8).add(5);
        adjList.get(8).add(7);

        //edge 9
        adjList.get(9).add(6);

        return adjList;

    }
}
