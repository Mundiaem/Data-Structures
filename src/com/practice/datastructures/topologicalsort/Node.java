package com.practice.datastructures.topologicalsort;

import java.util.*;
import java.util.function.Consumer;

//Graph
public class Node<T> {
    //node of the adjacency graph

    private List<Node<T>> parents;
    private List<Node<T>> children;
    private T object;

    Node(T object) {
        this.object = object;
        parents = new LinkedList<>();
        children = new LinkedList<>();
    }

    /**
     * Performs Depth first search on children and executes lamda on every node
     *
     * @param consumer lambda to be execute on nodes
     **/
    public void visit(Consumer<Node<T>> consumer) {
        Set<Node<T>> visited = new HashSet<>();
        consumer.accept(this);
        for (Node<T> node : children) {
        consumer.accept(node);
        node.getChildren().forEach(n->n.visit(consumer, visited));
        }
    }

    void visit(Consumer<Node<T>> consumer, Set<Node<T>> visited) {
consumer.accept(this);
visited.add(this);
for (Node<T>node :children){
    if(visited.contains(node)) continue;
    node.visit(consumer, visited);
}
    }

    public List<Node<T>> getParents() {
        return parents;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public T getObject() {
        return object;
    }

    public void addParents(Node<T>... parents) {
        for (Node<T>n :parents){
            addParent(n);
        }

    }

    public void addChild(Node<T> child){
    if(child==this) throw new CycleFoundException(this.toString()+"->"+this.toString());
    children.add(child);
    if (child.getParents().contains(this)) return;
    child.addParent(this);
    }

    public void addChildren(Node<T>... children) {
for (Node<T> n: children){
    addChild(n);
}
    }
    public void addParent(Node<T> parent){
        if(parent== this) throw new CycleFoundException(this.toString()+ "->"+this.toString());
        parents.add(parent);
        if(parent.getChildren().contains(this))return;
        parent.addChild(this);
    }

    @Override
    public String toString() {
        return "Node{" +
                "parents=" + parents +
                ", children=" + children +
                ", object=" + object +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Node)
            return object.equals(((Node<T>) o).getObject());
        else return false;
    }


}
