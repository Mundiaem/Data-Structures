package com.practice.datastructures.topologicalsort;

import java.util.*;
import java.util.function.Consumer;
/*
* https://www.baeldung.com/java-depth-first-search
* https://dolphinscheduler.apache.org/en-us/blog/DAG.html
* https://github.com/dineshappavoo/DirectedAcyclicGraph/blob/master/src/dagshortestpath/DAGShortestPath.java
* https://www.sanfoundry.com/java-program-check-whether-graph-dag/
* https://www.geeksforgeeks.org/how-to-generate-a-random-directed-acyclic-graph-for-a-given-number-of-edges-in-java/
* https://www.hackerearth.com/practice/algorithms/graphs/topological-sort/tutorial/
* https://www.gatevidyalay.com/topological-sort-topological-sorting/
*
* */
public class DirectedAcyclicGraph<T> {

	private Map<T,Node<T>> nodes;
	private List<Node<T>> roots;
	DirectedAcyclicGraph(int src, int dest, int weight)
	{
		nodes = new LinkedHashMap<>();
		roots= new ArrayList<>();
}

/*
* Performs Depth-first search from roots and executes lambda on every node
*
* @param consumer lambda to be executed on nodes
* */

	public void visit(Consumer<Node<T>> consumer){
		Set<Node<T>> visited = new HashSet<>();
		for(Node<T> node: roots){
			consumer.accept(node);
			node.getChildren().forEach(n ->n.visit(consumer, visited));
		}
	}

	/*
	* Create node with given object
	*
	*@param object to create node with 
	* @return Node with given object 
	* */
	
	public Node<T> createNode(T object){
		Node<T> node= new Node<>(object);
		nodes.put(object, node);
		return node;
	}
	
	/*
	* Finds root nodes and checks for cycles 
	* @throws CycleFoundException if cycle is found
	* */
	
	public void update() throws  CycleFoundException{
		roots.clear();
		findRoots();
		checkForCycles();
	}
	/*
	 * checks if graph contains cycles
	 *
	 * @throws CycleFoundException if cycle is found
	 * */
	private void checkForCycles() {

		if (roots.isEmpty()&& nodes.size()>1)
			throw new CycleFoundException("No childless node found to be selected as root");
		List<Node<T>> cycleCrawlerPath = new ArrayList<>();
		for (Node<T> n: roots){
			checkForCycles(n, cycleCrawlerPath);
		}
	}

	private void checkForCycles(Node<T> n, List<Node<T>> cycleCrawlerPath) {
	if(cycleCrawlerPath.contains(n)){
		cycleCrawlerPath.add(n);
		throw new CycleFoundException(getPath(cycleCrawlerPath.subList(cycleCrawlerPath.indexOf(n),cycleCrawlerPath.size())));
	}
	cycleCrawlerPath.add(n);
	n.getParents().forEach(tNode -> checkForCycles(tNode, cycleCrawlerPath));
	cycleCrawlerPath.remove(cycleCrawlerPath.size()-1);

	}
	/*
	* @param parent Parent
	* @param child Child
	* */

	public void addEdge(T parent, T child){
		Node<T> parentNode= getNode(parent);
		Node<T> childNode= getNode(child);
		if(parentNode==null) parentNode= createNode(parent);
		if(childNode==null) childNode=createNode(child);
		parentNode.addChild(childNode);
	}

	public Node<T> getNode(T key){
		return nodes.get(key);
	}
	public Collection <Node<T>>getNodes(){
		return nodes.values();
	}

	private String getPath(List<Node<T>> path) {
 StringBuilder sb= new StringBuilder();
 for (int i=0; i<path.size()-1; i++){
	 sb.append(path.get(i).getObject().toString());
	 sb.append("->");
 }
 sb.append(path.get(path.size()-1).getObject().toString());
 return sb.toString();

	}

	private void findRoots() {
		for(Node<T> n: nodes.values()){
			if(n.getParents().size()==0){
				roots.add(n);
			}
		}
	}


	@Override
	public String toString() {
		return "DirectedAcyclicGraph{" +
				"nodes.size =" + nodes.size() +

				'}';
	}
}
