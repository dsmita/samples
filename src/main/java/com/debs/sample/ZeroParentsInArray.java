package com.debs.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZeroParentsInArray {
	
	/*

	Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

	For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:
	            
	1   2   4
	 \ /   / \
	  3   5   8
	   \ / \   \
	    6   7   10

	Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.

	    
	Sample output (pseudodata):

	findNodesWithZeroAndOneParents(parentChildPairs) => [
	  [1, 2, 4],    // Individuals with zero parents
	  [5, 7, 8, 10] // Individuals with exactly one parent
	]


	 */
	public static void main(String[] args) {
	    
	    
	    
	    int[][] parentChildPairs = new int[][] {
	        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
	        {4, 5}, {4, 8}, {8, 10}
	    };

	    ZeroParentsInArray solution = new ZeroParentsInArray();
	    
	    System.out.println(solution.getNodes(parentChildPairs));
	}

	public List<ArrayList<Integer>> getNodes(int [][] arr){
	    int n = arr.length;
	    Set<Integer> allNodes = new HashSet<Integer>();
	    HashMap<Integer, Integer> parentMap = new HashMap<Integer,Integer>();
	    Set<Integer> secColumnNodes = new HashSet<Integer>();
	    Set<Integer> oneParentNodes = new HashSet<Integer>();
	    for(int i =0; i<n;i++){
	      for(int j=0;j<1;j++){
	        allNodes.add(arr[i][j]);
	      }
	    }
	    
		for (int i = 0; i < n; i++) {
			if (parentMap.containsKey(arr[i][1]))
				parentMap.put(arr[i][1], parentMap.get(arr[i][1]) + 1);
			else
				parentMap.put(arr[i][1], 1);
			secColumnNodes.add(arr[i][1]);
		}
	    
	    
	    
	   Collection<Integer> keys = parentMap.keySet();
	   for(Integer key: keys){
	    if(parentMap.get(key) ==1)
	      oneParentNodes.add(key);
	   }
	    
	    allNodes.removeAll(secColumnNodes);
	    List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> zeroParentList =  new ArrayList<Integer>();
	    ArrayList<Integer> oneParentList =  new ArrayList<Integer>();
	    zeroParentList.addAll(allNodes);
	    oneParentList.addAll(oneParentNodes);
	    result.add(0,zeroParentList);
	    result.add(1,oneParentList);
	    
	    return result;
	      
	  }
}
