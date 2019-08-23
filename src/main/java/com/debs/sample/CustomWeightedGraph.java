package com.debs.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomWeightedGraph {
	
	List<ArrayList<CustomWeightedNode>> adj = new ArrayList<ArrayList<CustomWeightedNode>>();
	
	public CustomWeightedGraph(List<CustomWeightedEdge> edges){
		
		for(int i=0;i<edges.size();i++){
			adj.add(i, new ArrayList<CustomWeightedNode>());
		}
		
		for(CustomWeightedEdge edge:edges){
			adj.get(edge.src).add(new CustomWeightedNode(edge.dest,edge.weight));
		}
		
	}
	
	public static void printGraph(CustomWeightedGraph graph){
		int src=0;
		int n= graph.adj.size();
		
		while(src<n){
			for(CustomWeightedNode edge:graph.adj.get(src)){
				System.out.println(src + " ---->  "+ edge.value + " "+ edge.weight );
			}
			src++;
		}
	}
	
	public static void main(String[] args) {
		List<CustomWeightedEdge> edges =Arrays.asList(new CustomWeightedEdge(0,1,6), 
				new CustomWeightedEdge(1,2,7),new CustomWeightedEdge(2,0,5),
				new CustomWeightedEdge(2,1,4),new CustomWeightedEdge(3,2,10),
				new CustomWeightedEdge(4,5,1), new CustomWeightedEdge(5,4,3));
		
		CustomWeightedGraph graph = new CustomWeightedGraph(edges);
		printGraph(graph);
	}

}
