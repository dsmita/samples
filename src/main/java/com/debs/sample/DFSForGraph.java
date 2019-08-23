package com.debs.sample;

import java.util.ArrayList;

public class DFSForGraph {

	static ArrayList<Node> nodes = new ArrayList<Node>();

	static class Node {
		int data;
		boolean visited;

		Node(int data) {
			this.data = data;

		}
	}

	public ArrayList<Node> findNeighbours(int adjancencyMatrix[][], Node x) {
		int nodeIndex = -1;
		ArrayList<Node> neighbours = new ArrayList<Node>();
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).equals(x)) {
				nodeIndex = i;
				break;
			}
		}
		if (nodeIndex != -1) {
			for (int j = 0; j < adjancencyMatrix[nodeIndex].length; j++) {
				if (adjancencyMatrix[nodeIndex][j] == 1) {
					neighbours.add(nodes.get(j));
				}
			}
		}
		return neighbours;
	}
	
	public void dfs(int adjancencyMatrix[][], Node node){
		ArrayList<Node> neighbors= findNeighbours(adjancencyMatrix, node);
		node.visited = true;
		for(int i=0; i< neighbors.size(); i++){
			Node n = neighbors.get(i);
			if(n != null && !n.visited){
				dfs(adjancencyMatrix, n);
			}
		}
	}

}
