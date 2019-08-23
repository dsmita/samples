package com.debs.sample;

public class ConvertTreeToSumTree {
	
	public int solution(BinaryTreeNode node){
		if(node == null)
			return 0;
		
		int old_ref =node.data;
		node.data = solution(node.leftNode) + solution(node.rightNode);
		return node.data +old_ref;
	}

}
