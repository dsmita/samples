package com.debs.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CustomUndirectedGraph {
	
	List<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>> ();
	
	public CustomUndirectedGraph(List<CustomEdge2> edges){
		for(int i=0;i<edges.size();i++){
			adj.add(i, new ArrayList<Integer>());
		}
		
		for(CustomEdge2 edge:edges){
			adj.get(edge.getSrc()).add(edge.getDest());
			adj.get(edge.getDest()).add(edge.getSrc());
		}
	}
	
	public CustomUndirectedGraph(List<CustomEdge2> edges, int n){
		for(int i=0;i<n;i++){
			adj.add(i, new ArrayList<Integer>());
		}
		
		for(CustomEdge2 edge:edges){
			adj.get(edge.getSrc()).add(edge.getDest());
			adj.get(edge.getDest()).add(edge.getSrc());
		}
	}
	
	public static void printGraph(CustomUndirectedGraph graph){
		int src=0;
		int n = graph.adj.size();
		
		while(src<n){
			for(int dest : graph.adj.get(src)){
				System.out.println(src+ " "+ dest);
			}
			src++;
		}
	}
	
	public static void DFS(CustomUndirectedGraph graph, int v, boolean[] visited){
		visited[v]=true;
		System.out.println("DFS "+ v + " ");
		for(int u :graph.adj.get(v)){
			if(!visited[u]){
				DFS(graph, u, visited);
			}
		}
	}
	
	public static void DFSIterative(CustomUndirectedGraph graph, int v, boolean[] visited){
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(v);
		
		while(!stack.isEmpty()){
			v=stack.pop();
			if(visited[v]){
				continue;
			}
			visited[v]=true;
			System.out.println(v + " ");
			
			List<Integer> adjList = graph.adj.get(v);
			for(int i=adjList.size()-1;i>=0;i++){
				int u = adjList.get(i);
				if(!visited[u]){
					stack.push(u);
				}
			}
		}
	}
	
	public static void recursiveBFS(CustomUndirectedGraph graph,Queue<Integer> q, boolean[] visited){
		if(q.isEmpty())
			return;
		int v= q.poll();
		System.out.println("BFS "+ v + " ");
		
		for(int u:graph.adj.get(v)){
			if(!visited[u]){
				visited[u] = true;
				q.add(u);
			}
		}
		recursiveBFS(graph, q, visited);
	}
	
	public static void BFS(CustomUndirectedGraph graph,int v, boolean[] visited){
		Queue<Integer> q = new LinkedList<Integer>();
		
		visited[v] = true;
		q.add(v);
		
		while(!q.isEmpty()){
			v = q.poll();
			System.out.println(v + " ");
			
			for(int u : graph.adj.get(v)){
				if(!visited[u]){
					visited[u]=true;
					q.add(u);
				}
			}
		}
		
	}
	
	public static boolean isBipartiteGraph(CustomUndirectedGraph graph, int v, boolean [] visited, boolean [] color){
		visited[v]=true;
		color[v]=true;
		for(int u:graph.adj.get(v)){
			if(!visited[u]){
				visited[u]= true;
				color[u]=!color[v];
				if(!isBipartiteGraph(graph, u, visited, color))
					return false;
			} else if(color[v]==color[u]){
				return false;
			}
		}
		return true;
	}
	
	//n- number of vertices
	public static boolean isCyclic(CustomUndirectedGraph graph) {
		int n = graph.adj.size();
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				if (isCyclic(graph, i, visited, -1))
					return true;
			}
		}
		return false;
	}

	// same for isTree - as long as it is undirected graph is acyclic, it will
	// be a tree.
	public static boolean isCyclic(CustomUndirectedGraph graph, int v, boolean[] visited, int parent) {
		visited[v] = true;
		for (int u : graph.adj.get(v)) {
			if (!visited[u]) {
				visited[u] = true;
				if (isCyclic(graph, u, visited, v))
					return true;
			} else if (u != parent) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		List<CustomEdge2> edges = Arrays.asList(new CustomEdge2(0,1), new CustomEdge2(1,2),
				new CustomEdge2(1,7),new CustomEdge2(1,8),new CustomEdge2(2,3),
				new CustomEdge2(2,6),new CustomEdge2(3,4), new CustomEdge2(3,5),new CustomEdge2(8,9),
				new CustomEdge2(8,12),new CustomEdge2(9,10),new CustomEdge2(9,11));
		
		final int n = 13;
		
		CustomUndirectedGraph graph = new CustomUndirectedGraph(edges, n);
		printGraph(graph);
	
		boolean [] visited = new boolean[n];
		
		/*for(int i=0;i<n;i++){
			if(!visited[i])
				DFS(graph, i, visited);
		}*/
		
		/*Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=0;i<n;i++){
			if(!visited[i]){
				visited[i]= true;
				q.add(i);
				recursiveBFS(graph, q, visited);
			}
		}*/
		
		int v=0;
		BFS(graph, v, visited);
		
		
		
	}

}
