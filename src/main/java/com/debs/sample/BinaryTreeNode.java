package com.debs.sample;

public class BinaryTreeNode {
	
	Integer data;
	BinaryTreeNode leftNode;
	BinaryTreeNode rightNode;
	int level;
	
	public BinaryTreeNode(Integer data, BinaryTreeNode leftNode, BinaryTreeNode rightNode){
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

}
