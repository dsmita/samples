package com.debs.sample;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {
	
	public boolean solution(TreeNode node, TreeNode search){
		if(node == null)
			return false;
		Set<Integer> visitedSet = new HashSet<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if(node.data == search.data){
			visitedSet.add(node.data);
			return true;
		}else{
			stack.push(node);
			if(stack!= null){
				TreeNode nodeToBeRemoved = stack.pop();
				if (nodeToBeRemoved != null) {
					visitedSet.add(nodeToBeRemoved.data);
					if (nodeToBeRemoved.data == search.data)
						return true;
					List<TreeNode> nodeList = nodeToBeRemoved.nodes;
					if (nodeList != null) {
						for (TreeNode nodeL : nodeList) {
							if (!visitedSet.contains(nodeL.data)) {
								stack.push(nodeL);
								visitedSet.add(nodeL.data);
							}
						}
					}
				}
			
			}
		}
		
		return false;
	}

}
