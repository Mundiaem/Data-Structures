package com.practice.datastructures.topologicalsort;

import java.util.Stack;

/*
* https://www.interviewcake.com/concept/c/topological-sort
*
* */
public class TopologicalSort {
    public static void ImplTopSortDAG(){
        TopoSortDAG topo= new TopoSortDAG();
        TopoSortDAG.N n20= new TopoSortDAG.N(20);
        TopoSortDAG.N n5= new TopoSortDAG.N(5);
        TopoSortDAG.N n10= new TopoSortDAG.N(10);
        TopoSortDAG.N n15= new TopoSortDAG.N(15);
        TopoSortDAG.N n30= new TopoSortDAG.N(30);
        TopoSortDAG.N n25= new TopoSortDAG.N(25);
        TopoSortDAG.N n35= new TopoSortDAG.N(35);


        n20.adj(n5);
        n20.adj(n10);
        n5.adj(n15);
        n10.adj(n5);
        n10.adj(n15);
        n10.adj(n30);
        n10.adj(n25);
        n15.adj(n30);
        n30.adj(n35);
        n25.adj(n35);


        System.out.println("Sorting result set based on the graph");


        topo.tpSort(n20);
        Stack<TopoSortDAG.N> res= topo.customStack;
        while(!res.isEmpty()){
            System.out.println(res.pop() + " ");
        }



    }

    public static  void implTopologicalSort(){
        Graph g = new Graph();
        GraphNode node = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);

        node.addNeighbor(2);
        node2.addNeighbor(3);
        node4.addNeighbor(3);

        g.addNode(node);
        g.addNode(node2);
        g.addNode(node3);
        g.addNode(node4);

        System.out.println(g);





    }

}
