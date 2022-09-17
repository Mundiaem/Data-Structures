package com.practice.datastructures.topologicalsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created with love by mundiaem
 * created on 16/09/2022
 * Time: 11:50
 * ⚡  - Data-Structures
 */

public class TopoSortDAG {

    Stack<N> customStack;


    public TopoSortDAG(){
        customStack= new Stack<N>();
    }

     static class N{
        int d;
        boolean isVisited;
        List<N> nghbr;
        N(int d){
            this.d= d;
            this.nghbr= new ArrayList<>();
        }


        public void adj(N nghbrN){
            this.nghbr.add(nghbrN);
        }


        public List<N> getNghbr(){
            return nghbr;
        }

        public void setNghbr(List<N> nghbr){
            this.nghbr= nghbr;
        }

        public String toString(){
            return " "+d;
        }
     }

     public void tpSort(N n){
        List<N> nghbr= n.getNghbr();
        for(int i=0; i<nghbr.size(); i++){
            N n_= nghbr.get(i);
            if(n_!=null && !n.isVisited){
                tpSort(n_);
                n_.isVisited= true;
            }
        }
        customStack.push(n);
     }
}
