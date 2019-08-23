package com.debs.sample;

public class SumTree {
	
	public boolean isSumTree(BinaryTreeNode node){
		
		if(node == null)
			return true;
		
		if(node.leftNode == null && node.rightNode == null)
			return false;
		
		int ls = node.leftNode.data;
		int rs = node.rightNode.data;
		
		if(node.data == ls+rs && isSumTree(node.leftNode) && isSumTree(node.rightNode))
			return true;
		
		return false;
		
	}

}
