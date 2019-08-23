package com.debs.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class CustomDirectedGraph2 {

	List<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

	public CustomDirectedGraph2(List<CustomEdge2> edges) {

		for (int i = 0; i < edges.size(); i++) {
			adj.add(i, new ArrayList<Integer>());
		}

		for (CustomEdge2 currentEdge : edges) {
			adj.get(currentEdge.getSrc()).add(currentEdge.getDest());
		}
	}

	public static void printGraph(CustomDirectedGraph2 graph) {
		int src = 0;
		int n = graph.adj.size();
		while (src < n) {
			for (int dest : graph.adj.get(src)) {
				System.out.println(src + " ---> " + dest + "\t");
			}
			src++;
		}
	}

	public static int getArrivalDepartureTime(CustomDirectedGraph2 graph, int v, boolean[] visited, int[] arrival,
			int[] departure, int time) {
		
		arrival[v] = ++time;
		visited[v] = true;
		for(int u: graph.adj.get(v)){
			time  = getArrivalDepartureTime(graph, u, visited, arrival, departure, time);
		}
		departure[v]=++time;
		return time;
	}
	
	public static void topologicalSort1(CustomDirectedGraph2 graph, int N){
		int[] departure =new int [2*N];
		boolean[] visited = new boolean [N];
		int time=0;
		int[] arrival = new int[N];
		
		for(int i=0;i<N;i++){
			if(!visited[i])
				time = topologicalSortUtil1(graph, i, visited, departure, arrival, time);
		}
	}

	private static int topologicalSortUtil1(CustomDirectedGraph2 graph, int v, boolean[] visited, int[] departure, int[] arrival, int time) {
		visited[v] = true;
		arrival[v] = ++time;
		for(int u:graph.adj.get(v)){
			time = topologicalSortUtil1(graph, u, visited, departure, arrival, time);
		}
		departure[time]=v;
		return time;
	}
	
	public static void topologicalSort2(CustomDirectedGraph2 graph, int N){
		boolean[] visited = new boolean[N];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<N;i++){
			if(!visited[i]){
				topologicalSortUtil2(graph, stack,visited, i);
			}
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop() + " ");
		}
	}

	private static void topologicalSortUtil2(CustomDirectedGraph2 graph, Stack<Integer> stack, boolean[] visited, int i) {
		visited[i]=true;
		for(int u:graph.adj.get(i)){
			topologicalSortUtil2(graph, stack, visited, u);
		}
		stack.push(new Integer(i));
	}
	
	public static void allTopologicalSort(CustomDirectedGraph2 graph, int N){
		boolean[] visited = new boolean[N];
		int[] indegree = new int[N];
		for(int i=0;i<N;i++){
			for(int u:graph.adj.get(i)){
				indegree[u]++;
			}
		}
		Stack<Integer> stack = new Stack<Integer>();
		allTopologicalSortUtil(graph, stack, visited, indegree, N);
	}

	private static void allTopologicalSortUtil(CustomDirectedGraph2 graph, Stack<Integer> stack, boolean[] visited,
			int[] indegree, int N) {
		boolean flag = false;
		for(int i=0;i<N;i++){
			if(!visited[i] && indegree[i] == 0){
				visited[i]= true;
				stack.add(i);
				for(int u:graph.adj.get(i)){
					indegree[u]--;
				}
				allTopologicalSortUtil(graph, stack, visited, indegree, N);
				
				//resetting
				visited[i] = false; 
                stack.remove(stack.size() - 1); 
                for (int u : graph.adj.get(i)) { 
                    indegree[u]++; 
                } 
  
                flag = true;
			}
		}
		
		/*if (!flag) { 
            for(Stack st:stack) 
            System.out.println(i + " "); 
        } */
	}
	
	public boolean isStronglyConnected(CustomDirectedGraph2 graph, int n){
		for(int i=0;i<n;i++){
			boolean[] visited = new boolean[n];
			isStronglyConnectedUtil(graph, i, visited);
			for(boolean flag:visited){
				if(!flag)
					return false;
			}
		}
		return true;
	}

	private void isStronglyConnectedUtil(CustomDirectedGraph2 graph, int v, boolean[] visited) {
		visited[v]=true;
		for (int i : graph.adj.get(v)) {
			if (!visited[i]) {
				visited[i] = true;
				isStronglyConnectedUtil(graph, i, visited);
			}
		}

	}
	
	public boolean isCyclic(CustomDirectedGraph2 graph, int n) {
		boolean[] visited = new boolean[n];
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				if (isCyclicUtil(graph, i, visited, set))
					return true;
			}
		}
		return false;
	}

	private boolean isCyclicUtil(CustomDirectedGraph2 graph, int v, boolean[] visited, Set<Integer> set) {
		visited[v] = true;
		set.add(v);
		for (int u : graph.adj.get(v)) {
			if (!visited[u]) {
				if (isCyclicUtil(graph, u, visited, set))
					return true;	
			} else if (set.contains(u)) {
				return true;
			}
		}
		set.remove(v);
		return false;
	}

	public static void main(String[] args) {
		List<CustomEdge2> edges = Arrays.asList(new CustomEdge2(0, 1), new CustomEdge2(1, 2), 
				 new CustomEdge2(3, 2), new CustomEdge2(4, 5));
		
		//new CustomEdge2(5, 4),new CustomEdge2(2, 1),new CustomEdge2(2, 0),

		CustomDirectedGraph2 graph = new CustomDirectedGraph2(edges);
		printGraph(graph);
		topologicalSort2(graph, 6);
		
		
				
		
	}

}
