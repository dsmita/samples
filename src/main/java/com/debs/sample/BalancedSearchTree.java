package com.debs.sample;

public class BalancedSearchTree {
	
	int MAX_INT = 100000;
	int MIN_INT = -100000;
	
	public boolean ifBST(BinaryTreeNode node){
		return isBST(node, MIN_INT, MAX_INT);
	}

	private boolean isBST(BinaryTreeNode node, int min, int max) {
		if(node == null)
			return true;
		if(node.data < min || node.data > max)
			return false;
		
		return (isBST(node.leftNode, MIN_INT, node.data) && isBST(node.rightNode, node.data, MAX_INT));
	}
	
	

}
