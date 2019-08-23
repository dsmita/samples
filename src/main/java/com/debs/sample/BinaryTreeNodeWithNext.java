package com.debs.sample;

public class BinaryTreeNodeWithNext {

	BinaryTreeNodeWithNext next;
	Integer data;
	BinaryTreeNodeWithNext leftNode;
	BinaryTreeNodeWithNext rightNode;
	int level;

	public BinaryTreeNodeWithNext(Integer data, BinaryTreeNodeWithNext leftNode, BinaryTreeNodeWithNext rightNode) {
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

}
